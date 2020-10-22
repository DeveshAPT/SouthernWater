
Feature: Register a New Online Account

#SSR-502 >> Agree terms and conditions

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
Then Agree Terms & Conditions Error message should remove from both locations

@WEB
Scenario: Verify Your Privacy Link Functionality
Given I am on Customer Registration Page 
When I Click Your Privacy Link
Then I Should move to Privacy Page


#SSR-444 >> Tell the user what information they will need at the start of the register account journey


@WEB
Scenario: Verify field details message on customer registration page
Given I am on online SouthernWater Portal page
When I Access Customer Registration Page
Then I am able to see “It should only take a few minutes” 
And Your customer number. This is the 8-digit number shown on the top right of your bill.
And Your last name as shown on the bill.
And Your email address.



# SSR-926 >> Tell the customer a verification email has been sent to them

@WEB 
Scenario: Verify verification Email Send Message to Customer registration page
Given I am on online SouthernWater Customer Registration Page
When An email for verification send to me 
Then I am able to see the message to check the email on Customer Registration page.

# SSR-960 >> Confirm account has been successfully registered/activated

@WEB 
Scenario: Verify activation message after clicking on verification email
Given I have the Email Verification Link
When I Click on verification email before 48 hours
Then I should move to new page
And I am able to see that my account successful registered/activated
And I am able to login

@WEB 
Scenario: Verification Link Expire After 48 hours
Given I have the Account Verification Link in mail
When I Click on verification email after 48 hours
Then I should Error message for linked is expired 



