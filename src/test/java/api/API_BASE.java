package api;

import api.pojo.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class API_BASE {
    public static void main(String[] args) {

        final String token;
        String userId;
        String productId;
        String ordersId;
        String dir = System.getProperty("user.dir");

        // Authorization

        RequestSpecification loginSPEC = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com/api/ecom/")
                .setContentType(ContentType.JSON)
                .build();

        LoginREQ loginPayload = new LoginREQ();
        loginPayload.setUserEmail("nik.seey87@mail.ru");
        loginPayload.setUserPassword("3LuvREk3M7GKe@n");

        RequestSpecification loginREQ = given().relaxedHTTPSValidation().log().all().spec(loginSPEC).body(loginPayload);

        LoginRESP loginRESP = loginREQ
                .when().post("/auth/login")
                .then().log().all().extract().response().as(LoginRESP.class);

        userId = loginRESP.getUserId();
        token = loginRESP.getToken();


        // Add product

        RequestSpecification addProductSPEC = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com/api/ecom/")
                .addHeader("authorization", token)
                .build();

        RequestSpecification addProductREQ = given().log().all().spec(addProductSPEC)
                .params("productCategory", "fashion")
                .params("productName", "fufel")
                .params("productAddedBy", userId)
                .params("productSubCategory", "shirts")
                .params("productPrice", "100500")
                .params("productDescription", "Addias Originals")
                .params("productFor", "women")
                .multiPart("productImage", new File(dir + "/src/test/java/api/attachment.png"));
// use pojo
//        AddProductResponse addProductRESP = addProductREQ
//                .when().post("/product/add-product")
//                .then().log().all().extract().response().as(AddProductRESP.class);
//        productId = addProductRESP.getProductId();

// as string
        String addProductRESP = addProductREQ
                .when().post("/product/add-product")
                .then().log().all().extract().response().asString();

        JsonPath js = new JsonPath(addProductRESP);
        productId = js.getString("productId");


    // Create order

        RequestSpecification SPEC = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com/api/ecom/")
                .addHeader("authorization", token)
                .setContentType(ContentType.JSON)
                .build();

        Orders createOrderPayload = new Orders();
        Order order = new Order();
        List<Order> orderList = new ArrayList<>();

        order.setCountry("Fuflandia");
        order.setProductOrderedId(productId);

        orderList.add(order);
        createOrderPayload.setOrders(orderList);

        RequestSpecification createOrderREQ = given().log().all().spec(SPEC).body(createOrderPayload);

        String createOrderRESP = createOrderREQ
                .when().post("/order/create-order")
                .then().log().all().extract().response().asString();

        js = new JsonPath(createOrderRESP);
        ordersId = js.getString("orders");
        ordersId = ordersId.substring( 1, ordersId.length() - 1 );


        // Get order

        RequestSpecification getOrderREQ = given().log().all().spec(SPEC);

        String getOrderRESP = getOrderREQ
                .when().get("/order/get-orders-details?id=" + ordersId)
                .then().log().all().extract().response().asString();


        // Delete product

        RequestSpecification deleteProductREQ = given().log().all().spec(SPEC).pathParams("productId", productId);

        deleteProductREQ
                .when().delete("product/delete-product/{productId}")
                .then().log().all();
    }
}   