package builder;

import config.ConfigUtil;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {

    public static RequestSpecification getDefaultSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigUtil.getBaseUrl())
                .addHeader("X-API-KEY", ConfigUtil.getApiKey())
                .setContentType("application/json")
                .build();
    }
}
