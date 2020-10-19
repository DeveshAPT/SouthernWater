Feature: Demo API and Web

@Sanity @Regression @smoke @API @production @Dev
Scenario Outline: Submit a SPQR Request and Validate the expected Responce
Given I have submit a SPQR request for "<EIRCODE>"
Then Responce should contains the Servey Required as "<Expected Responce>"

Examples:
 |EIRCODE  |Expected Responce|
 |EIRCODE1 |N                |
 |EIRCODE2 |Y                |

@Sanity @Regression @smoke @WEB @Dev
Scenario Outline: Search a Keyword on Google
Given I am on the Homepage of Google
When I enter the "<SearchKey>" into Search box
When I select the "<SuggestionOption>" from the suggestion list
Then Search will displayed the "<Link>"

Examples:
 | SearchKey | SuggestionOption| Link          |
 | Testing1  | Testing1        |Testing 123    |
 | TesNg1    | TesNg1          |Testing 123    |
 

 