import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ReqresApiTest {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in/api";

        // GET Request

        Response getResponse = given()
                .header("x-api-key", "reqres-free-v1")
                .when().get("/users/2")
                .then().statusCode(200)
                .body("data.first_name", equalTo("Janet"))
                .extract().response();

        // Extracting email from GET
        String email = getResponse.jsonPath().getString("data.email");

        // POST Request
        given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body("{ \"name\": \"John\", \"email\" : \"" + email + "\" }")
        .when()
                .post("/users")
        .then()
                .statusCode(201);

        // PUT

        given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body("{ \"name\": \"Updated\", \"job\": \"Engineer\" }")
        .when()
                .put("/users/2")
        .then()
                .statusCode(200);

        // PATCH

        given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body("{ \"job\" : \"Senior Engineer\" }")
        .when()
                .patch("/users/2")
        .then()
                .statusCode(200);

        // DELETE
        given()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .delete("/users/2")
            .then()
                .statusCode(204);

        verifyMessagePresence("{\"message\":\"Welcome!\"}");


    }

    public static void verifyMessagePresence(String responseBody){
        JsonPath js = new JsonPath(responseBody);

        if (js.get("message") != null) {
            System.out.println("Message key found :" + js.get("message"));
        } else {
            System.out.println("Message key not found");
        }
    }
}
