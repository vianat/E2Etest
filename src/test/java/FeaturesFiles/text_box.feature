@SmokeFeature
Feature: Feature of text-box functionality

  @smoke
  Scenario: If text-box works properly
  	I navigate to "http://demoqa.com/text-box"
  	
    Given Enters <username>,<email>,<cAddress>,<pAddress> in text-boxes
    Then Verify that <username>,<email>,<cAddress>,<pAddress> are presents in response
    
       Examples: 
      | username		| email							| cAddress		| pAddress | 
      | admin				| test99@gmail.com	| Sacramento	| Folsom 	| 	