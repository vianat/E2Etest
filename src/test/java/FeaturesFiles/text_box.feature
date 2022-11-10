@SmokeFeature
Feature: Feature of text-box functionality

  @smokeTest
  Scenario: If text-box works properly
  	I navigate to "http://demoqa.com/text-box"
  	
    Given Enters <username>,<email>,<cAddress>,<pAddress> in all text-boxes inputs
    Then Verify that <username>,<email>,<cAddress>,<pAddress> are presents in response field
    
        Examples: 
      | username		| email							| cAddress		| pAddress | 
      | admin				| test99@gmail.com	| Sacramento	| Folsom 	| 	