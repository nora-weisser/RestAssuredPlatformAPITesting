package builder;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

public class ResponseSpecFactory {

    public static ResponseSpecification defaultSpec200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }
}
