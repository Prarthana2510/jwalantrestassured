package org.example.cb4examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRestApi {

    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @Test
    public void createUser() {

        String jsonData = "{\"name\":\"bhav\",\"salary\":\"123\",\"age\":\"23\"}";

        validatableResponse = given()
                .contentType(ContentType.JSON)
                .body(jsonData)
                .post("https://dummy.restapiexample.com/api/v1/create")
                .then()
                .statusCode(200)
                .body("data.name", equalTo("bhav"));

        System.out.println(validatableResponse.extract().asPrettyString());
    }

    @Test
    public void createUserAnotherWay() {
        String jsonData = "{\"name\":\"bhav\",\"salary\":\"123\",\"age\":\"23\"}";

        // GIVEN
        validatableResponse = given()
                .baseUri("https://dummy.restapiexample.com/api/v1")
                .contentType(ContentType.JSON)
                .body(jsonData)

                // WHEN
                .when()
                .post("/create")

                // THEN
                .then()
                .statusCode(200)
                .body("data.name", equalTo("bhav"));

        System.out.println(validatableResponse.extract().asPrettyString());
    }

    @Test
    public void createUserAnotherWayNonBdd() {
        //Below is the example of testing a POST request in Non-BDD format,
        // where I have used ValidatableResponse for the assertion of status and status line and body of the Response.

        String jsonData = "{\"name\":\"bhav\",\"salary\":\"123\",\"age\":\"23\"}";

        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/create";

        //create request specification
        requestSpecification = RestAssured.given();

        // // Setting content type to specify format in which request payload will be sent.
        requestSpecification.contentType(ContentType.JSON);

        //// Adding body as string
        requestSpecification.body(jsonData);

        //// Calling POST method
        response = requestSpecification.post();

        // // Let's print response body.
        System.out.println(response.prettyPrint());

        validatableResponse = response.then();
        // Check status code
        validatableResponse.statusCode(200);

        // Check response body - name attribute
        validatableResponse.body("data.name", equalTo("bhav"));

    }
}
