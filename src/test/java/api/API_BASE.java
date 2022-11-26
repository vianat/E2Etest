package api;

import io.restassured.builder.RequestSpecBuilder;

public class API_BASE {

    public static void main(String[] args) {

        new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/api/");
    }
}
