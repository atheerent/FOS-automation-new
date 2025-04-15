@smoke @all @content @addLinkContent
Feature: Verify user can add Link in the content section

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

  Scenario: Create Link content
    Given Verify presence of "CREATE_CONTENT_NEW_BUTTON" of "contentListingPage"
    And Click on the "CREATE_CONTENT_NEW_BUTTON" of "contentListingPage"
    Then Click on the "LINK_CONTENT_OPTION" of "contentListingPage"
    Then Verify presence of "URL_FIELD" of "contentDetailsPage"
    Then Enter a random URL in "URL_FIELD" field on "contentDetailsPage"
    Then Click on the "LETSGO_BUTTON" of "contentDetailsPage"
    Then Clear the "CONTENT_TITLE_FIELD" from "contentDetailsPage"
    Then Enter a random name with ".co.in" in "CONTENT_TITLE_FIELD" field on "contentDetailsPage"
    Then Click on the "TEAM_EXPAND_BUTTON" of "contentDetailsPage"
    Then Wait for 1 seconds
    Then Click on the "LINK_PLUS_ICON" of "contentDetailsPage"
    Then Click on the "SELECT_ALL_CHECKBOX" of "contentDetailsPage"
    Then Click on the "SELECT_BUTTON" of "contentDetailsPage"
    Then Click on the "SAVE_BUTTON" of "contentDetailsPage"

  Scenario: Quit the browser
    Given Quit the browser




