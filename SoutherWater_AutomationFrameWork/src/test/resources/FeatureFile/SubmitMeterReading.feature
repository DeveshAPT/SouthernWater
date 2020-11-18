
Feature: I want Access Submit Meter Reading

#@WEB
Scenario: I Want to Submit my meter reading 
    Given I am on meter submit reading pages
    When I click on Having trouble link
    Then I Should move to how to find your meter page
    
#@WEB
Scenario: I Want Access Submit meter reading 
    Given I am on how to find your meter page
    When I click on Submit Meter link
    Then I Should move to Submit meter reading page

@WEB
Scenario: I Want to Verify customer meter reading details 
    Given I am on submit meter reading page
    When I submit all the details of customer
    Then I Should able to verify all the details of customer