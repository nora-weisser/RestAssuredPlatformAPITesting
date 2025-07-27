import POJO.Footer;
import POJO.Network;
import builder.RequestSpecFactory;
import builder.ResponseSpecFactory;
import config.ConfigUtil;
import constants.ApiPaths;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;

public class Basics {
    public static void main(String[] args) {
        RestAssured.baseURI = ConfigUtil.getBaseUrl();

        Footer response = given()
                .spec(RequestSpecFactory.getDefaultSpec())
                .when()
                .get(ApiPaths.FOOTER_PAGE)
                .then()
                .spec(ResponseSpecFactory.defaultSpec200())
                .extract().as(Footer.class);

        Assert.assertEquals(response.getId(), "page:FOOTER", "Footer ID did not match");

        List<Network> networks = response.getNetwork();
        Assert.assertNotNull(networks, "Network list should not be null");
        Assert.assertFalse(networks.isEmpty(), "Network list should not be empty");

        for (Network network : networks) {
            Assert.assertNotNull(network.getType(), "Network type should not be null");

            String link = network.getLink();
            Assert.assertNotNull(link, "Network link is null for type: " + network.getType());

            if (link.contains("@")) {
                Assert.assertTrue(link.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$"), "Invalid email format: " + link);
            } else {
                Assert.assertTrue(link.startsWith("http"), "Invalid URL format: " + link);
                Response linkResponse = given()
                        .when()
                        .head(link);

                int statusCode = linkResponse.getStatusCode();

                Assert.assertEquals(statusCode, 200, "Broken link: " + link);
            }
        }
    }
}
