@SmokeFeature
Feature: Windows and Tab functionality

  @smoke
  Scenario: Switch to new tab
    Given  I navigate to "https://demoqa.com/browser-windows"
    And Click on the "New Tab" button
    And Switch to new tab or window
    And Verify that "This is a sample page" is present in new tab or window
    Then Close the tab or window

  @smoke
  Scenario: Switch to new window
    Given  I navigate to "https://demoqa.com/browser-windows"
    And Click on the "New Window" button
    And Switch to new tab or window
    And Verify that "This is a sample page" is present in new tab or window
    And Switch back
    And Switch to new tab or window
    Then Close the tab or window

  @smoke
  Scenario: Switch to new window message
    Given  I navigate to "https://demoqa.com/browser-windows"
   	And Click on the "New Window Message" button
   	And Switch to new tab or window
    #And Verify that "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization." is present in new tab or window
   	Then Close the tab or window