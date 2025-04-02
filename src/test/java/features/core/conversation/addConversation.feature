@smoke @all @conversation @addConversation
Feature: Verify successful logout from Atheer web App

  @atheerNavigationHook
  Scenario: Open browser and navigate to login page
    Given Invoke "browser" browser

  @adminLoginHook
  Scenario: Entering valid email address and password of admin user
    Given Verify presence of "LOGO_BUTTON" of "leftPanelAtheerPage"

  Scenario: Start the 1:1 conversation
    Given Click on the "CONVERSATION_ICON" of "leftPanelAtheerPage"
    Then Click on the "CONVERSATION_BUTTON" of "conversationPage"
    Then Click on the "START_CONVERSATION_BUTTON" of "conversationPage"

  Scenario:Select first user and send message
    Then Click on the "SELECT_FIRST_USER" of "conversationPage"
    Then Click on the "SELECT_BUTTON" of "conversationPage"
    Then Scroll to "CONVERSATION_TYPE_MESSAGE_FIELD" element from "conversationPage"
    Then Click on the "CONVERSATION_TYPE_MESSAGE_FIELD" of "conversationPage"
    Then Enter "Hi,This is atheer automation" in "CONVERSATION_TYPE_MESSAGE_FIELD" of "conversationPage"
    Then Click on the "SEND_BUTTON" of "conversationPage"

  Scenario: Quit the browser
    Given Quit the browser



