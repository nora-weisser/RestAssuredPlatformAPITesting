import POJO.Footer;
import config.ConfigUtil;
import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import org.testng.Assert;

import static io.restassured.RestAssured.*;


public class Basics {
    public static void main(String[] args) throws Exception {
        // given - all input details
        // when - Submit the API
        // then - validate the response

        RestAssured.baseURI = ConfigUtil.getBaseUrl();

        Footer response = given().log().all()
                .header("X-API-KEY",  ConfigUtil.getApiKey())
                .when().get("/api/cms/v1/footer")
                .then().log().all().extract().as(Footer.class);
        Assert.assertEquals(response.getId(), "page:FOOTER");
    }
}
