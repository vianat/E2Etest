Feature: Feature to test radio button functionality

  @Regression
  Scenario: Check if radio button works properly
  	I navigate to "http://demoqa.com/checkbox"
    Given user is on webpage
    When clicks on radio button
    Then you should be able to see button is selected
