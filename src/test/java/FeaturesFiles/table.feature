@SmokeFeature
Feature: Feature of table functionality

  @smoke
  Scenario: Add new row in table
  	
  	Given I navigate to "https://demoqa.com/webtables"
    And Click [Add] button
    Then Fill all inputs fields <fname>,<lname>,<email>,<age> ,<salary>,<dep>
    And Click submit button
    Then Check that name is present in table <fname>
    
       Examples: 
      | fname | lname			| email											  | age  | salary			 | dep		 |
      | admin  | admin			| test99@gmail.com 	|  555  	|  777      | fufel 		| 