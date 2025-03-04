@smoke @all @partnerOnboarding @fillPartnerOnboardingApplication
Feature: Verify user can fill partner onboarding application

  @prontoNavigationHook
  Scenario: Open browser and navigate to login page
    Given Invoke "browser" browser

  @adminLoginHook
  Scenario: Login into application with admin user and navigate to partner onboarding page
    Given Verify presence of "RELATIONSHIP_LISTING_PAGE_ECOSYSTEM_LABEL" of "relationshipListingPage"
    Then Click on the "SETTINGS_BUTTON" of "leftPanelProntoPage"
    Then Click on the "PARTNER_ONBOARDING_TAB" of "leftPanelSettings"

  @createPartnerOnboardingTemplate
  Scenario: Open a new tab and enter the partner onboarding application url
    Given Click on the "SHARE_PO_APPLICATION_BUTTON" of "partnerOnboardingListingPage"
    Then Open the new tab and enter url "URL_PATH" of "partnerOnboardingListingPage"
    Then Click on the "PO_GET_STARTED_BUTTON" of "fillPartnerOnboardingApplication"
    Then Click on the "PO_START_APPLICATION_BUTTON" of "fillPartnerOnboardingApplication"

  Scenario: Fill the partner onboarding applicant informant
    Given Fill the partner onboarding application
      | FIELD_NAME                       | VALUE              |
      | PO_FIRST_NAME_TEXT_FIELD         | first name         |
      | PO_LAST_NAME_TEXT_FIELD          | last name          |
      | PO_DESIGNATION_TEXT_FIELD        | Automation_testing |
      | PO_EMAIL_TEXT_FIELD              | test@mail.com      |
      | PO_LEGAL_COMPANY_NAME_TEXT_FIELD | Test company       |
      | PO_COMPANY_WEBSITE_TEXT_FIELD    | www.sample.com     |

    Then Click on the "PO_NEXT_BUTTON" of "fillPartnerOnboardingApplication"

    Then Fill the partner onboarding application
      | FIELD_NAME                             | VALUE                                |
      | PO_ADDITIONAL_BUSINESS_PHONE_TEXTFIELD | 98567423                             |
      | PO_ADDITIONAL_ADDRESS_1_TEXTFIELD      | #380 WESTMINSTER ST, PROVIDENCE      |
      | PO_ADDITIONAL_ADDRESS_2_TEXTFIELD      | #177 MAIN STREET, LITTLETON NH 03561 |
      | PO_ADDITIONAL_ZIPCODE_TEXTFIELD        | 11211                                |
      | PO_ADDITIONAL_CITY_TEXTFIELD           | Bangor                               |
      | PO_ADDITIONAL_STATE_TEXTFIELD          | Boston                               |
      | PO_ADDITIONAL_COUNTRY_TEXTFIELD        | England                              |

    Then Click on the "PO_NEXT_BUTTON" of "fillPartnerOnboardingApplication"

    Then Fill the partner onboarding application
      | FIELD_NAME                                   | VALUE                           |
      | PO_COMPANY_INFORMATION_TEXTFIELD             | Automation_test_company         |
      | PO_COMPANY_ADDRESS_TEXTFIELD                 | #380 WESTMINSTER ST, PROVIDENCE |
      | PO_COMPANY_ZIPCODE_TEXTFIELD                 | 03561                           |
      | PO_COMPANY_CITY_TEXTFIELD                    | Ahmedabad                       |
      | PO_COMPANY_STATE_TEXTFIELD                   | Gujarat                         |
      | PO_COMPANY_COUNTRY_TEXTFIELD                 | India                           |
      | PO_MAIN_CONTACT_NAME_TEXTFIELD               | Automation                      |
      | PO_MAIN_CONTACT_TITLE_TEXTFIELD              | Testing                         |
      | PO_MAIN_CONTACT_EMAIL_TEXTFIELD              | Test@mail.com                   |
      | PO_MAIN_CONTACT_BUSINESS_PHONE_TEXTFIELD     | 098356778                       |
      | PO_ALLIANCE_CONTACT_NAME_TEXTFIELD           | Automation                      |
      | PO_ALLIANCE_CONTACT_TITLE_TEXTFIELD          | Testing                         |
      | PO_ALLIANCE_CONTACT_EMAIL_TEXTFIELD          | Test@mail.com                   |
      | PO_ALLIANCE_CONTACT_BUSINESS_PHONE_TEXTFIELD | 876545678                       |

    Then Click on the "PO_NEXT_BUTTON" of "fillPartnerOnboardingApplication"

  Scenario Outline: Fill the partner onboarding relationship information
    Given Click on the "<ELEMENT>" of "fillPartnerOnboardingApplication"
    Examples:
      | ELEMENT                                |
      | PO_RELATIONSHIP_INFO_DROPDOWN_1        |
      | PO_RELATIONSHIP_INFO_SELECT_DROPDOWN_1 |
      | PO_RELATIONSHIP_INFO_DROPDOWN_2        |
      | PO_RELATIONSHIP_INFO_SELECT_DROPDOWN_2 |
      | PO_RELATIONSHIP_INFO_DROPDOWN_3        |
      | PO_RELATIONSHIP_INFO_SELECT_DROPDOWN_3 |
      | PO_RELATIONSHIP_INFO_DROPDOWN_4        |
      | PO_RELATIONSHIP_INFO_SELECT_DROPDOWN_4 |
      | PO_RELATIONSHIP_INFO_DROPDOWN_5        |
      | PO_RELATIONSHIP_INFO_SELECT_DROPDOWN_5 |
      | PO_NEXT_BUTTON                         |

  Scenario Outline: Fill the partner onboarding value propsotion
    Given Enter "<VALUE_PROPOSITION_CUSTOMER>" in "PO_VALUE_PROPOSITION_END_CUSTOMER_TEXT_FIELD" of "fillPartnerOnboardingApplication"
    Then Enter "<VALUE_PROPOSITION_TECH>" in "PO_VALUE_PROPOSITION_PRONTO_TECHNOLOGY_TEXT_FIELD" of "fillPartnerOnboardingApplication"
    Then Enter "<VALUE_PROPOSITION_COMPANY>" in "PO_VALUE_PROPOSITION_COMPANY_TEXT_FIELD" of "fillPartnerOnboardingApplication"
    Then Enter "<REQUEST_JOINT_SOLUTION>" in "PO_VALUE_PROPOSITION_JOINT_SOLUTION_TEXT_FIELD" of "fillPartnerOnboardingApplication"
    Then Click on the "PO_NEXT_BUTTON" of "fillPartnerOnboardingApplication"
    Examples:
      | VALUE_PROPOSITION_CUSTOMER | VALUE_PROPOSITION_TECH                                                    | VALUE_PROPOSITION_COMPANY                                                                                                         | REQUEST_JOINT_SOLUTION                                                    |
      | An easy-to-use CRM         | It makes users,working lives simpler, more pleasant, and more productive. | Its not for everyone but then again, no product, service, or app is but it is unique, and its value proposition makes this clear. | provide us with a list of customers who are requesting the joint solution |

  Scenario Outline: Fill the partner onboarding solution
    Given Enter "<DESCRIBE_JOINT_SOLUTION>" in "PO_JOINT_SOLUTION_BUILD_TEXT_FIELD" of "fillPartnerOnboardingApplication"
    Then Enter "<CUSTOMER_BENEFITS>" in "PO_END_CUSTOMER_RECEIVE_TEXTFIELD" of "fillPartnerOnboardingApplication"
    Then Click on the "PO_NEXT_BUTTON" of "fillPartnerOnboardingApplication"
    Examples:
      | DESCRIBE_JOINT_SOLUTION | CUSTOMER_BENEFITS        |
      | joint solution          | benefits to the customer |

  Scenario: Fill the partner onboarding non-disclosure agreement
    Given Fill the partner onboarding application
      | FIELD_NAME                          | VALUE                           |
      | PO_NDA_FIRST_NAME_TEXTFIELD         | First name                      |
      | PO_NDA_LAST_NAME_TEXTFIELD          | Last name                       |
      | PO_NDA_DESIGNATION_TITLE_TEXTFIELD  | Automation                      |
      | PO_NDA_EMAIL_TEXTFIELD              | Automation@test.com             |
      | PO_NDA_LEGAL_COMPANY_NAME_TEXTFIELD | Testing company                 |
      | PO_NDA_ADDRESS_TEXTFIELD            | #380 WESTMINSTER ST, PROVIDENCE |
      | PO_NDA_ZIPCODE_TEXTFIELD            | 03561                           |
      | PO_NDA_CITY_TEXTFIELD               | Boston                          |
      | PO_NDA_STATE_TEXTFIELD              | PROVIDENCE                      |
      | PO_NDA_COUNTRY_TEXTFIELD            | England                         |
    Then Click on the "PO_NEXT_BUTTON" of "fillPartnerOnboardingApplication"
    Then Click on the "PO_SUBMIT_CHECK_BOX" of "fillPartnerOnboardingApplication"
    Then Click on the "PO_SUBMIT_BUTTON" of "fillPartnerOnboardingApplication"
    Then Verify presence of "PO_APPLICATION_SUBMITTED" of "fillPartnerOnboardingApplication"

  Scenario: Quit browser
    Given Quit the browser