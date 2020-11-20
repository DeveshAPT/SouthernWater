

Feature: Pay Bill
 
@WEB
Scenario: Check the SouthernWater App Access
    Given I am on SouthernWater Pay Bill page 
    When I Click on Start
    Then I move to customer details page
    And Back link is also available 
   
@WEB
Scenario: Verify Pay Bill Back Button Functionality
		Given I am on SouthernWater Pay Bill detail Page
		When I Click on Back Button
		Then I moved to Pay Detail Main Page

@WEB
Scenario: Verify Question Mark ToolTip
		Given I am on SouthernWater PayBill detail Page
		When I Click First Time on Question Mark Icons
		Then I Can see the Suggestion Message
		When I Click Second Time on Question Mark Icons
		Then I Suggestion Message should hide
    
#@WEB
Scenario: Check the mandatory field error message
		Given I am on SouthernWater Pay Bill page detail Page
		When I Click on Continue
		Then I Should see the mandatory field Error Message
		
#@WEB
Scenario: Check the error message for Incorrect Data
		Given I am on SouthernWater Pay Bill with mandatory field error
		When I enter all details
		And I click on Continue
		Then I Should see the error Message for incorrect Data
		

#@WEB
Scenario: Check the error message removed after entering mandatory field
		Given I am on SouthernWater Pay Bill with mandatory field error message
		When I enter all details in form
		Then I Should not see the error Message for mandatory fields
		

@WEB
Scenario Outline: As a Unregistered user I Can Pay Partial Amount of My Bill
		Given I am Accesing Pay Bill Detail Page
		And I Click Start Button on Page
		And I Enter Details Customer Number <CustNum> Payment Reference <PayRef> Last Name <LastName> EmailID <Email>
		And I Click On Continue Button on Detail Step
		And I Click on Continue Button of Check Detail Step
		And I Select Pay another Amount
		And I Enter Partial Amount<Amount>
		And I Click on Make Payment
		When I Enter Card Detail <Card> Name <Name> Expiry Month <expiryMonth> Expiry Year <expiryYear>  and SecurityCode <SecureCode>
		And I Click on Pay Now on Make Payment Step
		Then I Can see Payment Confirmation Message
		And Thankyou Message
		And Transaction with Transaction Number
		And Payment Reference With Reference Number
		And Same Amount <Amount> as I Pay
		
		 Examples:
    |CustNum|PayRef|LastName|Email|Amount|Card|Name|expiryMonth|expiryYear|SecureCode|
    |13417979|4050614612|Vardy|devesh.kumar@southernwater.co.uk|1|122000000000003|Fiona Vardy|08|27|453|
		 


@WEB
Scenario Outline: As a Unregistered user I Can Pay Full Amount of My Bill
		Given I have Open Pay Bill Detail Page
		And I Click Start Link on Page
		And I enter my details Customer Number <CustNum> Payment Reference <PayRef> Last Name <LastName> EmailID <Email>
		And I Click On Continue link on Detail Step
		And I Click on Continue link of Check Detail Step
		And I Select Pay Full Amount
		And I Click on Make Payment Link
		When I Enter Payment Card Detail <Card> Name <Name> Expiry Month <expiryMonth> Expiry Year <expiryYear>  and SecurityCode <SecureCode>
		And I Click on Pay Now Button on Make Payment Step
		Then I Can see Payment Confirmation Message on Page
		And Thankyou Message on Page
		And Transaction with Transaction Number on Receipt
		And Payment Reference With Reference Number on Receipt
		And Same Amount as I Pay on Receipt
		
		 Examples:
    |CustNum|PayRef|LastName|Email|Card|Name|expiryMonth|expiryYear|SecureCode|
    |13417979|4050614612|Vardy|devesh.kumar@southernwater.co.uk|122000000000003|Fiona Vardy|08|27|453|		 


@WEB
Scenario Outline: As a Registered user I Can Pay Partial Amount of My Bill
		Given I Login with my Login Credentials as Email <Email> and Password <Password>
		And I Click On Make Payment from Dashboard
		And I Click Select Pay Another Amount Option
		And I Enter Amount as <Amount>
		And I Click on Make Payment Link on Page
		When I Fill Payment Card Detail <Card> Name <Name> Expiry Month <expiryMonth> Expiry Year <expiryYear> and SecurityCode <SecureCode>
		And I Click on Pay Now Button on Make Payment Step on Portal
		Then I Can see Payment Confirmation Message on Portal
		And I Can See Thankyou Message on Portal
		And I Can See Transaction with Transaction Number on Portal
		And I Can See Payment Reference With Reference Number on Portal
		And I Can See Same Amount as <Amount> I Pay on Portal
		
		 Examples:
    |Email|Password|Amount|Card|Name|expiryMonth|expiryYear|SecureCode|
    |kumar.devesh82@yahoo.com|Apple@123|1|122000000000003|Fiona Vardy|08|27|453|
    
 @WEB
Scenario Outline: As a Registered user I Can Pay Full Amount of My Bill
		Given I have Login with my Login Credentials as Email <Email> and Password <Password>
		And I Click On Make Payment on Dashboard
		And I Click Select Pay Full Amount Option
		And I Click on Make Payment Link on Portal
		When I Fill Payment Card Detail <Card> Name <Name> Expiry Month <expiryMonth> Expiry Year <expiryYear> and SecurityCode <SecureCode>
		And I Click on Pay Now Link on Make Payment Step on Portal
		Then I Should see Payment Confirmation Message
		And I Should See Thankyou Message
		And I Should See Transaction with Transaction
		And I Should See Payment Reference With Reference
		And I Should See Payment Amount as I Pay on Portal
		
		 Examples:
    |Email|Password|Card|Name|expiryMonth|expiryYear|SecureCode|
    |kumar.devesh82@yahoo.com|Apple@123|122000000000003|Fiona Vardy|08|27|453|
		