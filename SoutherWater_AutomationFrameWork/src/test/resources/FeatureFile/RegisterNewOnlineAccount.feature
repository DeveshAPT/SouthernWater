
Feature: Register a New Online Account

@WEB
Scenario: Verify Terms and Condition on Customer Registration Page 
Given I am at SouthernWater web portal
When I open Customer Registration Page
Then I am able to see Terms & Conditions Check Box 
And Hyperlink for Terms & Conditions

@WEB
Scenario: Verify that the Terms & Condition page is for customer
Given I am at online Customer Registration Page
When I Click on term & condition link
Then I Should move to Terms & Conditions Page 

@WEB
Scenario: Verify that the Terms & Condition Close button should navigate Customer Registration Page
Given I am on SW on Terms & Condition page 
When I Click on Close button 
Then I should move to Customer Registration Page

@WEB
Scenario: Verify Agree Terms & Condition is mandatory 
Given Customer Registration Page is open
When I click on Start button without agree Terms & Conditions
Then I should see the error message for agree Terms & Conditions 
And Second at below the Terms & Condition line

@WEB
Scenario: Verify Agree Terms & Condition is mandatory should remove after checking agree Terms & Condition 
Given Customer Registration Page is open and having Terms & Condition error on page
When I Click checkbox against Terms & Conditions
Then Agree Terms & Conditions Error message should remove from both location






