import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest {
    @Test
    public void fileIdTest(){
        when().get("https://reqres.in/api/users/2").statusCode();
          }
    @Test
    public void createPostTest(){
      String data= "{\n" +
              "  \"name\": \"morpheus\",\n" +
              "  \"job\": \"leader\"\n" +
              "}";



        given().contentType(ContentType.JSON).
                body(data).
                when().
                post("https://reqres.in/api/users").
                then().
                statusCode(201).
                body("name", equalTo("morpheus"));

    }
}
