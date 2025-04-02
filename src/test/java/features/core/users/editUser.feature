@smoke @all @users @editUser
Feature: Verify edit user scenario

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
  Scenario: Edit recently created user
    Given Click on the "SEARCH_BUTTON" of "userListingPage"
    Then Search for the generated term in "SEARCHBAR_FIELD" of "userListingPage"
    Then Wait for 5 seconds
    Then Verify presence of "EDIT_USER_BUTTON" of "userListingPage"
    Then Click on the "EDIT_USER_BUTTON" of "userListingPage"
    Then Verify presence of "USERDETAILS_TITLE" of "userDetailsPage"
    Then Click on the "ABOUT_MENU_OPTION" of "userDetailsPage"
    Then Clear the "FIRST_NAME_FIELD" from "userDetailsPage"
    And Enter random name of "FNAME_EDITED" of "FIRST_NAME_FIELD" of "userDetailsPage"
    Then Clear the "LAST_NAME_FIELD" from "userDetailsPage"
    And Enter random name of "LNAME_EDITED" of "LAST_NAME_FIELD" of "userDetailsPage"
    And Enter random name of "AK" of "MIDDLE_NAME_FIELD" of "userDetailsPage"
    And Enter random name of "ATHEER" of "PREFERRED_NAME_FIELD" of "userDetailsPage"
    And Enter random phone number of "PHONENUMBER_FIELD" of "userDetailsPage"
    And Enter random name of "Location" of "LOCATION_FIELD" of "userDetailsPage"
    And Enter random name of "QA" of "JOB_TITLE_FIELD" of "userDetailsPage"
    And Enter random name of "Testing" of "JOB_DESCRIPTION_FIELD" of "userDetailsPage"
    And Enter random name of "Development" of "DIVISION_FIELD" of "userDetailsPage"
    And Enter random name of "Department" of "DEPARTMENT_FIELD" of "userDetailsPage"
    Then Click on the "UPDATE_BUTTON" of "userDetailsPage"
    Then Wait for 10 seconds


