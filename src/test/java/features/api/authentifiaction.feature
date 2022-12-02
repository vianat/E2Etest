@SmokeFeature
Feature: Api test positive

  @api
  Scenario Outline: Authentication on server and get token

    Given Send POST request to baseUrl and "Authentifications" endpoint with payload: <email> and <password>
    When Verify that response message is "Login Successfully"
    And Get UserId and token from response
    And Create SPECs with auth token for next requests

    Examples:
      | email                | password           |
      | "nik.seey87@mail.ru" | "3LuvREk3M7GKe@n"  |


  @api
  Scenario: Create product and get productId

    Given Send POST request to baseUrl and "CreateProduct" endpoint with form-data payload
    When Verify that response message is "Product Added Successfully"
    And Get productId from response


  @api
  Scenario: Create order of product and get ordersId

    Given Send POST request to baseUrl and "CreateOrder" endpoint
    When Verify that response message is "Order Placed Successfully"
    And Get ordersId from response


  @api
  Scenario: Get order info of created order

    Given Send GET request to baseUrl and "ViewOrder" endpoint
    When Verify that response message is "Orders fetched for customer Successfully"


  @api
  Scenario: Delete product

    Given Send DELETE request to baseUrl and "DeleteProduct" endpoint
    When Verify that response message is "Product Deleted Successfully"