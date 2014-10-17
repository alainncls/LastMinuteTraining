LastMinuteTraining
=========

LastMinuteTraining is a JEE project enabled by the Hibernate ORM  MYSQL Database. 
The goal of this project is to provide a last minute training reservation interface for SAP ERP through B2B interactions.

> This project is a collaboration between these [EPF] 5A MSI members and [Spring Medias]:

  - Alain Nicolas
  - Vivien Auguy
  - Paul Renaudat
  - Romain Balaine
  - Baptiste Vignal

Version
----

   1.0
  > Home page and add Training interfaces created.

Technology
-----------

LastMinuteTraining uses a number of open source projects to work properly:

* [Apache Tomcat Server] - for hosting the application locally
* [JEE] - Java Enterprise edition
* [Eclipse] - A great Open source editor
* [Java 8] - The most recent Java runtime environment / JVM
* [MongoDB] - Awesome no-SQL database
* [Python 3.4] - A useful language for server-side task scheduling
* [LXML] - One of the best webscraping tools out there

Installation
--------------

```git
git clone https://github.com/alainncls/LastMinuteTraining/
```
###Step1 : Install python3.4
```bash
sudo apt-get install python3.4
```
###Step2 : Install pip for python3.4
```bash
sudo apt-get install python3-pip
```
###Step3 : install python libs : lxml
```bash
pip3 install lxml
```

###Step4 : Schedule task to run every 0 minutes 3 hours every day every week every month
```bash
sudo crontab -e
0 3 * * * cd /pathToMaster.sh/ && bash master.sh
```
##### Configure Tomcat Server 8.0.x

* Make sure the JRE is Java 8+ enabled



License
----
**Free Software, Hell Yeah!**



[EPF]:http://www.epf.fr
[Spring Medias]:http://www.springmedias.com/
[Apache Tomcat Server]:tomcat.apache.org/
[JEE]:http://fr.wikipedia.org/wiki/Java_EE
[Eclipse]:http://www.eclipse.org
[Java 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[MongoDB]:http://www.mongodb.com/
[Python 3.4]:https://www.python.org/
[LXML]:http://lxml.de
