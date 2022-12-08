@SmokeFeature
Feature: Progress Bar functionality

  @smoke
  Scenario: Check Progress bar functionality
    Given I navigate to "https://demoqa.com/progress-bar"
    And Click start button and wait 2000 mseconds
    And Click stop button
    Then Get progress percentage