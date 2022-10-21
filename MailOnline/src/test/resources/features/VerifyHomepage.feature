Feature: Verify Homepage 
Scenario Outline: Verify Homepage

Given Launch Browser "<BrowserType>" and enter Url "<appurl>"
Then Verify current date on homepage
Then Verify primary and Secondry navigation colour 
Then Verify Facebook icon on image 
Then Verify previous and next arrow on gallary image

  Examples:
      |appurl|BrowserType|
      |https://www.dailymail.co.uk/home/index.html|Chrome|