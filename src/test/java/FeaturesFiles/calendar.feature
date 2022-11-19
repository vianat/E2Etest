@SmokeFeature
Feature: Calendar functionality

  @smoke
  Scenario: Set 1ft day of next and mounth next year and 15:00 time
    Given I navigate to "https://demoqa.com/date-picker"

    When click on input [Date And Time]
    And Generate first day of next mounth, next year, [15:00]
    And Clear input
    And Set in input
    Then Verify Date And Time equals setted date and time