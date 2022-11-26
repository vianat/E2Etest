package api;

import api.pojo.AddProductResponse;
import api.pojo.LoginRequest;
import api.pojo.LoginResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import javax.imageio.ImageIO;
import java.io.File;

import static io.restassured.RestAssured.given;

public class API_BASE {
    public static void main(String[] args) {

        final String token;
        String userId;
        String productId;
        String dir = System.getProperty("user.dir");

        // Authorization

        RequestSpecification REQ = new RequestSpecBuilder()
                                        .setBaseUri("https://rahulshettyacademy.com/api/ecom/")
                                        .setContentType(ContentType.JSON)
                                        .build();

        LoginRequest payLoad = new LoginRequest();
        payLoad.setUserEmail("nik.seey87@mail.ru");
        payLoad.setUserPassword("3LuvREk3M7GKe@n");

        RequestSpecification reqLogin = given().log().all().spec(REQ).body(payLoad);

        LoginResponse loginResponse = reqLogin
                                        .when().post("/auth/login")
                                        .then().log().all().extract().response().as(LoginResponse.class);
        userId = loginResponse.getUserId();
        token = loginResponse.getToken();


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
//        AddProductResponse addProductResponse = addProductREQ
//                .when().post("/product/add-product")
//                .then().log().all().extract().response().as(AddProductResponse.class);
//        productId = addProductResponse.getProductId();

// as string
        String addProductResponse = addProductREQ
                .when().post("/product/add-product")
                .then().log().all().extract().response().asString();

        JsonPath js = new JsonPath(addProductResponse);

        productId = js.getString("productId");
    }
}   