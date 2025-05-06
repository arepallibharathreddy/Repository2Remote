Feature: Iam Automating OrangeHRM Website

Background: Common steps

Given User Launches Chrome Browser
Then User Enters URL as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

Scenario Outline: TC01_AddSkills - iam creating skill record

And user enters the credentials
     |username|password|
     |Admin|admin123|
Then go to skill page
Then user enters skills records as
     |Skill |SkillDesc  |
     |Java21|Java21 Desc|
     |Java31|Java31 Desc|
     |Java41|Java41 Desc|
Then user clicks logout button
And user close the browser