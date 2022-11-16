@SmokeFeature
Feature: Alerts functionality

  @smokeAlert
  Scenario: Verify text from alert
    Given I navigate to "https://demoqa.com/alerts"
    And Clicks on the "First" button
    And Get and verify message from alert "You clicked a button"
    Then Accept the alert

  @smokeAlert
  Scenario: Verify text from 5 seconds alert
    Given I navigate to "https://demoqa.com/alerts"
    And Clicks on the "Second" button
    And Get and verify message from alert "This alert appeared after 5 seconds"
    Then Accept the alert

  @smokeAlert
  Scenario: Verify text from  confirm alert
    Given I navigate to "https://demoqa.com/alerts"
    And Clicks on the "Third" button
    And Get and verify message from alert "Do you confirm action?"
    Then Decline the alert

  @smokeAlert
  Scenario: Verify text from promt alert
    Given I navigate to "https://demoqa.com/alerts"
    And Clicks on the "Fourth" button
    And Enters name "Fufel"
    And Get and verify message from alert "Please enter your name"
    Then Decline the alert
