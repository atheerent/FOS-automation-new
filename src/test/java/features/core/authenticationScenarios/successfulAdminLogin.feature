@smoke @all @login @111
Feature: Verify successful login for Atheer user

  @atheerNavigationHook
  Scenario: Open browser and navigate to login page
    Given Invoke "browser" browser

  Scenario: Entering valid email address and password of admin user
    Given Click on the "EMAIL_FIELD" of "loginPage"
    Then Enter email of admin user in "EMAIL_FIELD" field of "loginPage"
    Then Wait for 2 seconds
    Then Enter password of admin in "PASSWORD_FIELD" field of "loginPage"
    Then Click on the "LOGIN_BUTTON" of "loginPage"

  Scenario: Quit the browser
    Given Quit the browser