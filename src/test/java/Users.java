import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Users {



    @Test
    public void GetAllUsers() {


        given() .baseUri("https://reqres.in").queryParam("page",1).
        when().get("/api/users")
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("page",equalTo(1))
                .assertThat().body("per_page",equalTo(6))
                .assertThat().body("total",equalTo(12))
                .assertThat().body("total_pages",equalTo(2))
                .assertThat().body("data[0].id",equalTo(1))
                .assertThat().body("data[0].email",equalTo("george.bluth@reqres.in"))
                .assertThat().body("data[0].first_name",equalTo("George"))
                .assertThat().body("data[0].last_name",equalTo("Bluth"))
                .assertThat().body("data[0].avatar",equalTo("https://reqres.in/img/faces/1-image.jpg"))
                .assertThat().body("data",hasSize(6))
                .assertThat().header("Content-Type", containsString("application/json"));


    }
    //Final
    @Test
    public void getCertainUsers() {


        given() .baseUri("https://reqres.in").
                when().get("/api/users/1")
                .then().log().all()
                .assertThat().statusCode(200)

                .assertThat().body("data.id",equalTo(1))
                .assertThat().body("data.email",equalTo("george.bluth@reqres.in"))
                .assertThat().body("data.first_name",equalTo("George"))
                .assertThat().body("data.last_name",equalTo("Bluth"))
                .assertThat().body("data.avatar",equalTo("https://reqres.in/img/faces/1-image.jpg"))

                .assertThat().header("Content-Type", containsString("application/json"));
    }
        @Test
        public void postCertainUsers() {
            given()
                    .baseUri("https://reqres.in/api")
                    .contentType("application/json")
                    .body("{\"name\":\"morpheus\", \"job\":\"leader\"}")
                    .when()
                    .post("/users")
                    .then()
                    .statusCode(201)
                    .body("name", equalTo("morpheus"))
                    .body("job", equalTo("leader"));
        }

    @Test
    public void putCertainUsers() {
        given()
                .baseUri("https://reqres.in/api")
                .contentType("application/json")
                .body("{\"name\":\"Marsel\", \"job\":\"zion resident\"}")
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .body("name", equalTo("Marsel"))
                .body("job", equalTo("zion resident"));
    }

    @Test
    public void deleteCertainUsers() {
        given()
                .baseUri("https://reqres.in/api")
                .when()
                .delete("/users/2") // Assuming the ID of the user to delete is 2
                .then()
                .statusCode(204); // Assuming 204 No Content is expected
    }











}
