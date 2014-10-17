import lxml
import lxml.html
from lxml import etree
import subprocess
import re
import json
#Get the list of roles
baseurl='https://training.sap.com'
subprocess.call(['wget','https://training.sap.com/shop/catalogue/by-role','-q','--secure-protocol=sslv3'])
roleListPage = lxml.html.parse("by-role")
#For each role, get the url where are the trainings are stored
for x in roleListPage.xpath("//div[@class='expander columns2']/div[@class='expander-content']/ul[@class='nav']//li//a/@href"):
	#get the name of the file that will be saved
	role=x.split('/shop/catalogue/by-role/')[1]
	req='?TimeFrame=LT1'
	subprocess.call(['wget',baseurl+x+req,'-q','--secure-protocol=sslv3'])
	roleList=lxml.html.parse(role+req)
	formations=[]
	for listEl in roleList.xpath("//a[@class='subtle-link']"):
		name=listEl.text_content().strip().replace(" ","_")
		trainingURL=baseurl+listEl.get('href')
		subprocess.call(['wget','-O'+name,trainingURL,'-q','--secure-protocol=sslv3'])
		trainingPage = lxml.html.parse(name)
		#get level, name and code
		formation={"role":role,"url":trainingURL}
		for training in trainingPage.xpath("//p[contains(@class,'course-level')]"):
			trainingCode=training.text_content().strip()
			match = re.search(r'level-.', training.get('class'))
			formation["level"]=match.group()
			formation["name"]=listEl.text_content().strip()
		formation["solution"]=training.xpath("//dd")[0].text_content().strip()
		formation["type"]=training.xpath("//dd")[1].text_content().strip()
		formation["textLevel"]=training.xpath("//dd")[2].text_content().strip()
		formation["length"]=training.xpath("//dd")[3].text_content().strip()
		formation["description"]=training.xpath("//div[@class='tab-content']/div[@class='tab-pane active']/div[@class='row-fluid']/div[@class='span6']/ul/li")[0].text_content().strip()
		domains=training.xpath("//div[@class='accordion-heading']/h3")
		domainList=[]
		for domain in domains:
			domainList.append(domain.text_content())
		formation["domains"]=domainList
		#seperate page for price and date pages....
		#get price and dtp (date time place)
		subprocess.call(['wget','-O'+name+'%2Fset-course',trainingURL+'set-course','-q','--secure-protocol=sslv3'])
		pricePage = lxml.html.parse(name+'%2Fset-course')
		dates=[]
		#Get price
		for price in pricePage.xpath("//h2[@class='price']"):
			formation["price"]=price.text_content().split('\n')[2].strip()
		for dtp in pricePage.xpath("//label[@class='radio']"):
			date = re.sub("\n\s*\n*", "\n", dtp.text_content())
			splitdate=date.split('\n')
			dateobj = {'date': splitdate[1], 'place': splitdate[2], 'collection':splitdate[3]}
			dates.append(dateobj)			
		formation["dates"]=dates
		with open('data.txt', 'w') as outfile:
  			json.dump(formation, outfile)
		#json.dumps(formation)
		subprocess.call(['rm',name+'%2Fset-course'])
		formations.append(formation)
	subprocess.call(['rm',role+req])

subprocess.call(['rm','by-role'])
