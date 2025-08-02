package tests;

import POJO.Footer;
import builder.SpecBuilder;
import config.ConfigUtil;
import constants.ApiPaths;
import io.restassured.RestAssured;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class FooterTests {
    public static void main(String[] args) {
        RestAssured.baseURI = ConfigUtil.getBaseUrl();

        Footer response = given()
                .spec(SpecBuilder.getRequestSpec())
                .when()
                .get(ApiPaths.FOOTER_PAGE)
                .then()
                .spec(SpecBuilder.getResponseSpec())
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("FooterSchema.json"))
                .extract().as(Footer.class);

        Assert.assertEquals(response.getId(), "page:FOOTER", "Footer ID did not match");
    }
}
