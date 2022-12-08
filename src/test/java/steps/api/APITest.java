package steps.api;

import api.pojo.LoginRESP;
import api.resources.Endpoints;
import api.resources.IBuilderEnhancer;
import api.resources.PayloadBuilder;
import api.resources.REQEnhancer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;

import static api.resources.Utils.*;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class APITest {

    RequestSpecification addProductREQ;
    static REQEnhancer enhancer;
    static String userId;
    static String productId;
    static String ordersId;
    static String responseMessage;
    static String addProductRESP;
    static String createOrderRESP;
    static String getOrderRESP;
    static String dir = System.getProperty("user.dir");
    PayloadBuilder payload = new PayloadBuilder();
    LoginRESP loginRESP;
    JsonPath js;
    IBuilderEnhancer authEnhancer;

    // Authentifications
            @Given("Send POST request to baseUrl and {string} endpoint with payload: {string} and {string}")
            public void send_POST_request_with_payload(String endpoint, String email, String pass) throws IOException {

                Endpoints endpoints = Endpoints.valueOf(endpoint);

                RequestSpecification loginREQ = given()
                        .relaxedHTTPSValidation()
                        .spec(login_SPEC())
                        .body(payload.loginPayload(email, pass));

                loginRESP = loginREQ
                        .when()
                        .post(endpoints.getEndpoint())
                        .then().extract().response().as(LoginRESP.class);

                responseMessage = loginRESP.getMessage();
            }
            @When("Verify that response message is {string}")
            public void verify_that_response_message_is(String expected) {
                assertEquals(responseMessage, expected);
            }
            @And("Get UserId and token from response")
            public void get_UserId_and_token_from_response() {
                userId = loginRESP.getUserId();
                enhancer = new REQEnhancer(loginRESP.getToken());
            }

    // create product

            @Given("Send POST request to baseUrl and {string} endpoint with form-data payload")
            public void send_POST_request_to_baseUrl_and_endpoint_with_form_data(String endpoint) throws IOException {

                Endpoints endpoints = Endpoints.valueOf(endpoint);

                addProductREQ = given().spec(enhanceSPEC(enhancer::authEnhancerDefault))
                        .params("productCategory", "fashion")
                        .params("productName", "fufel")
                        .params("productAddedBy", userId)
                        .params("productSubCategory", "shirts")
                        .params("productPrice", "100500")
                        .params("productDescription", "Abibas Uriginals")
                        .params("productFor", "women")
                        .multiPart("productImage", new File(dir + "/src/test/java/api/attachment.png"));

                addProductRESP = addProductREQ
                        .when().post(endpoints.getEndpoint())
                        .then().extract().response().asString();

                js = new JsonPath(addProductRESP);
                responseMessage = js.getString("message");
            }
            @When("Get productId from response")
            public void get_product_id_from_response() {
                js = new JsonPath(addProductRESP);
                productId = js.getString("productId");
            }

    // create order
            @Given("Send POST request to baseUrl and {string} endpoint")
            public void send_POST_request_to_baseUrl_and_endpoint(String endpoint) throws IOException {

                Endpoints endpoints = Endpoints.valueOf(endpoint);

                RequestSpecification SPECWithJSON = enhanceSPEC(enhancer::authEnhancerWithJSON);

                RequestSpecification createOrderREQ = given().spec(SPECWithJSON).body(payload.createOrderPayload(productId));

                createOrderRESP = createOrderREQ
                        .when().post(endpoints.getEndpoint())
                        .then().extract().response().asString();

                js = new JsonPath(createOrderRESP);
                responseMessage = js.getString("message");
            }
            @When("Get ordersId from response")
            public void get_orders_id_from_response() {
                js = new JsonPath(createOrderRESP);
                ordersId = js.getString("orders");
                ordersId = ordersId.substring( 1, ordersId.length() - 1 );
            }

    // get order info
            @Given("Send GET request to baseUrl and {string} endpoint")
            public void send_get_request_to_base_url_and_endpoint(String endpoint) throws IOException {

                Endpoints endpoints = Endpoints.valueOf(endpoint);

                RequestSpecification SPECWithJSON = enhanceSPEC(enhancer::authEnhancerWithJSON);

                RequestSpecification getOrderREQ = given().spec(SPECWithJSON);

                getOrderRESP = getOrderREQ
                        .when().get(""+endpoints.getEndpoint()+ ordersId)
                        .then().extract().response().asString();

                js = new JsonPath(getOrderRESP);
                responseMessage = js.getString("message");
            }

    // delete product
            @Given("Send DELETE request to baseUrl and {string} endpoint")
            public void send_delete_request_to_base_url_and_endpoint(String endpoint) throws IOException {

                Endpoints endpoints = Endpoints.valueOf(endpoint);

                RequestSpecification SPECWithJSON = enhanceSPEC(enhancer::authEnhancerWithJSON);

                RequestSpecification deleteProductREQ = given().spec(SPECWithJSON).pathParams("productId", productId);

                String deleteProductRESP = deleteProductREQ
                        .when().delete(""+endpoints.getEndpoint()+"{productId}")
                        .then().extract().response().asString();

                js = new JsonPath(deleteProductRESP);
                responseMessage = js.getString("message");
            }
}