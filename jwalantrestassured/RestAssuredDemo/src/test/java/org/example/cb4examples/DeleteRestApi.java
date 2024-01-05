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

/*An HTTP DELETE method is used to delete an existing resource from the collection of resources.
The DELETE method requests the origin server to delete the resource identified by the Request-URI. On successful deletion of a resource,
it returns  200 (OK) and 204 (No Content) status codes. It may return as 202 (Accepted) status code if the request is queued. */

public class DeleteRestApi {
    RequestSpecification requestSpecification;
    Response response;
    ResponseSpecification responseSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void deleteUser(){
        RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1/delete/1";
        requestSpecification = given();
         response=requestSpecification.delete();
        System.out.println(response.prettyPrint());

        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.body("message", equalTo("Successfully! Record has been deleted"));


    }

    @Test
    public void deleteUserAnotherWay(){

        validatableResponse = given()
                .baseUri("https://dummy.restapiexample.com/api/v1/delete/3")
                .contentType(ContentType.JSON)
                .when()
                .delete()
                .then()
                .assertThat().statusCode(200)
                .body("message", equalTo("Successfully! Record has been deleted"));

        System.out.println("Response :" + validatableResponse.extract().asPrettyString());
    }

}
