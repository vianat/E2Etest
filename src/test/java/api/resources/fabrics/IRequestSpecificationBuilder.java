package api.resources.fabrics;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public interface IRequestSpecificationBuilder {
    RequestSpecification createSPEC() throws IOException;
}
