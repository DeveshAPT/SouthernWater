  
 Feature: Registered User Can Have the Account Dashboard
 
 #@WEB
  Scenario Outline: Registered User should see the account DashBoard   
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
    
    
 #@WEB
  Scenario Outline: Registered User Can Log out from Protal   
    Given I am on Account DashBoard with Login Credentials <Email> and <Password> 
    When I Click on Logout from Dashboard
    Then I Should See Logout Successfull Message On Portal
    And not able to see Make Payment Button
    And not able to see Submit Meter Reading Button
    And not able to see Close your Account Button
    
    
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica|   
    
 
  #@WEB
  Scenario Outline: Registered User can access Submit Meter Reading
    Given I have Logged in SouthernWater <Email> and <Password> 
    When I Click on Submit Meter Reading from Dashboard
    Then I Should See Move to Submit Meter Reading Page  
    
    
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica| 
 
 
  #@WEB
  Scenario Outline: Registered User can access Make a Payment
    Given I Accessing SouthernWater using <Email> and <Password> 
    When I Click on Submit Make a Payment Dashboard
    Then I Should Move to Payment Page  
    
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica| 
  
 @WEB  
 Scenario Outline: Registered User can access Close Account 
    Given I have Open SouthernWater using <Email> and <Password> 
    When I Click on Close Account From Dashboard
    Then I Should Move to Close Account Page  
    
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica| 