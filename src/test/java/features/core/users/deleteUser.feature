@smoke @all @users @deleteUser
Feature: Verify delete user scenario

  @atheerNavigationHook
  Scenario: Open browser and navigate to login page
    Given Invoke "browser" browser

  @SuperUserLoginHook
  Scenario: Entering valid email address and password of super user
    Given Verify presence of "LOGO_BUTTON" of "leftPanelAtheerPage"

  Scenario: Navigate to the User Listing page
    Given Verify presence of "USER_BUTTON" of "leftPanelAtheerPage"
    And Click on the "USER_BUTTON" of "leftPanelAtheerPage"
    Then Verify presence of "USER_MENU_BUTTON" of "leftPanelAtheerPage"
    And Click on the "USER_MENU_BUTTON" of "leftPanelAtheerPage"
    Then Verify presence of "USER_TITLE" of "userListingPage"

  @createUserHook
  Scenario: delete recently created user
    Given Click on the "SEARCH_BUTTON" of "userListingPage"
    Then Search for the generated term in "SEARCHBAR_FIELD" of "userListingPage"
    Then Wait for 3 seconds
    Then Verify presence of "USER_MOREOPTION_BUTTON" of "userListingPage"
    And Click on the "USER_MOREOPTION_BUTTON" of "userListingPage"
    Then Click on the "DELETE_USER_BUTTON" of "userListingPage"
    Then Click on the "CONFIRM_DELETE" of "userListingPage"
    Then Verify presence of "USER_DELETED_CONFIRMATION" of "userListingPage"
    Then Wait for 3 seconds
    Then Click on the "SEARCH_CANCEL_BUTTON" of "userListingPage"
    Then Click on the "SEARCH_BUTTON" of "userListingPage"
    Then Search for the generated term in "SEARCHBAR_FIELD" of "userListingPage"
    Then Wait for 3 seconds
    Then Verify absence of "USER_MOREOPTION_BUTTON" of "userListingPage"

  Scenario: Quit the browser
    Given Quit the browser