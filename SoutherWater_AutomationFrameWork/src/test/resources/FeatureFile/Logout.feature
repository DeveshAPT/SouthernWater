

Feature: Logout
 
  @WEB
  Scenario Outline: Verify that user is able to logout from the application
    Given I have Logged in  <Email> and <Password> into SothernWater
    When I click on Logout
    Then I Should logout
    
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica|
   
 
 
