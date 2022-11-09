@SmokeFeature
Feature: Feature of text-box functionality

  @smokeTest
  Scenario: If text-box works properly
    Given Initialize the browser with chrome
    And Navigate to "http://demoqa.com/text-box" Site
    When Enters <username>,<email>,<cAddress>,<pAddress> in all text-boxes inputs
    Then Verify that <username>,<email>,<cAddress>,<pAddress2> are presents in response field
    And close browsers
    
        Examples: 
      | username		| email							| cAddress		| pAddress | pAddress2
      | admin				| test99@gmail.com	| Ad					| pA 			 | pA2