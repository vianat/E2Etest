@SmokeFeature
Feature: Feature to test login functionality

@smokeTest5
  Scenario: Check if login is successfull with walid cridentials
    Given user is on login page
    When user enters valid username and password
    And clicks login button
    Then user is navigated to the home page