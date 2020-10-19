
Feature: I want Access Submit Meter Reading

@WEB
Scenario: I Want to Sumbit my meter reading 
    Given I am on meter submit reading pages
    When I click on Having trouble link
    Then I Should move to how to find your meter page
    And Submit Meter link is there
    When I click on Submit Meter link
    Then I Should move to Submit meter reading page

