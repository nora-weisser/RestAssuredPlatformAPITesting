import POJO.Footer;
import builder.RequestSpecFactory;
import builder.ResponseSpecFactory;
import config.ConfigUtil;
import constants.ApiPaths;
import io.restassured.RestAssured;
import org.testng.Assert;

import static io.restassured.RestAssured.*;


public class Basics {
    public static void main(String[] args) throws Exception {
        // given - all input details
        // when - Submit the API
        // then - validate the response
        RestAssured.baseURI = ConfigUtil.getBaseUrl();

        Footer response = given().spec(RequestSpecFactory.getDefaultSpec())
                .when().get(ApiPaths.FOOTER_PAGE)
                .then().spec(ResponseSpecFactory.defaultSpec200()).extract().as(Footer.class);
        Assert.assertEquals(response.getId(), "page:FOOTER", "Footer ID did not match");
    }
}
