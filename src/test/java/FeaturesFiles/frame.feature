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

  @smoke
  Scenario: Get text from child frame
    Given  I navigate to "https://demoqa.com/nestedframes"
    When Switch to frame
      | frame1 |
    When Switch to frame
      | child |
    And Get text from frame
    Then Verify text "Child Iframe" is present in frame