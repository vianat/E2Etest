package api;

import api.pojo.LoginRequest;
import api.pojo.LoginResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class API_BASE {

    public static void main(String[] args) {

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

        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getUserId());
        System.out.println(loginResponse.getMessage());
    }
}   