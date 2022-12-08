package api.resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java.io.*;
import java.util.Properties;

public class Utils {
    public static PrintStream log;
    static RequestSpecification SPEC;

    static {
        try {
            log = new PrintStream(new FileOutputStream("api-log.txt", true));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static RequestSpecification login_SPEC() throws IOException {

        SPEC = new RequestSpecBuilder()
                .setBaseUri(getGlobalProp("url"))
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON)
                .build();
        return SPEC;
    }

    public static RequestSpecification enhanceSPEC(IBuilderEnhancer enhancer) throws IOException {

        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setBaseUri(getGlobalProp("url"));

        enhancer.accept(builder); // это вызов лямбды

        SPEC = builder.addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .build();

        return SPEC;
    }
    public static RequestSpecification SPEC_token_and_JSON(String token) throws IOException {

        SPEC = new RequestSpecBuilder()
                .setBaseUri(getGlobalProp("url"))
                .addHeader("authorization", token)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON)
                .build();
        return SPEC;
    }
    public static RequestSpecification SPEC_token(String token) throws IOException {

        SPEC = new RequestSpecBuilder()
                .setBaseUri(getGlobalProp("url"))
                .addHeader("authorization", token)
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .build();
        return SPEC;
    }
    public static String getGlobalProp(String key) throws IOException {
        Properties prop = new Properties();
        String dir = System.getProperty("user.dir");
        prop.load(new FileInputStream(dir + "/src/test/java/resources/data.properties"));
        return prop.getProperty(key);
    }
}