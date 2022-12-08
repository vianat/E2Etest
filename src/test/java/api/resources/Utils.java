package api.resources;

import api.resources.fabrics.BaseRequestSpecificationBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    public static PrintStream log;

    static {
        try {
            log = new PrintStream(new FileOutputStream("api-log.txt", true));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getGlobalProp(String key) throws IOException {
        Properties prop = new Properties();
        String dir = System.getProperty("user.dir");
        prop.load(new FileInputStream(dir + "/src/test/java/resources/data.properties"));
        return prop.getProperty(key);
    }
}