

Feature: SouthernWater Application Access
 
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
		Then I moved to Term page

@WEB
Scenario: Verify Question Mark ToolTip
		Given I am on SouthernWater PayBill detail Page
		When I Click First Time on Question Mark Icons
		Then I Can see the Suggestion Messsage
		When I Click Second Time on Question Mark Icons
		Then I Suggestion Messsage should hide
    
@WEB
Scenario: Check the mandatory field error message
		Given I am on SouthernWater Pay Bill page detail Page
		When I Click on Continue
		Then I Should see the mandatory field Error Message
		
@WEB
Scenario: Check the error message for Incorrect Data
		Given I am on SouthernWater Pay Bill with mandatory field error
		When I enter all details
		And I click on Continue
		Then I Should see the error Message for incorrect Data
		

@WEB
Scenario: Check the error message removed after entering mandatory field
		Given I am on SouthernWater Pay Bill with mandatory field error message
		When I enter all details in form
		Then I Should not see the error Message for mandatory fields


		