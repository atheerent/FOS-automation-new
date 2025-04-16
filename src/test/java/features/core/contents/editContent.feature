@smoke @all @content @editContent
Feature: Verify user can edit content in the content section

  @atheerNavigationHook
  Scenario: Open browser and navigate to login page
    Given Invoke "browser" browser

  @SuperUserLoginHook
  Scenario: Entering valid email address and password of super user
    Given Verify presence of "LOGO_BUTTON" of "leftPanelAtheerPage"

  Scenario: Navigate to the Content page
    Given Verify presence of "CONTENT_BUTTON" of "leftPanelAtheerPage"
    And Click on the "CONTENT_BUTTON" of "leftPanelAtheerPage"
    Then Verify presence of "CONTENT_MENU_BUTTON" of "leftPanelAtheerPage"
    And Click on the "CONTENT_MENU_BUTTON" of "leftPanelAtheerPage"
    Then Verify presence of "CONTENT_TITLE" of "contentListingPage"

  Scenario: create Announcement content
    Given Verify presence of "CREATE_CONTENT_NEW_BUTTON" of "contentListingPage"
    And Click on the "CREATE_CONTENT_NEW_BUTTON" of "contentListingPage"
    Then Click on the "ANNOUNCEMENT_CONTENT_OPTION" of "contentListingPage"
    Then Verify presence of "CONTENT_TITLE_FIELD" of "contentDetailsPage"
    Then Clear the "CONTENT_TITLE_FIELD" from "contentDetailsPage"
    Then Enter a random name with "- Announcement" in "CONTENT_TITLE_FIELD" field on "contentDetailsPage"
    Then Enter a random text in "TEXT_AREA" field on "contentDetailsPage"
    Then Click on the "TEAM_EXPAND_BUTTON" of "contentDetailsPage"
    Then Click on the "PLUS_ICON" of "contentDetailsPage"
    Then Wait for 2 seconds
    Then Click on the "SELECT_ALL_CHECKBOX" of "contentDetailsPage"
    Then Click on the "SELECT_BUTTON" of "contentDetailsPage"
    Then Click on the "SAVE_BUTTON" of "contentDetailsPage"
    Then Click on the "GO_BACK_BUTTON" of "contentDetailsPage"
    Then Wait for 3 seconds
    And Click on the "SEARCH_BUTTON" of "contentListingPage"
    Then Search for the random content in "SEARCHBAR_FIELD" of "contentListingPage"
    Then Wait for 2 seconds

    Scenario: edit created announcement
      Given Verify presence of "LIST_CONTENT_TITLE" of "contentListingPage"
      Then Click on the "SEARCH_CANCEL_BUTTON" of "userListingPage"
      Then Click on the "EDIT_CONTENT_BUTTON" of "contentListingPage"
      Then Wait for 2 seconds
      Then Clear the "CONTENT_TITLE_FIELD" from "contentDetailsPage"
      Then Enter a random name with "- Announcement (EDITED)" in "CONTENT_TITLE_FIELD" field on "contentDetailsPage"
      Then Clear the "TEXT_AREA" from "contentDetailsPage"
      Then Enter a random text in "TEXT_AREA" field on "contentDetailsPage"
      Then Click on the "TAG_EXPAND" of "contentDetailsPage"
      Then Enter "ABCD" in "TAG_FIELD" of "contentDetailsPage"
      Then Press Enter key
      Then Wait for 3 seconds
      Then Click on the "SAVE_BUTTON" of "contentDetailsPage"

  Scenario: Quit the browser
    Given Quit the browser