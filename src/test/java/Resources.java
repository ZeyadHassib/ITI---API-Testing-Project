import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
//Final
public class Resources {


    @Test
    public void getResources() {




            given() .baseUri("https://reqres.in").queryParam("page",1).
                    when().get("/api/unknown")
                    .then().log().all()
                    .assertThat().statusCode(200)
                    .assertThat().body("page",equalTo(1))
                    .assertThat().body("per_page",equalTo(6))
                    .assertThat().body("total",equalTo(12))
                    .assertThat().body("total_pages",equalTo(2))
                    .assertThat().body("data[0].id",equalTo(1))
                    .assertThat().body("data[0].name",equalTo("cerulean"))
                    .assertThat().body("data[0].year",equalTo(2000))
                    .assertThat().body("data[0].color",equalTo("#98B2D1"))
                    .assertThat().body("data[0].pantone_value",equalTo("15-4020"))
                    .assertThat().body("data",hasSize(6))
                    .assertThat().header("Content-Type", containsString("application/json"));


        }


}
