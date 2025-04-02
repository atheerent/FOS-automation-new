@smoke @all @conversation @addConversation
Feature: Verify successful logout from Atheer web App

  @atheerNavigationHook
  Scenario: Open browser and navigate to login page
    Given Invoke "browser" browser

  @adminLoginHook
  Scenario: Entering valid email address and password of admin user
    Given Verify presence of "LOGO_BUTTON" of "leftPanelAtheerPage"

  Scenario: Start the group conversation
    Given Click on the "CONVERSATION_ICON" of "leftPanelAtheerPage"
    Then Click on the "CONVERSATION_BUTTON" of "conversationPage"

  Scenario: Create a group conversation by adding multiple users
