Feature: Feature to test checkbox functionality

  @smoke
  Scenario: Check if check box works properly

  	Given I navigate to "https://demoqa.com/checkbox"
    And user clicks on toggle
    When clicks on checkbox
    Then you should be able to see what checkbox you have selected