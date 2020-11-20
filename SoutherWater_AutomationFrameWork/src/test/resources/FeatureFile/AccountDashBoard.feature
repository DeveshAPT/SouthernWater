  @WEB
  Scenario Outline:  Registered User should see the account DashBoard   
    Given I am accessing Login Page of SouthernWater Portal
    When I Enter my Login credentials <Email> and <Password> 
    And Click on Login Button on Portal 
    Then I should Login into Portal
    And I Should See Logout Button
    And I Should See Make Payment Button
    And I Should See Submit Meter Reading Button
    And I Should See Close your Account Button
    
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica|