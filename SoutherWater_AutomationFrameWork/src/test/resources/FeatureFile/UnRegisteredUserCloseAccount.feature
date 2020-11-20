Feature: As An UnRegister User I Want to Close My Account
Description: The purpose of this feature is to test the Close Account Functionality of UnRegistered User

@WEB
Scenario Outline: As UnRegistered User I Can Close My Account
Given I have Open UnRegisterd User Close Account Page 
And I Click on Start Button of Close Account Page
And I Enter CustomerNumer <CustomerNumber> Payment Reference <PayReference> Last Name <LastName>
And I Click On Continue of Close Account Your Detail Step
And I Enter Moving Out Date of Close Account
And I Click On Continue of Close Account Moving Date Step
And I Click On Continue of Close Account Final Bill Step
And I Enter Address Post Code as <PostCode> on Forwarding Address Step
And I Click on Find Address Forwarding Address Step
And I Select <Address> from Address List on Forwarding Address Step
And I Click Continue on Forwarding Address Step
When I Click Confirm and Close Account on check and confirm Step
Then I Should see Account Close
And I Should See Account Closing Message

 Examples:
    |CustomerNumber|PayReference|LastName|PostCode|Address|
    |20709752|4048720272|Peaa|CT16 3NR|18 WITLEY WALK, WHITFIELD, CT16 3NR|
    
 