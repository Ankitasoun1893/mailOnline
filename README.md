**selenium-cucumber : Automation Testing Using Java**

selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. It enables you to write and execute automated acceptance/unit tests. It is cross-platform, open source and free. Automate your test cases with minimal coding.

# Prerequisite

- Java
- Maven
- Eclipse
- Eclipse Plugins
   - Maven
   - Cucumber
   
# Setting up selenium-cucumber-java
- Install Java and set path.
- Install Maven and set path.
- Clone respective repository or download zip.
    - maven : (https://github.com/rahulverma1992/DMI_Automoves)
    
Framework Architecture
--------------
# DMI_Automoves Framework

**selenium-cucumber : Automation Testing Using Java**

selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. It enables you to write and execute automated acceptance/unit tests. It is cross-platform, open source and free. Automate your test cases with minimal coding.

# Prerequisite

- Java
- Maven
- Eclipse
- Eclipse Plugins
   - Maven
   - Cucumber
   
# Setting up selenium-cucumber-java
- Install Java and set path.
- Install Maven and set path.
- Clone respective repository or download zip.
    - maven : (https://github.com/rahulverma1992/DMI_Automoves)
    
Framework Architecture
--------------
	Project-Name
      |
	  |_src/main/java
 	  |	|_org/tester/core
	  |	|	|_BaseSetup.java
	  |	|	|_UIActions.java
	  |_src/test/java
	  |	|_org/tester/pagefactory
	  |	|	|_LoginPageFactory.java
	  |	|	|...
	  |	|_org/tester/stepdefinition
	  |	|	|_Steps.java
      |	|_org/tester/testrunner
	  |	|	|_TestRunner.java
 	  |_src/test/resources
	  |	|_Features
	  |	|	|_login.feature
	  |	|	|...
      |     |_config.properties
      |     |_extent.properties
      |     |_extent-config.xml
      
 * **src/main/java/BaseSetup** - This contains code for browser setup and screenshot on test failure.
 * **src/main/java/UIActions** - This contains code for generic actions perfomed by webdriver example Fluent Wait,Window Handle etc.
 * **src/test/java/pagefactory** - This contains file having elements of a particular page.
 * **src/test/java/stepdefinition** - This contains code for steps provided in feature file.
 * **src/test/java/testrunner** - This runs the feature file.
 * **src/test/resources/Features** - This contains feature file i.e Test cases/Test Scenario for the software under test.
 * **src/test/resources/config** - This file contains SUT URL and browser.
 * **src/test/resources/extent** - These fine contains configuarion for extent report
 
 # Running Test
 Run Test Runner as Junit Tests
