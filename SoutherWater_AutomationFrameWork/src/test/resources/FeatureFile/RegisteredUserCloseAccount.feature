Feature: Move Out close account (auth)
Description: The purpose of this feature is to test the Close Account Functionality of Registered User

Background: I should be Login in SouthernWater Portal
Given I have SouthernWater Login Page on Browser
When I Enter my Account EmailID and Password
And I Click on Login Button On Page
Then I Should Login to SouthernWater Portal

#@WEB
Scenario: Verify tha user should move to DashBoard after clicking back button of Close Account
Given I Am at Close Account page From Dashboard
When I Click Back Button of Close Account page
Then I Should move back to Dashboard 

@WEB
Scenario Outline: Verify that a registered user is able to Close My Account 
Given I have open Close My Account from Dashboard
And I Enter the MoveOut Date
And I Click On Continue of Move Out Step
And I Click On Continue of Final Bill Step
And I Enter Post Code as <PostCode>
And I Click on Find Address
And I Select <Address> from Address List
And I Click Continue of Forwarding Address
When I Click Confirm and Close Account
Then My Account Should Close
And I Can See Closing Message

 Examples:
    |PostCode|Address|
    |CT16 3NR|18 WITLEY WALK, WHITFIELD, CT16 3NR|

