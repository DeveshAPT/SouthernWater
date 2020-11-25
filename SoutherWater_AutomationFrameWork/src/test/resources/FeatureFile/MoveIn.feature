
Feature: Move In, including online registration

@WEB
Scenario: Verify that user is able to move in to a address successfully
    Given I am on create an account page
    And I click on Start button
    When I fill all moving details
    And I fill all the payment details
    Then I Should be able to move in