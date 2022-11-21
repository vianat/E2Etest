@SmokeFeature
Feature: Feature to test radio button functionality

  @smoke
  Scenario: Check if radio button works properly
  	Given I navigate to "https://demoqa.com/radio-button"
    And user is on webpage
    When clicks on radio button
    Then you should be able to see button is selected