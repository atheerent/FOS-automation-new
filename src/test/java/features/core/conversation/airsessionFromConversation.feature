@smoke @all @conversation @airsessionFromConversation
Feature: Verify user can start airsession from conversation on Atheer web

  @atheerNavigationHook
  Scenario: Open browser and navigate to login page
    Given Invoke "browser" browser

  @SuperUserLoginHook
  Scenario: Entering valid email address and password of admin user
    Given Verify presence of "LOGO_BUTTON" of "leftPanelAtheerPage"

  Scenario: Create a group conversation
    Given Click on the "CONVERSATION_ICON" of "leftPanelAtheerPage"
    Then Click on the "CONVERSATION_BUTTON" of "conversationPage"
    Then Click on the "GROUP_CONVERSATION_BUTTON" of "conversationPage"
    Then Click on the "GROUP_NAME_TEXT_FIELD" of "conversationPage"
    Then Enter a random real name username in "GROUP_NAME_TEXT_FIELD" field on "conversationPage"
    Then Click on the "ADD_USER_BUTTON" of "conversationPage"
    Then Click on the "SELECT_ALL_USER" of "conversationPage"
    Then Click on the "SELECT_BUTTON" of "conversationPage"
    Then Click on the "START_BUTTON" of "conversationPage"
    Then Wait for 3 seconds
    Then Enter "Hi,This is atheer automation group" in "CONVERSATION_TYPE_MESSAGE_FIELD" of "conversationPage"
    Then Click on the "SEND_BUTTON" of "conversationPage"
    Then Verify presence of "SENT_MESSAGE" of "conversationPage"

  Scenario: Start airsession from the conversation
    Given Click on the "CONVERSATION_AIRSESSION_BUTTON" of "conversationPage"
    Then Wait for 2 seconds
    Then Click on the "AIRSESSION_END_BUTTON" of "airSession"
    Then Click on the "CONFIRMATION_END_BUTTON" of "airSession"
    Then Click on the "CONVERSATION_ICON" of "leftPanelAtheerPage"

  Scenario: Quit the browser
    Given Quit the browser


