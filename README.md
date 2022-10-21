# MailOnline Framework

**selenium-cucumber-RestAssured: Automation Testing Using Java**

selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. It enables you to write and execute automated acceptance/unit tests. It is cross-platform, open source and free. Automate your test cases with minimal coding.

# Prerequisite

- Java
- Maven
- Eclipse
- Rest-Assured
- Eclipse Plugins
   - Maven
   - Cucumber
   
# Setting up selenium-cucumber-java
- Install Java and set path.
- Install Maven and set path.
- Clone respective repository or download zip.
  
    
Framework Architecture
--------------
	Project-Name
      |
	  |_src/main/java
 	  |	|_com/qa/core
	  |	|	|_BaseSetup.java
	  |	|	|_UIActions.java
	  |_src/test/java
	  |	|_com/qa/pagefactory
	  |	|	|_VerifyWebPage.java
	  |	|	|...
	  |	|_com/qa/stepdefinition
	  |	|	|_Steps.java
      |	|_com/qa/testrunner
	  |	|	|_TestRunner.java
 	  |_src/test/resources
	  |	|_Features
	  |	|	|_VerifyFeature.feature
	  |	|	|...
      |     |_extent.properties
      |     |_extent-config.xml
      
 * **src/main/java/BaseSetup** - This contains code for browser setup and screenshot on test failure.
 * **src/main/java/UIActions** - This contains code for generic actions perfomed by webdriver example Fluent Wait,Window Handle etc.
 * **src/test/java/pagefactory** - This contains file having elements of a particular page.
 * **src/test/java/stepdefinition** - This contains code for steps provided in feature file.
 * **src/test/java/testrunner** - This runs the feature file.
 * **src/test/resources/Features** - This contains feature file i.e Test cases/Test Scenario for the software under test.
 * **src/test/resources/extent** - These fine contains configuarion for extent report
 
 # Running Test
 Run Test Runner as Junit Tests
 
 - Reports will displayed inside test-output->sparkReport - html report(Open with webbrowser)
