
Feature: I want Access Submit Meter Reading

@WEB
Scenario: I Want to Submit my meter reading 
    Given I am on meter submit reading pages
    When I click on Having trouble link
    Then I Should move to how to find your meter page
    
@WEB
Scenario: I Want Access Submit meter reading 
    Given I am on how to find your meter page
    When I click on Submit Meter link
    Then I Should move to Submit meter reading page

@WEB
Scenario: I Want to Verify customer meter reading details 
    Given I am on submit meter reading page
    When I submit all the details of customer
    Then I Should able to verify all the details of customer 
    
@WEB
 Scenario Outline: Login with Valid credentials to navigate Your meter reading page   
    Given I have logged in with <Email> and <Password>
    When I click to submit meter reading 
    Then I can view Your meter reading page
    
 Examples:
    |Email|Password|
    |kumar.devesh82@yahoo.com|Apple@123|
    
@WEB
 Scenario Outline: Login with Valid credentials to verify submit meter reading button 
    Given I am on submit meter reading page with credentials <Email> and <Password>
    And I move to Your meter reading page
    When I click to Back button of Your meter reading page
    Then I should navigate to my account dashboard
    And I can confirm a Submit a meter reading button
    
 Examples:
    |Email|Password|
    |kumar.devesh82@yahoo.com|Apple@123|    
    
@WEB
  Scenario Outline: Login with Valid credentials to verify updated Meter Reading and today date 
    Given I am on meter reading page using credentials <Email> and <Password>
    When I enter meter reading 
    And I click on Continue button
    Then I should move to Confirm meter reading step 
    And I can view updated Meter Reading 
    And I can view today date 
    
 Examples:
    |Email|Password|
    |kumar.devesh82@yahoo.com|Apple@123|
    
 @WEB
  Scenario Outline: Login with Valid credentials to update meter reading  
    Given I am on Confirm meter reading page using credentials <Email> and <Password>
    When I click Back button of Confirm meter reading page
    Then I can update the new meter reading
    And I can click to continue Button of Your meter reading page
    And I can view updated meter reading on Confirm meter reading 
  
 Examples:
    |Email|Password|
    |kumar.devesh82@yahoo.com|Apple@123|