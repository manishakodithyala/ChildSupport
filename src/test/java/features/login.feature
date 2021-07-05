Feature: Login into Application 

Background: User logs in 
	Given Initialized the browser with chrome 
	And  Navigate to "https://arizonachildsupportservices--usist.my.salesforce.com/" site 
	When User enter "komanisha@deloitte.com.usist" and "M@ni$h@08" and logs in 
	Then User should be able to successfully login 
	
	
	#Scenario: Login functionality validationl̥
	#Given Initialized the browser with chrome
	#And  Navigate to "https://arizonachildsupportservices--usist.my.salesforce.com/" site
	#When User enter "komanisha@deloitte.com.usist" and "M@ni$h@08" and logs in
	#Then User should be able to successfully login
	#And Close browser
	
Scenario Outline: Create an Enrollment Request 
	Given User clicks on Enrollment Request tab 
	And User selects New Enrollment Request option 
	When User enters <RequestReceivedChannel> application information 
	And User enters Requestor Information details <ResponseType>, <IsCustodialParty>, <MemberType>, <FirstName>, <LastName> 
	And User enters Requestor Address details <AddressType>, <Address>, <City>, <State>, <ZIP> 
	And User enters Requestor Contact details <MethodOfCommunication>, <PhoneNumType>, <PhoneNum> 
	And User selects Request Response Documents <Documents> 
	And User assignes request to <personName> 
	And Clicks on Save button 
	Then New Enrollment Request should be created successfully 
	And Close browser 
	Examples: 
		|RequestReceivedChannel|ResponseType|IsCustodialParty|MemberType|FirstName|LastName|AddressType|Address|City|State|ZIP|MethodOfCommunication|PhoneNumType|PhoneNum|Documents|personName|
		|Phone				|Mail|Yes|Individual|Pooja|Gouri|Residential|Vidyanagar|Phoenix|Arizona|85123|Phone|Home Phone|(888)888-8888|UIFSA General Testimony,Affidavit Supporting Paternity|Manisha Kodithyala|
