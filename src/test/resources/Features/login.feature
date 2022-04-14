  @smoketest
Feature: Testing for login senarios

 Scenario: User is able to Launch myURL with valid credentials
    Given User launched "myURL"
    Given User is on the "login" page

  Scenario Outline: Title of your scenario outline
    When User Enters <UserName> in "Username" field
    When User Enters <Password> in "password" field
    And User clicks the "login-button"
    Then I validate "home" page is loaded
    And User clicks the "logout-button"
    Then I validate "login" page is loaded

    Examples: 
      | Sheetname  | datakey |
      | sheet1 | Test01     |

 Scenario: User is able to Launch myURL and get error message with invalid creds
    Given User launched "myURL"
    Given User is on the "login" page

  Scenario Outline: Title of your scenario outline
    When User Enters <UserName> in "Username" field
    When User Enters <Password> in "password" field
    And User clicks the "login-button"
    Then I validate "error-message-box" is displayed
    And User clicks the "close-button"

    Examples: 
      | UserName  | Password |
      | Testuser1 | pw       |
      | Testuser2 | pw       |
