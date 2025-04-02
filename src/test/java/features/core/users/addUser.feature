@smoke @all @users @createUser
Feature: Verify create user scenario

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

  Scenario: Create new User in the Atheer application
    Given Verify presence of "CREATE_USER_NEW_BUTTON" of "userListingPage"
    And Click on the "CREATE_USER_NEW_BUTTON" of "userListingPage"
    And Click on the "CREATE_NEW_BUTTON" of "userListingPage"
    Then Verify presence of "POPUP_CREATE_NEW_TITLE" of "userListingPage"
    Then Enter a random real name username in "LOGIN_FIELD" field on "userListingPage"
    Then Enter a random real name username in "FIRST_NAME_FIELD" field on "userListingPage"
    Then Enter random name of "Atheer" of "LOGIN_FIELD" of "userListingPage"
    And Enter random name of "Bhavesh" of "FIRST_NAME_FIELD" of "userListingPage"
    And Enter random name of "Panchal" of "LAST_NAME_FIELD" of "userListingPage"
    Then Enter a random real name username in "LAST_NAME_FIELD" field on "userListingPage"
    And Enter random email alias of "test@atheerair.com" of "EMAIL_FIELD" of "userListingPage"
    And Enter password of user in "PASSWORD_FIELD" field of "userListingPage"
    And Enter password of user in "CONFIRM_PASSWORD_FIELD" field of "userListingPage"
    And Click on the "SEND_NOTIFICATION_TOGGLE_BUTTON" of "userListingPage"
    Then Click on the "SAVE_BUTTON" of "userListingPage"
    Then Wait for 5 seconds
    And Click on the "SEARCH_BUTTON" of "userListingPage"
    Then Search for the generated term in "SEARCHBAR_FIELD" of "userListingPage"
    Then Wait for 5 seconds
    Then Verify presence of "USER_MOREOPTION_BUTTON" of "userListingPage"

  Scenario: Quit the browser
    Given Quit the browser
