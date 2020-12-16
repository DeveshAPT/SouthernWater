Feature: Account Dashboard

  Background: A
    Given I am at login Page
    And Login with Credentials
    When Click on Login

  @SIT
  Scenario Outline: Verify Account Dashboard Quick links
    Then I can see the QucikLinks <Links> on Dashboard
    And I can see Customer Number,Payment Reference on Dashboard
    And I Can see Customer Email ID, Correspondence Address under your profile section
    And I Can see Last Meter Reading, Meter Number, Date last Read
    And I Can see Property address, Your Services
    And I Can see Latest Bill, Bill Amount, Bill Date
    And I Can see Amount Due, Amount, date

    Examples: 
      | Links                                                                                                 |
      | Set up a Direct Debit , View bills/account statement ,View payment history ,Change paperless settings |

  @SIT
  Scenario: Verify Customer Number and Payment Reference on Dashboard
    Then I can see Customer Number,Payment Reference on Dashboard

  @SIT
  Scenario: Verify Your Profile section with Customer EmailID, Correspondence Address on  Dashboard
    Then I Can see Customer Email ID, Correspondence Address under your profile section

  @SIT
  Scenario: Verify Meter Reading Section With last Meter Reading, Meter Number and Date last read
    Then I Can see Last Meter Reading, Meter Number, Date last Read
    
  @SIT
  Scenario: Verify Account Detail Section With Property address, Your Services
    Then I Can see Property address, Your Services
    
  @SIT
  Scenario: Verify Bill Section
    Then I Can see Latest Bill, Bill Amount, Bill Date
    
   @SIT
  Scenario: Verify Amount Section
    Then I Can see Amount Due, Amount, date
