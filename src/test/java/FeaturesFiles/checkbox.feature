Feature: Feature to test checkbox functionality

  @smokeTest2
  Scenario: Check if check box works properly
    Given user is on checkbox page
    When when user clicks on toggle
    And clicks on checkbox
    Then you should be able to see what checkbox you have selected
