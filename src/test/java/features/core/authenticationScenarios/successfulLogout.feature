@smoke @all @logout @111
Feature: Verify successful logout from Atheer web App

  @atheerNavigationHook
  Scenario: Open browser and navigate to login page
    Given Invoke "browser" browser

  Scenario: Entering valid email address and password of admin user
    Given Click on the "EMAIL_FIELD" of "loginPage"
    Then Enter email of user in "EMAIL_FIELD" field of "loginPage"
    #Then Wait for 2 seconds
    Then Enter password of user in "PASSWORD_FIELD" field of "loginPage"
    And Click on the "LOGIN_BUTTON" of "loginPage"
    #Then Wait for 2 seconds

  Scenario: Verify user has been redirected to homepage
    Given Verify presence of "LOGO_BUTTON" of "leftPanelAtheerPage"

  Scenario: Verify logout functionality
    Given Verify presence of "USER_ICON" of "leftPanelAtheerPage"
    Then Click on the "USER_ICON" of "leftPanelAtheerPage"
    Then Verify presence of "SIGNOUT_BUTTON" of "leftPanelAtheerPage"
    Then Click on the "SIGNOUT_BUTTON" of "leftPanelAtheerPage"
    Then Verify presence of "SIGNBACK_BUTTON" of "loginPage"

  Scenario: Quit the browser
    Given Quit the browser