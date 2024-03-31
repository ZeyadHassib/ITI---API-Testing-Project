import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
//Final
public class Login  {

    @Test()
    public void validLogin() {
        given()
                .baseUri("https://reqres.in/api")
                .contentType("application/json")
                .body("{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }")
                .when()
                .post("/login")
                .then()
                .statusCode(200);



    }

    @Test()
    public void invalidLogin() {
        given()
                .baseUri("https://reqres.in/api")
                .contentType("application/json")
                .body("{ \"email\": \"sydney @fife\"}")
                .when()
                .post("/login")
                .then()
                .statusCode(400).assertThat().body("error", equalTo("Missing password"));
        ;



    }
}
