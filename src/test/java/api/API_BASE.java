package api;

import api.pojo.*;
import api.resources.PayloadBuilder;
import api.resources.Utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class API_BASE extends Utils {
    public static void main(String[] args) throws FileNotFoundException {

        final String token;
        String userId;
        String productId;
        String ordersId;
        String dir = System.getProperty("user.dir");
        PayloadBuilder payload = new PayloadBuilder();

        // Authorization

        RequestSpecification loginREQ = given().relaxedHTTPSValidation()
                .spec(login_SPEC("https://rahulshettyacademy.com/api/ecom/"))
                .body(payload.loginPayload("nik.seey87@mail.ru", "3LuvREk3M7GKe@n"));

        LoginRESP loginRESP = loginREQ
                .when().post("/auth/login")
                .then().extract().response().as(LoginRESP.class);

        userId = loginRESP.getUserId();
        token = loginRESP.getToken();

        RequestSpecification SPEC = SPEC_with_auth_token_and_JSON(token);
        RequestSpecification SPECnoJSON = SPEC_with_auth_token_no_JSON(token);


        // Add product

        RequestSpecification addProductREQ = given().spec(SPECnoJSON)
                .params("productCategory", "fashion")
                .params("productName", "fufel")
                .params("productAddedBy", userId)
                .params("productSubCategory", "shirts")
                .params("productPrice", "100500")
                .params("productDescription", "Abibas Uriginals")
                .params("productFor", "women")
                .multiPart("productImage", new File(dir + "/src/test/java/api/attachment.png"));

// use pojo deserialization
//        AddProductResponse addProductRESP = addProductREQ
//                .when().post("/product/add-product")
//                .then().log().all().extract().response().as(AddProductRESP.class);
//        productId = addProductRESP.getProductId();

// or string
        String addProductRESP = addProductREQ
                .when().post("/product/add-product")
                .then().extract().response().asString();

        JsonPath js = new JsonPath(addProductRESP);
        productId = js.getString("productId");


    // Create order

        RequestSpecification createOrderREQ = given().spec(SPEC).body(payload.createOrderPayload(productId));

        String createOrderRESP = createOrderREQ
                .when().post("/order/create-order")
                .then().extract().response().asString();

        js = new JsonPath(createOrderRESP);
        ordersId = js.getString("orders");
        ordersId = ordersId.substring( 1, ordersId.length() - 1 );


        // Get order

        RequestSpecification getOrderREQ = given().spec(SPEC);

        String getOrderRESP = getOrderREQ
                .when().get("/order/get-orders-details?id=" + ordersId)
                .then().extract().response().asString();


        // Delete product

        RequestSpecification deleteProductREQ = given().spec(SPEC).pathParams("productId", productId);

        deleteProductREQ.when().delete("product/delete-product/{productId}");
    }
}   