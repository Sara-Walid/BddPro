Feature: Login

  Scenario: Valid login
    Given navigate to login page
    When valid username and password are entered
    And click on submit button
    Then user's home page is displayed

  Scenario: Invalid login
    Given navigate to login page
    When Invalid username and password are entered
    And click on submit button
    Then error message will be displayed
