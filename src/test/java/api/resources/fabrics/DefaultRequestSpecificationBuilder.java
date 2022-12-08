package api.resources.fabrics;

import api.resources.Utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class DefaultRequestSpecificationBuilder implements IRequestSpecificationBuilder {
    protected String url;
    public DefaultRequestSpecificationBuilder(String url){
        this.url = url;
    }
    public RequestSpecification createSPEC() throws IOException{
        RequestSpecBuilder builder = preBuilderSetting();

        return postBuilderSetting(builder);
    };

    protected RequestSpecBuilder preBuilderSetting() {
        RequestSpecBuilder builder = new RequestSpecBuilder()
                .setBaseUri(url);

        return builder;
    }

    protected RequestSpecification postBuilderSetting(RequestSpecBuilder builder) {
        builder.addFilter(RequestLoggingFilter.logRequestTo(Utils.log))
               .addFilter(ResponseLoggingFilter.logResponseTo(Utils.log));

        return builder.build();
    }
}
