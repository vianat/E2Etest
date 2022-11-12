@SmokeFeature
Feature: Feature of table functionality

  @smokeTest3
  Scenario: Add new row in table
  	I navigate to "https://demoqa.com/webtables"
  	
    Given Click [Add] button
    Then Fill all inputs fields <fname>,<lname>,<email>,<age> ,<salary>,<dep>
    And Click submit button
    Then Check that name is present in table <fname>
    
       Examples: 
      | fname | lname			| email											  | age  | salary			 | dep		 |
      | admin  | admin			| test99@gmail.com 	|  555  	|  777      | fufel 		| 