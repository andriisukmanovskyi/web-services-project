# tomcat installing

To deploy web-services on server, download tomcat zip file from the Internet or from this repository and unzip it to any folder.


# services deploying

Build 'AndriiSukmanovskyiService' project from console using maven command 'mvn clean install'.
Get the war file from project target directory and copy it to unziped tomcat folder: 'apache-tomcat-8.5.34\webapps'.
Go to 'apache-tomcat-8.5.34\bin' and run 'startup.bat' file. Server will be running.


# test execution

To run all test (SOAP and REST clients) use maven command 'mvn clean test'.
To run only SOAP client tests use maven command 'mvn -Dtest=SOAPCalculatorClientTest test'.
To run only REST client tests use maven command 'mvn -Dtest=RESTCalculatorClientTest test'.


# testing reports

To see testing reports go to 'web-services-project\AndriiSukmanovskyiClient\target\surefire-reports' directory and run 'index.html'.


# 
If there are any quastions, you can connect with me via Skype.
