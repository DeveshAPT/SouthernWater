Feature: Log In
 

 @WEB
  Scenario Outline: Verify that user is not able login to the application with incorrect credentials 
    Given I am at login page
    When I Enter my <Email> and <Password> into respective fields
    And Click on Login 
    Then I Should not login 
    And I Should see the Login error message
    
    Examples:
    |Email|Password|
    |abc@yahoo.com|xyz123|
   
  @WEB
  Scenario Outline: Verify that user is able to login to the application successfully with valid credentials 
    Given I am on login page
    When I Enter credentials <Email> and <Password> into respective fields
    And Click on Login button
    Then I should see the Dashboard
    
    
  Examples:
    |Email|Password|
    |devesh.kumar@southernwater.co.uk|360@Logica|
  
  
  @WEB
  Scenario: Verify that user is able to reset the Password using the forgot your password link  
    Given User is at login page
    When I Click on Forgot Password
    Then I Should navigate to Forgot Password Page 
    And I Should Email address field for reset password
    And Back to login, Continue links 
  
  @WEB
  Scenario Outline: Verify that user is notified that Reset Password link has been sent on mail   
    Given I am at Reset Password Page
    When I Enter <Email> in Reset Password 
    And Click on Continue 
    Then I Can See the Verification Link Sent Message
		Examples:
    |Email|
    |abc@yahoo.com|
    
  
  @WEB
  Scenario: Verify that user is able to navigate to Registration Page from Login page  
    Given I am accessing the Login Page
    When I Click on Registration 
    Then I Should Navigate to Registration Page