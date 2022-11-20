@SmokeFeature
Feature: Verify Hover Over functionality

  @smoke2
  Scenario: Hover over on button and get text

    Given I navigate to "https://demoqa.com/menu"
    When Move to "Main Item 2" button
    And Move to "SUB SUB LIST" button
    And Move to "Sub Sub Item 1" button
    Then Verify "Sub Sub Item 1" button text