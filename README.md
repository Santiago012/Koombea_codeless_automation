# Koombea's QA department API automation challenge solved with codeless automation

## Overview
The readme contains the following information:
1. Information about the API chosen for the challenge
2. Tests made for the API challenge
3. How to run katalon tests using the console

## Bored API

The app used is the bored APi which gives the user a random activity to do, it can also use specific queries to get an activity with specifics atributes:
1. API link: https://www.boredapi.com/
2. API Documentation: https://www.boredapi.com/documentation
3. All the app requests are made using the GET request  

## Tests

The tests were made using groovy a lengauge based on java made by apache and they were developed using the IDE Katalon Studio as part of the initiative of codeless automation. All tests are based on the idea that the endpoint receives a random value that then is used on the request and later an attribute of the payload is validated. The tests developed are the following:

1. Given a random "key" atribute verifiy if that key correspond to an activity 
2. Given a random activity verify if that activity is free.  
3. Given a random activity verifiy if that activity is part of the type "education"
4. Given a random activity verifiy if that activity is part of the type "recreational"
5. Given a random activity verifiy if that activity is part of the type "social"
6. Given a random activity verifiy if that activity is part of the type "diy"
7. Given a random activity verifiy if that activity is part of the type "charity"
8. Given a random activity verifiy if that activity is part of the type "cooking"
9. Given a random activity verifiy if that activity is part of the type "relaxation"
10. Given a random activity verifiy if that activity is part of the type "music"
11. Given a random activity verifiy if that activity is part of the type "busywork"
12. Given a random activity verify if that activity can be done by myself
13. Given a random activity verifiy if that activity is between a random price range  

**Aditionally each test verify the following information:**
1. Validate that each request code is 200
2. Validate that each payload body is not null

## How to run katalon tests using the console

1. Clone or save the katalon project in your computer
2. Go to the following link https://katalon.com/download/ and create an account then download the file called "Run time engine"
3. Extract the "Run time engine" and on the folder where the run time engine was extracted right click on the file and click on "show package content"
4. Go to the folder called "MacOS" then inside that folder open a terminal and ran the following command. PD: change the projectPath to the actual path where the project was saved on your PC

"./katalonc -noSplash -runMode=console -projectPath="/Users/santiagollanos/Katalon Studio/Koombea API Challenge/Koombea API Challenge.prj" -retry=0 -testSuitePath="Test Suites/Bored API tests execution" -browserType="Web Service" -executionProfile="default" --config -proxy.auth.option=NO_PROXY -proxy.system.option=NO_PROXY -proxy.system.applyToDesiredCapabilities=true"

5. After the Test execution is finished go to the project folder and look for the folder called "Reports" to check the report generated by the execution
