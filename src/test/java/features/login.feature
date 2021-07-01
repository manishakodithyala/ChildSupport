Feature: Login into Application

Background: User logs in
Given Initialized the browser with chrome
And  Navigate to "https://arizonachildsupportservices--usist.my.salesforce.com/" site
When User enter "komanisha@deloitte.com.usist" and "M@ni$h@08" and logs in
Then User should be able to successfully login


#Scenario: Login functionality validation
#Given Initialized the browser with chrome
#And  Navigate to "https://arizonachildsupportservices--usist.my.salesforce.com/" site
#When User enter "komanisha@deloitte.com.usist" and "M@ni$h@08" and logs in
#Then User should be able to successfully login
#And Close browser

Scenario: Create an Enrollment Request
Given User clicks on Enrollment Request tab
And User selects New Enrollment Request option
When User enters all the mandatory fields 
And Clicks on Save button
Then New Enrollment Request should be created successfully
