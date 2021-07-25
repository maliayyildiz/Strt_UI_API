# Strt_UI_API
Hello 
I have worked on 3 tasks, mobile, web app and api.
I would like to share my approach how I worked on. 
I want to start with my framework. I build my framework using Selenium WebDriver for browser automation, 
Maven for dependencies and TestNG for testing tools. I stored my source codes in “main directory” and test codes is in “test directory”. 
I used Page Object Model (POM) in my framework to centralise and maintain my scripts easily. 
I created Java classes to store all web element for each page of Application and put them in “pages” packages.
I stored  my test data to “configuration.properties” file that I can use in my scripts trough ConfigurationReader class.
I also used Singleton Pattern for driver. I create one single driver and used it across in my framework and I store it in Driver class. 
I created ReusableMethods class where I store all customise methods which I created and used in my syntax
it makes my framework more clean and organised and maintainable.  I created two test packages one of them for UI testing, 
the other one for API testing. 
For WebApp I did happy test. As a user I logged in to the app and create a job by setting pickup and drop off location.
I costumised methods which user can select nearest transport type or cheapest transport type. 
I created another method which help me to validate delivery status like “System assigned a courier” and “The item is dropped off to the location” and “Job Done”. 
And I validated Job done successfully with Job id on History Page.

For Api I study API documentation it is very clear and very useful. I used same framework with Web app (TestNG framework) for API testing. I used restful, rest assured library,
I used JsonPath for deserialisation. I validated  data with soft assert. I did manual and automated test with postman and also I did with Java codes.
I write data to txt file from data base and read them from txt file and used in my codes according to my test case.  
And as a test case I created a job successfully but  I  could not updated job which created.  I found a bug.  *

For Mobile Test I build a BDD framework with Cucumber.I used APPIUM as a mobile testing tool, Page Object Model (POM), 
Maven for dependencies and plugins, I created Java classes for each page of my application to store all mobile elements there. 
I write my steps in feature file where I can use Gherkin language which makes my scenario my understandable even non- technical 
people can understand from my scenario. I implemented my scenario’s steps in my step definitions classes where I can write my Java codes.  
I store my test data in configuration.properties file and used those data in my syntax trough ConfigurationReader class. 
I run my scenarios from runner class to get cucumber report which gives details of each steps and screenshots when scenarios failed. 
I selected test case as cancellation of job. 
But I have blocker I could not finish my task when I reach to deliveries page where I can cancel the job. 
It is throwing NullPointerException and stop execution. :( And I used some  Thread.sleep() because Appium execution is slow and working with multiple tools makes my computer more slower like Android emulator together IntelliJ and Appium server… Unfortunately I could not get a time to finished my mobile test task  because system is not allow me to test during night which I have free time to work on the tasks.   * I found two bugs. Both of them is  legitimate bug, one for  Web app and mobile and other one for backend. 
As a user can can not access with valid credentials to the application. System wants to access location of device and even you allowed to access location some times I can not access with valid credentials.
I attached screenshoot for this bug.
Second bug from backend, can not update drop of company value using api endpoint. I also attached this screenshot.
