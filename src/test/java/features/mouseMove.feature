@SmokeFeature
Feature: Mouse moving to coordinate

  @smoke
  Scenario: Resize element size by mouse moving

    Given I navigate to "https://demoqa.com/resizable"
    When Click and hold
    And Move to coordinate 700 and 100
    Then Drop