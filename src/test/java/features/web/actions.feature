@SmokeFeature
Feature: Actions functionality

  @smoke
  Scenario Outline: <click> click on element
    Given I navigate to "https://demoqa.com/buttons"
    And Do <click> click on the <button> button
    Then Verify that <click> messege <messege> is present

    Examples:
      | click     | button            | messege                         |
      | "dynamic" | "click me"        | "You have done a dynamic click" |
      | "right"   | "right click me"  | "You have done a right click"   |
      | "double"  | "double click me" | "You have done a double click"  |