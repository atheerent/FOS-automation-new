@smoke @all @conversation @pinUnpinConversation
Feature: Verify user can pin and unpin the conversation from Atheer web App

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

  Scenario: Pin the group conversation
    Given Wait for 3 seconds
    Then Click on the "CONVERSATION_SETTING_PAGE" of "conversationPage"
    Then Click on the "PIN_THIS_CONVERSATION_BUTTON" of "conversationPage"
    Then Verify presence of "PIN_ICON" of "conversationPage"
    Then Refresh the current browser window

  Scenario: unpin the group conversation
    Given Click on the "CONVERSATION_SETTING_PAGE" of "conversationPage"
    Then Click on the "UNPIN_THIS_CONVERSATION_BUTTON" of "conversationPage"
    Then Enter "Hi,This is atheer automation group" in "CONVERSATION_TYPE_MESSAGE_FIELD" of "conversationPage"
    Then Click on the "SEND_BUTTON" of "conversationPage"
    Then Verify absence of "PIN_ICON" of "conversationPage"

  Scenario: Quit the browser
    Given Quit the browser
