package api.resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Utils {

    public static RequestSpecification login_SPEC(String url) throws FileNotFoundException {

        PrintStream log = new PrintStream(new FileOutputStream("api-log.txt", true));
        RequestSpecification SPEC = new RequestSpecBuilder()
                .setBaseUri(url)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON)
                .build();
        return SPEC;
    }

    public static RequestSpecification SPEC_with_auth_token_and_JSON(String token) throws FileNotFoundException {

        PrintStream log = new PrintStream(new FileOutputStream("api-log.txt", true));
        RequestSpecification SPEC = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com/api/ecom/")
                .addHeader("authorization", token)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON)
                .build();
        return SPEC;
    }
    public static RequestSpecification SPEC_with_auth_token_no_JSON(String token) throws FileNotFoundException {

        PrintStream log = new PrintStream(new FileOutputStream("api-log.txt", true));
        RequestSpecification SPEC = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com/api/ecom/")
                .addHeader("authorization", token)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .build();
        return SPEC;
    }



}