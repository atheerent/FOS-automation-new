#Author: chandsi@gopronto.io
#Keywords Summary : Feature file with all common scenarios/utils
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: General Utils

  Scenario: Core functions
    Given Invoke "browser" browser
    Then Navigate to "sub_directory" page of Atheer

  @tag
  Scenario: Browser Commands [Open/Quit/Close browser]
    Given Invoke "chrome" browser
    Then Quit the browser
    Then Close the current browser window
    Then Delete browser cookies
    Then Maximize the browser
    Then Refresh the current browser window
    Then Hard refresh the current browser window

  Scenario: Navigation commands
    Given Navigate to "url" page
    Then Navigate to "sub_directory" page of Atheer
    Then Click on forward button in the browser window
    Then Click on back button in the browser window


  Scenario: Handling alerts
    Given Cancel an alert
    Then Accept an alert

  Scenario: Element actions
    Given Enter "text" in "elementName" of "pageName"
    Then Enter "text" with timestamp in "elementName" of "pageName"
    Then Enter random email alias of "text" of "elementName" of "pageName"
    Then Click on the "elementName" of "pageName"
    Then Clear the "elementName" from "pageName"
    Then Select option by text from "dropdownElement" element of "pageName" : "dropdownValue"
    Then Select option by index from "dropdownElement" element of "pageName" : "indexNumber"
    Then Hover on "elementName" element of "pageName"
    Then Drag an element from "sourceElementName" and drop it to "destinationElementName" of "pageName" page

  Scenario: Authentication scenarios
    Given Enter email of admin user in "elementName" field of "pageName"
    Then Enter password of admin in "password" field of "pageName"
    Then Enter email of non-admin user in "username" field of "pageName"
    Then Enter password of non-admin user in "password" field of "pageName"


  Scenario: Element Verification scenarios
    Given Verify presence of "elementname" of "pagename"
    Given Verify text present at "elementname" of "pagename"

  Scenario: Navigate to URL provided in Properties file
    Given Navigate to "elementName" page "pageName" of Pronto

#alertIsPresent()
#elementSelectionStateToBe()
#elementToBeClickable()
#elementToBeSelected()
#frameToBeAvaliableAndSwitchToIt()
#invisibilityOfTheElementLocated()
#invisibilityOfElementWithText()
#presenceOfAllElementsLocatedBy()
#presenceOfElementLocated()
#textToBePresentInElement() //deprecated
#textToBePresentInElementLocated()
#textToBePresentInElementValue()
#titleIs()
#titleContains()
#visibilityOf()
#visibilityOfAllElements()
#visibilityOfAllElementsLocatedBy()
#visibilityOfElementLocated()


