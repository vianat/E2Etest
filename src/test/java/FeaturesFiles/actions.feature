@SmokeFeature
Feature: Actions functionality

  @smoke
  Scenario: <click> click on element
    I navigate to "https://demoqa.com/buttons"

    Given  I navigate to "https://demoqa.com/buttons"
    And Do <click> click on the <button> button
    Then Verify that <click> messege <messege> is present
    
       Examples: 
      | click 		|	button						|	messege													|
      | "dynamic" | "click me"				|"You have done a dynamic click" 	|
      | "right" 	|	"right click me"	|"You have done a right click" 		|
      | "double" 	| "double click me"	|"You have done a double click" 	|