@smoke @all @conversation @addMemberToGroupConversation
Feature: Verify user can add member to group conversation from Atheer web App

  @atheerNavigationHook
  Scenario: Open browser and navigate to login page
    Given Invoke "browser" browser

  @SuperUserLoginHook
  Scenario: Entering valid email address and password of admin user
    Given Verify presence of "LOGO_BUTTON" of "leftPanelAtheerPage"

  Scenario: Navigate to the User Listing page
    Given Verify presence of "USER_BUTTON" of "leftPanelAtheerPage"
    And Click on the "USER_BUTTON" of "leftPanelAtheerPage"
    Then Verify presence of "USER_MENU_BUTTON" of "leftPanelAtheerPage"
    And Click on the "USER_MENU_BUTTON" of "leftPanelAtheerPage"
    Then Verify presence of "USER_TITLE" of "userListingPage"

  @createUserHook
  Scenario: Create a group conversation
    Given Click on the "CONVERSATION_ICON" of "leftPanelAtheerPage"
    Then Click on the "CONVERSATION_BUTTON" of "conversationPage"
    Then Click on the "GROUP_CONVERSATION_BUTTON" of "conversationPage"
    Then Click on the "GROUP_NAME_TEXT_FIELD" of "conversationPage"
    Then Enter "Automation Group" in "GROUP_NAME_TEXT_FIELD" of "conversationPage"
    Then Click on the "ADD_USER_BUTTON" of "conversationPage"
    Then Click on the "SELECT_FIRST_CHECKBOX" of "conversationPage"
    Then Click on the "SELECT_BUTTON" of "conversationPage"
    Then Click on the "START_BUTTON" of "conversationPage"

  Scenario: Add member to  group conversation
    Given Click on the "CONVERSATION_SETTING_PAGE" of "conversationPage"
    Then Click on the "ADD_USER_TO_CONVERSATION_BUTTON" of "conversationPage"
    Then Click on the "SEARCH_BUTTON" of "userListingPage"
    Then Search for the generated term in "SEARCHBAR_FIELD" of "userListingPage"
    Then Wait for 5 seconds
    Then Click on the "SELECT_FIRST_CHECKBOX" of "conversationPage"
    Then Click on the "SELECT_BUTTON" of "conversationPage"
    Then Enter "Hi,This is atheer automation group" in "CONVERSATION_TYPE_MESSAGE_FIELD" of "conversationPage"
    Then Click on the "SEND_BUTTON" of "conversationPage"
    Then Verify presence of "SENT_MESSAGE" of "conversationPage"

  Scenario: Quit the browser
    Given Quit the browser
