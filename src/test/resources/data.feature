Feature: This feature is to test login page scenarios
	
Scenario Outline: This scenario is to test login with valid credential
	Given Launch the browser and load the Url.  
	When Provide valid "<Username>" and "<Password>".
	Then Validate the user is logged in.
	
Examples: 
 |Username|Password|
 |azharudeen@gmail.com|Abc@123|
 |geetha@yahoo.com|Welcome@5|
 |sumithra@outlook.in|Test$234|