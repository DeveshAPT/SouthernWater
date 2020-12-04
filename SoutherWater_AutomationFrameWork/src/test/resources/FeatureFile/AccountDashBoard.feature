  
 Feature: Account Dashboard


 @SIT
Scenario Outline: As A Registered User i can see Your Account Link after Login 
  Given I am at login page
  When I Enter my <Email> and <Password> into respective fields
  And Click on Login
  Then I Should see Your Account link on the Page 
  Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica|
  
 
 @SIT
Scenario Outline: Account Dashboard should load after your account click
  Given I am at login page
  When I Enter my <Email> and <Password> into respective fields
  And Click on Login
  And Click on 'Your Account' Option
  Then I Should see 'Dashboard' Option
  And I Should See 'Log out' Option
  And I Should See 'Make a payment' Option
  And I Should See 'Payment history' Option
  And I Should See 'Tell us you are moving' Option
  And I Should See 'Set up/Amend a Direct Debit' Option
  And I Should See 'Paperless settings' Option
  And I Should See 'Your profile' Option
  And I Should See 'View bills/Account statement' Option
  And I Should See 'Submit a meter reading' Option
  
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica|
 

       
 @SIT
  Scenario Outline: Registered User Can Log out from Protal   
    Given I am on Account DashBoard Using Login Credentials <Email> and <Password> 
    When I Click on Logout from Dashboard
    Then I Should See 'Thank You' Message after Logout
    And I am not able to see 'Your Account' Option
    
    
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica|   
    
 
  @SIT
  Scenario Outline: Registered User can access Submit Meter Reading
    Given I am on Account DashBoard Using Login Credentials <Email> and <Password> 
    When I Click on 'Submit a meter reading' from Dashboard
    Then I Should Move to Submit Meter Reading Page  
    
    
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica| 
 
 
  @SIT
  Scenario Outline: Registered User can access Make a Payment
    Given I am on Account DashBoard Using Login Credentials <Email> and <Password> 
    When I Click on 'Make a payment' from Dashboard
    Then I Should Move to Payment Page 
    
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica| 
  
  @SIT
 Scenario Outline: Registered User can access Close Account 
   	Given I am on Account DashBoard Using Login Credentials <Email> and <Password> 
    When I Click on 'Tell us you are moving' from Dashboard
    Then I Should Move to Close Account Page  
    
    Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica| 