package api.resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class REQEnhancer{
    private String token;
    public REQEnhancer(String token){
        this.token = token;
    }

    public void authEnhancerDefault(RequestSpecBuilder builder){
        builder.addHeader("authorization", token);
    }
    public void authEnhancerWithJSON(RequestSpecBuilder builder){
        builder.addHeader("authorization", token);
        builder.setContentType(ContentType.JSON);
    }

}
