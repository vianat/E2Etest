package steps.api;

import api.pojo.LoginRESP;
import api.resources.PayloadBuilder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import java.io.FileNotFoundException;
import static api.resources.Utils.*;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class APITest {
    RequestSpecification SPEC;
    RequestSpecification SPECnoJSON;
    String token;
    String userId;
    String productId;
    String ordersId;
    String dir = System.getProperty("user.dir");
    PayloadBuilder payload = new PayloadBuilder();
    LoginRESP loginRESP;
    @Given("Do POST request to {string} & {string} with payload: {string} and {string}")
    public void do_post_request_with_payload(String url, String endpoint, String email, String pass) throws FileNotFoundException {
        RequestSpecification loginREQ = given().relaxedHTTPSValidation()
                .spec(login_SPEC(url))
                .body(payload.loginPayload(email, pass));

        loginRESP = loginREQ
                .when().post(endpoint)
                .then().extract().response().as(LoginRESP.class);
    }
    @When("Verify that request status code is {string}")
    public void verify_that_request_status_code_is(String string) {
        assertEquals(loginRESP.getMessage(), "Login Successfully");
    }
    @And("Get UserId and token from response")
    public void get_UserId_and_token_from_response() {
        userId = loginRESP.getUserId();
        token = loginRESP.getToken();
    }
    @When("Create SPECs with auth token for next requests")
    public void create_spe_cs_with_auth_token_for_next_requests() throws FileNotFoundException {
        SPEC = SPEC_with_auth_token_and_JSON(token);
        SPECnoJSON = SPEC_with_auth_token_no_JSON(token);
    }
}
