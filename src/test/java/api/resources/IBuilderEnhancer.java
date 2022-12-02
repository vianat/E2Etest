package api.resources;

import io.restassured.builder.RequestSpecBuilder;

import java.util.function.Consumer;

public interface IBuilderEnhancer extends Consumer<RequestSpecBuilder> {
    void accept(RequestSpecBuilder builder);
}
