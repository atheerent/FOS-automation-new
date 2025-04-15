@smoke @all @users @importUsers
Feature: Verify CSV import user scenario

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

  Scenario: Import users from CSV file located in s3 bucket
    Given Verify presence of "CREATE_USER_NEW_BUTTON" of "userListingPage"
    And Click on the "CREATE_USER_NEW_BUTTON" of "userListingPage"
    And Click on the "UPLOAD_BUTTON" of "userListingPage"
    Then Click on the "UPLOAD_CSV_XLS_BUTTON" of "userListingPage"
    Then Import a file "import_Users.csv" from "UPLOAD_FILE" of page "userListingPage"
    Then Wait for 2 seconds
    Then Verify presence of "CHECK_CIRCLE_ICON" of "userListingPage"
    Then Click on the "CONTINUE_BUTTON" of "userListingPage"
    Then Verify presence of "DOWNLOAD_LOG_BUTTON" of "userListingPage"
    Then Click on the "CONTINUE_BUTTON" of "userListingPage"
    Then Wait for 2 seconds
    And Click on the "SEARCH_BUTTON" of "userListingPage"
    Then Enter "Auto" in "SEARCHBAR_FIELD" of "userListingPage"
    Then Wait for 2 seconds
    And Click on the "SELECT_ALL_BUTTON" of "userListingPage"
    Then Wait for 2 seconds
    And Click on the "DELETE_BUTTON" of "userListingPage"
    Then Click on the "CONFIRM_DELETE" of "userListingPage"
    Then Wait for 2 seconds

  Scenario: Quit the browser
    Given Quit the browser