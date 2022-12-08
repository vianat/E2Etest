package api.resources.fabrics;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class SpecReqBuilder extends BaseRequestSpecificationBuilder {
    public SpecReqBuilder(String url, String token) {
        super(url, token);
    }

    @Override
    public RequestSpecification createSPEC() throws IOException {
        RequestSpecBuilder builder = preBuilderSetting();

        builder.addHeader("authorization", token);

        return postBuilderSetting(builder);
    }
}
