package api.resources.fabrics;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class JsonSpecReqBuilder extends BaseRequestSpecificationBuilder {
    public JsonSpecReqBuilder(String url, String token) {
        super(url, token);
    }

    @Override
    public RequestSpecification createSPEC() throws IOException {

        RequestSpecBuilder builder = preBuilderSetting();

        builder.addHeader("authorization", token);
        builder.setContentType(ContentType.JSON);

        return postBuilderSetting(builder);
    }
}
