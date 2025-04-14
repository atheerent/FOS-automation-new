@smoke @all @conversation @editGroupConversation
Feature: Verify user can edit group conversation details from Atheer web App

  @atheerNavigationHook
  Scenario: Open browser and navigate to login page
    Given Invoke "browser" browser

  @SuperUserLoginHook
  Scenario: Entering valid email address and password of admin user
    Given Verify presence of "LOGO_BUTTON" of "leftPanelAtheerPage"

  Scenario: Start the group conversation
    Given Click on the "CONVERSATION_ICON" of "leftPanelAtheerPage"
    Then Click on the "CONVERSATION_BUTTON" of "conversationPage"

  Scenario: Create a group conversation by adding multiple users
    Given Click on the "GROUP_CONVERSATION_BUTTON" of "conversationPage"
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

  Scenario: Edit the group conversation details
    Given  Click on the "CONVERSATION_SETTING_PAGE" of "conversationPage"
    Then Click on the "EDIT_CONVERSATION_BUTTON" of "conversationPage"
    Then Clear the "GROUP_NAME_TEXT_FIELD" from "conversationPage"
    Then Enter "Automation Group Edited" in "GROUP_NAME_TEXT_FIELD" of "conversationPage"
    Then Click on the "CONVERSATION_PURPOSE_FIELD" of "conversationPage"
    Then Enter "The group is created for automation testing " in "CONVERSATION_PURPOSE_FIELD" of "conversationPage"
    Then Click on the "MAKE_IT_PRIVATE_BUTTON" of "conversationPage"
    Then Click on the "UPDATE_BUTTON" of "conversationPage"
    Then Verify presence of "EDITED_GROUP_NAME" of "conversationPage"

  Scenario: Quit the browser
    Given Quit the browser