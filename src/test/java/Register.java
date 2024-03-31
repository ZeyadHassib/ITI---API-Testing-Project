import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Register {


    @Test()
    public void validRegister() {
        given()
                .baseUri("https://reqres.in/api")
                .contentType("application/json")
                .body("{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }")
                .when()
                .post("/register")
                .then()
                .statusCode(200);



    }

    @Test()
    public void invalidRegister() {
        given()
                .baseUri("https://reqres.in/api")
                .contentType("application/json")
                .body("{ \"email\": \"sydney @fife\"}")
                .when()
                .post("/register")
                .then()
                .statusCode(400).assertThat().body("error", equalTo("Missing password"));
        ;



    }
}
