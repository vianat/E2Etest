@SmokeFeature
Feature: Frame

  @smoke
  Scenario: Get text from frame
    Given  I navigate to "https://demoqa.com/frames"
    When Switch to frame
      | frame1 |
    And Get text from frame
    Then Verify text "This is a sample page" is present in frame

  @smoke
  Scenario: Get text from frame2
    Given  I navigate to "https://demoqa.com/frames"
    When Switch to frame
      | frame2 |
    And Get text from frame
    Then Verify text "This is a sample page" is present in frame