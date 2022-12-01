@SmokeFeature
Feature: Login and get auth token

  @api
  Scenario Outline: Authentication on server and get token

    Given Do POST request to "https://rahulshettyacademy.com/api/ecom/" & "auth/login" with payload: <email> and <password>
    When Verify that request status code is "OK"
    And Get UserId and token from response
    And Create SPECs with auth token for next requests

    Examples:
      | email                | password           |
      | "nik.seey87@mail.ru" | "3LuvREk3M7GKe@n"  |