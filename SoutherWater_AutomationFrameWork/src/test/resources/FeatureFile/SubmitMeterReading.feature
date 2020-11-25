
Feature: Submit Meter Reading

@WEB
Scenario: Verify that user is able to navigate to how to find your meter page
    Given I am on meter submit reading pages
    When I click on Having trouble link
    Then I Should move to how to find your meter page
    
@WEB
Scenario: Verify that user is able to navigate to Submit meter reading 
    Given I am on how to find your meter page
    When I click on Submit Meter link
    Then I Should move to Submit meter reading page

@WEB
Scenario: Verif that customer meter reading details are correct
    Given I am on submit meter reading page
    When I submit all the details of customer
    Then I Should able to verify all the details of customer 
    
@WEB
 Scenario Outline: Verify that a registered user is able to navigate to submit meter reading page   
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
  Scenario Outline: Verify that a logged in user is able to view the updated meter redaing on the confirm meter reading page 
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
  Scenario Outline: Verify that a logged in user is able to go back a step on the submit meter page using the back button 
    Given I am on Confirm meter reading page using credentials <Email> and <Password>
    When I click Back button of Confirm meter reading page
    Then I can update the new meter reading
    And I can click to continue Button of Your meter reading page
    And I can view updated meter reading on Confirm meter reading 
  
 Examples:
    |Email|Password|
    |kumar.devesh82@yahoo.com|Apple@123|