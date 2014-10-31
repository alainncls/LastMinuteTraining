# -*- coding: utf-8 -*-
#This script is an iterative and incremental webscraper for TRAINING.SAP.COM 
#Reserved for educaitonal use ONLY
#DON'T TRY THIS @ HOME KIDS
#Manage Imports
import datetime
import calendar
import datetime
import lxml
import lxml.html
from lxml import etree
import subprocess
import re
import json
import pymongo
from pymongo import MongoClient
bug=0
#def dicts
month_dic={v: k for k,v in enumerate(calendar.month_abbr)}
data=[]
#Define source of information
source="https://training.sap.com"
#set current date--local-encoding=utf-8
now=datetime.datetime.now().strftime("%Y-%m-%d")
#to get next months stuff
last_day_of_current_month = calendar.mdays[datetime.date.today().month]
next=datetime.datetime.now().replace(day=last_day_of_current_month)+ datetime.timedelta(days=1)
next=next.strftime("%Y-%m-%d")
#Setting Urls for this month and next month
thisMonth='https://training.sap.com/shop/training-schedules'
nextMonth='https://training.sap.com/shop/training-schedules?start_date='+next
#Downloading pages containing the calendars
subprocess.call(['wget',thisMonth,'-q','--secure-protocol=sslv3'])
subprocess.call(['wget',nextMonth,'-q','--secure-protocol=sslv3'])
#Parsing for links
thisCalendar = lxml.html.parse("training-schedules")
nextCalendar = lxml.html.parse("training-schedules?start_date="+next)
links=[]
names=[]
dates=[]
locations=[]
prices=[]
#Get this months trainings
for training in thisCalendar.xpath("//div[@class='span3']/a/@href"):
	links.append(source+training)
for name in thisCalendar.xpath("//div[@class='span3']/a/span"):
	names.append(name.text_content().strip().replace(" ","_").replace("/","-"))
for date in thisCalendar.xpath("///*[@id='main']/div[2]/div[2]/ul/li/div/div/h2/div[2]/span/text()"):
	dates.append(date)
for price in thisCalendar.xpath("//*[@id='main']/div[2]/div[2]/ul/li/div/div/h2/div[5]/span/text()"):
	prices.append(price.strip().split("\n")[0].strip())
for location in thisCalendar.xpath("//*[@id='main']/div[2]/div[2]/ul/li/div/div/h2/div[3]/span/text()"):
	locations.append(location.strip())
#delete this months trainings
subprocess.call(['rm',"training-schedules"])
#get next months trainings
for training in nextCalendar.xpath("//div[@class='span3']/a/@href"):
	links.append(source+training)
for name in nextCalendar.xpath("//div[@class='span3']/a/span"):
	names.append(name.text_content().strip().replace(" ","_").replace("/","-"))
for date in nextCalendar.xpath("///*[@id='main']/div[2]/div[2]/ul/li/div/div/h2/div[2]/span/text()"):
	dates.append(date)
for price in nextCalendar.xpath("//*[@id='main']/div[2]/div[2]/ul/li/div/div/h2/div[5]/span/text()"):
	prices.append(price.strip().split("\n")[0].strip())
for location in nextCalendar.xpath("//*[@id='main']/div[2]/div[2]/ul/li/div/div/h2/div[3]/span/text()"):
	locations.append(location.strip())
#delete next months trainings
subprocess.call(['rm',"training-schedules?start_date="+next])
#DUPLICATE CONTROL
sortedLinks = []
sortedNames = []
sortedDates = dates
toBeDeleted = []
sortedPrices = prices
sortedLocations = locations
count=0
for i in links:
	if i not in sortedLinks:
		sortedLinks.append(i)
	else:
		toBeDeleted.append(count)
	count+=1
for x in reversed(toBeDeleted):
	sortedDates.pop(x)
	sortedPrices.pop(x)
	sortedLocations.pop(x)
	
for i in names:
	if i not in sortedNames:
		sortedNames.append(i)
#iterate the list of trainings
counter=0
for link in sortedLinks:
	#print("getting "+link)
	#get training description page
	subprocess.call(['wget',link,'-q','-O',"var/"+sortedNames[counter],'--secure-protocol=sslv3'])
	startDay=date=sortedDates[counter].split("-")[0].split(" ")[0]
	startMonth=month_dic[sortedDates[counter].split("-")[0].split(" ")[1].strip()]
	endDateAndYear=sortedDates[counter].split("-")[1].strip().split(" ")
	endDay=endDateAndYear[0]
	endMonth=month_dic[endDateAndYear[1]]
	year=endDateAndYear[2]
	endDate=endDay+"-"+str(endMonth)+"-"+year
	startDate=startDay+"-"+str(startMonth)+"-"+year
	training={'date':{'startDate':startDate,'endDate':endDate},'location':sortedLocations[counter],'price':sortedPrices[counter],'url':link}
	parsedPage=lxml.html.parse('var/'+sortedNames[counter])
	#get the level and name : top-left panel : WORKS
	for level in parsedPage.xpath("//p[contains(@class,'course-level')]"):
		#get level
		level.text_content().strip()
		training["level"]=re.search(r'level-.', level.get('class')).group()[-1]
		#get name
		training["name"]=level.getparent().text_content().strip().splitlines()[0]
	#parse the top-right panel
	dddt={"dd":[],"dt":[]}
	for x in parsedPage.xpath(".//dt"):
		dddt["dt"].append(x.text.lower().strip().replace(":","").replace(" ","-"))
	for x in parsedPage.xpath(".//dd"):
		try:
			dddt["dd"].append(x.text.strip())
		except:
			continue
	print(training["url"])
	for i in range(len(dddt["dd"])):
		if dddt["dt"][i] != "duration":
			training[dddt["dt"][i]]=dddt["dd"][i]
		else:
			training[dddt["dt"][i]]={'unit':dddt["dd"][i].split(" ")[1],'count':dddt["dd"][i].split(" ")[0]}	
	#training["length"]={'value':length[0],'type':length[1]}
	##TODO : GET THE SOLUTION TYPE and language properly
	training["language"]=parsedPage.xpath("//dd")[3].text_content().strip()
	#Series of try-catches, corresponding to description which may or may not occur
	#Get the course announcement if it exists 
	try:
		training["course-announcement"]=parsedPage.xpath(".//*[.= 'Course announcements']/following-sibling::ul/li/text()")[0]
	except:
		training["course-announcement"]="No announcement"

	#Try to get audience list : WORKS
	audienceList=[]
	try:
		for audience in parsedPage.xpath(".//*[. = 'Audience']/following-sibling::ul[1]/li/text()"):
			audienceList.append(audience)
	except:
		continue
	training["audience"]=audienceList
	#try to get software-release : WORKS
	try:
		releaseList=[]
		for release in parsedPage.xpath(".//*[. = 'Course based on software release']/following-sibling::ul/li/text()"):
			releaseList.append(release) 
		training["release"]=releaseList
	except:
		training["release"]=[]
	#try to get content list : WORKS
	try:
		contentList={}
		#Get first layer Li
		ulli=0
		for content in parsedPage.xpath(".//*[. = 'Content']/following-sibling::ul[1]/li/text()"):
			contentList[content]=[]
			try:
				for ul in parsedPage.xpath(".//*[. = 'Content']/following-sibling::ul[1]/li/following-sibling::ul")[ulli]:		
					contentList[content].append(ul.text_content())
			except:
				bug+=1
			ulli+=1
		training["content"]=contentList
	except:
		training["content"]=[]
	#try to get prerequisites : WORKS
	reqList={}
	#Essentials	
	try:
		essential=[]
		#get reqs without href
		for req in parsedPage.xpath(".//*[. = 'Essential']/following-sibling::ul[1]/li[ count(*)=0]/text()"):
			essential.append({'requirement':req})
		#get reqs with href :)
		tempreqs={'url':[],'url_text':[],'text':[]}
		for req in parsedPage.xpath(".//*[. = 'Essential']/following-sibling::ul[1]/li[ count(*)>0]/a/@href"):
			tempreqs["url"].append(req)
		for req in parsedPage.xpath(".//*[. = 'Essential']/following-sibling::ul[1]/li[ count(*)>0]/a/text()"):
			tempreqs["url_text"].append(req)	
		#for req in parsedPage.xpath(".//*[. = 'Essential']/following-sibling::ul[1]/li[ count(*)>0]/text()"):
			#["text"].append(req)	
		cpt=0
		for shit in tempreqs["url"]:
			tempreq={'requirement':{'url_text':tempreqs["url_text"][cpt],'url':tempreqs["url"][cpt]}}
			cpt+=1
			essential.append(tempreq)
	except:
		essential=[]
	reqList["essential"]=essential
	#Get Recommended
	try:
		recommended=[]
		#get reqs without href
		for req in parsedPage.xpath(".//*[. = 'Recommended']/following-sibling::ul[1]/li[ count(*)=0]/text()"):
			recommended.append({'requirement':req})
		#get reqs with href :)
		tempreqs={'url':[],'url_text':[],'text':[]}
		for req in parsedPage.xpath(".//*[. = 'Recommnded']/following-sibling::ul[1]/li[ count(*)>0]/a/@href"):
			tempreqs["url"].append(req)
		for req in parsedPage.xpath(".//*[. = 'Recommended']/following-sibling::ul[1]/li[ count(*)>0]/a/text()"):
			tempreqs["url_text"].append(req)	
		for req in parsedPage.xpath(".//*[. = 'Recommended']/following-sibling::ul[1]/li[ count(*)>0]/text()"):
			tempreqs["text"].append(req)	
		cpt=0
		for shit in tempreqs["url"]:
			tempreq={'requirement':{'url_text':tempreqs["url_text"][cpt],'text':tempreqs["text"][cpt],'url':tempreqs["url"][cpt]}}
			cpt+=1
			recommended.append(tempreq)
	except:
		recommended=[]
	reqList["recommended"]=recommended
	#insert in pre-json
	training["prerequisites"]=reqList
	#try to get Notes : WORKS
	try:
		notesList=[]
		for note in parsedPage.xpath(".//*[. = 'Notes']/following-sibling::ul[1]/li/text()"):
			notesList.append(note)
		training["notes"]=notesList
	except:
		training["notes"]=[]
	#try to get description : WORKS
	try:
		training["description"]=parsedPage.xpath("//div[@class='tab-content']/div[@class='tab-pane active']/div[@class='row-fluid']/div[@class='span6']/ul/li")[0].text_content().strip()
	except:
		training["description"]="No description available"
	training["evaluation"]=parsedPage.xpath("//dd")[4].text_content().strip()
	#get the related-curricula
	#first find the redirection link
	redir=parsedPage.xpath("//ul[@class='nav nav-tabs']/li/a/@href")[3]
	subprocess.call(['wget',source+redir,'-q','-O','relatedCurriculum','--secure-protocol=sslv3'])
	parsedCurricula=lxml.html.parse('relatedCurriculum')
	#then get the link(s)
	relatedCurricula=[]
	for relatedCurriculum in parsedCurricula.xpath("//ul[@class='nav nav-list']/li/a/@href"):
		subprocess.call(['wget',source+relatedCurriculum,'-q','-O','diagram','--secure-protocol=sslv3'])
		try:		
			parsedImagePage=lxml.html.parse('diagram')
		except:
			continue
		try:
			relatedCurricula.append(parsedImagePage.xpath("//img[@id='curriculum-map']/@src")[0].replace("ECOM3","ECOM2"))
		except:
			print("bug on image.... SAP MOAR LIKE SPA")		
	training["relatedCurricula"]=relatedCurricula
	data.append(training)
	try:
		subprocess.call(['rm','diagram'])
	except:
		continue
	subprocess.call(['rm','relatedCurriculum'])
	subprocess.call(['rm','var/'+sortedNames[counter]])
	counter+=1
	#print(json.dumps(training,ensure_ascii=False))
	print(str(counter/len(sortedLinks)*100)+"%")
print(json.dumps(data))
with open("nouveauJSON", "w") as outfile:
    json.dump(data, outfile, indent=4,ensure_ascii=False)
