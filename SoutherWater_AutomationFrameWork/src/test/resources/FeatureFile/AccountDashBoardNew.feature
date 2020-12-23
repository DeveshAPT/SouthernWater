Feature: Account Dashboard Non Direct Debit Customer

  Background: A
    Given I am at login Page
    And Login with Non DD Credentials
    When Click on Login

  @SIT
  Scenario Outline: Verify Account Dashboard Quick links for Non Direct Debit Metered Customer
    Then I can see the QucikLinks <Links> on Dashboard
    And I can see Customer Number,Payment Reference on Dashboard
    And I Can see Customer Email ID, Correspondence Address under your profile section
    And I Can see Last Meter Reading, Meter Number, Date last Read
    And I Can see Property address, Your Services
    And I Can see Latest Bill, Bill Amount, Bill Date
    And I Can see Amount Due, Amount, date

    Examples: 
      | Links                                                                                                |
      | Set up a Direct Debit, View bills/account statement ,View payment history ,Change paperless settings |

  @SITUNM
  Scenario Outline: Verify Account Dashboard Quick links for Un-Metered Account
    Then I can see the QucikLinks <Links> on Dashboard
    And I can see Customer Number,Payment Reference on Dashboard
    And I Can see Customer Email ID, Correspondence Address under your profile section
    And I Can see Property address, Your Services
    And I Can see Latest Bill, Bill Amount, Bill Date

    #And I Can see Amount Due, Amount, date
    Examples: 
      | CustType | Links                                                                                          |
      | UNM      | Make a payment , View bills/account statement ,View payment history ,Change paperless settings |

  @SIT
  Scenario Outline: Verify Dashboard Menu Items
    And Click on 'Your Account' Option
    Then I Can See Following Menu <MenuItem> Items

    Examples: 
      | MenuItem                                                                                                                                                                   |
      | Make a payment , Set up/Amend a Direct Debit ,View bills/Account statement ,Payment history,Submit a meter reading,Paperless settings,Tell us you_re moving,Update profile |

  @SIT
  Scenario: Verify Logout Functionality
    And Click on 'Your Account' Option
    And I Click on Logout from Dashboard
    Then I Should See 'Thank You' Message after Logout
    And I am not able to see 'Your Account' Option

  @SIT
  Scenario: Verify Submit Meter Navigation
    And Click on 'Your Account' Option
    And I Click on 'Submit a meter reading' from Dashboard
    Then I Should Move to Submit Meter Reading Page

  @SIT
  Scenario: Verify Make a payment Navigation
    And Click on 'Your Account' Option
    And I Click on 'Make a payment' from Dashboard
    Then I Should Move to Payment Page

  @SIT
  Scenario: Verify Close Account Navigation
    And Click on 'Your Account' Option
    And I Click on 'Tell us you are moving' from Dashboard
    Then I Should Move to Close Account Page

  @SIT
  Scenario: Verify the paperless Setting for online Bill
    And Click on 'Your Account' Option
    And I Click Change Paperless Setting
    And I Should move to Paperless Setting Page

  #And I Click on Update
  #Then I Can See Thankyou Message
  @SIT
  Scenario: Verify Direct Debit Navigation
    And Click on 'Your Account' Option
    And I Click Set Up Direct Debit
    Then I Should move to Setup Direct Debit Page

  @SIT
  Scenario: Verify Your Profile Navigation
    And Click on 'Your Account' Option
    When I Click update Profile
    Then I Should move to View Profile Page

  @SIT
  Scenario: Verify Payment History Navigation
    And Click on 'Your Account' Option
    And I Click Set Up Payment history
    Then I Should move to Payment history Page

  @SIT
  Scenario: Verify View bills/Account statement Navigation
    And Click on 'Your Account' Option
    And I Click View bills/Account statement
    Then I Should move to View Bill Account Statement Page

  @SIT
  Scenario: Verify Submit Meter Navigation by quick link on Dashboard
    And I Click on 'Submit a meter reading' button from Dashboard
    Then I Should Move to Submit Meter Reading Page

  @SIT
  Scenario: Verify Close Account Navigation by quick link on Dashboard
    And I Click on 'Tell us you are moving' button from Dashboard
    Then I Should Move to Close Account Page

  @SIT
  Scenario: Verify Make a payment Navigation by quick link on Dashboard
    And I Click on 'Make a payment' button from Dashboard
    Then I Should Move to Payment Page

  @SIT
  Scenario: Verify Your Profile Navigation by quick link on Dashboard
    And I Click 'View Profile' button from Dashboard
    Then I Should move to View Profile Page

  @SIT
  Scenario: Verify Contact Us Navigation from Dashboard
    And I Click Contact us
    Then Contact Us page should open in new tab

  @SIT
  Scenario: Verify Find out more Navigation from Dashboard
    And I Click Discover ways to save
    Then Save Water page should open in new tab

  @SIT
  Scenario: Registered User can access How to keep it clear
    When I Click Learn more
    Then How to prevent blockage page should open in new tab
