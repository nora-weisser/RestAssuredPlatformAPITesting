import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class Basics {
    public static void main(String[] args) throws Exception {
        // given - all input details
        // when - Submit the API
        // then - validate the response

        Dotenv dotenv = Dotenv.load();

        RestAssured.baseURI = dotenv.get("BASE_URL");;

        given().log().all()
                .header("X-API-KEY",  dotenv.get("API_KEY"))
                .when().get("/api/cms/v1/footer")
                .then().log().all().assertThat().statusCode(200);
    }
}
