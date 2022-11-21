@SmokeFeature
Feature: Drag and drop
  @smoke
  Scenario: drag element to element and drop

    Given I navigate to "https://demoqa.com/droppable"
    When drag element and drop on box
    Then Check the box text changed to is "Dropped!"