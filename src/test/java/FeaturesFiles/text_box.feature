@SmokeFeature
Feature: Feature of text-box functionality

  @smoke
  Scenario: If text-box works properly

  	Given I navigate to "https://demoqa.com/text-box"
    And Enters <username>,<email>,<cAddress>,<pAddress> in text-boxes
    Then Verify that <username>,<email>,<cAddress>,<pAddress> are presents in response
    
       Examples: 
      | username		| email							| cAddress		| pAddress | 
      | admin				| test99@gmail.com	| Sacramento	| Folsom 	| 	