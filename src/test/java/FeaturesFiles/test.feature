@SmokeFeature
Feature: Frame

  @smoke
  Scenario: Get text from frame
    Given  I navigate to "https://demoqa.com/frames"
    When Switch to frame2
      | frame1 |
    #And Get text from frame
    And step
      | frame1 |
    #Then Verify text "This is a sample page" is present in frame