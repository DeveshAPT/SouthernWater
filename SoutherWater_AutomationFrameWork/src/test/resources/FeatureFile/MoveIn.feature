
Feature: Move In

@SIT
Scenario: Verify that user is able to move in to a address successfully
    Given I am on create an account page
    And I click on Start button
    When I fill all moving details
    And I fill all the payment details
    Then I Should be able to move in
    
@SIT
Scenario: Verify that user is able to move to Moving details page
    Given I am on a create an account page
    When I click on Start button to Moving details page
    Then I should be able to move to Moving details page
    
@SIT
Scenario: Verify that user will get error messages on Moving details page for not filling any values
    Given I am on Moving details page
    When I clicked on Continue button
    Then I should be able to see error messages on Moving details page for not filling any values 
    
@SIT
Scenario Outline: Verify that user will get error message on Moving details page for not entering valid value in postcode
    Given I am on the Moving details page
    When I enter invalid <Postcode> in Enter the postcode
    And I click on Find address button
    Then I should be able to see error messages on Moving details page for invalid postcode 
    
  Examples:
    |Postcode|
    |110033|
    
@SIT
Scenario: Verify that user will get error messages on Moving details page for not selecting an address
    Given I am on the moving details page
    When I am not selecting the address
    And I clicked on the Continue button
    Then I should be able to see error messages on Moving details page