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

/*
* PUT is a method of modifying resources where the client sends data that updates the entire resource.

PATCH is a method of modifying resources where the client sends partial data that is to be updated without modifying the entire data.*/

public class PutRestApi {

    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @Test
    public void updateEmployee() {

        String jsonData = "{\n" +
                "    \"name\": \"bhavesh\",\n" +
                "    \"salary\": \"123\",\n" +
                "    \"age\": \"23\"\n" +
                "}";

        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/update/1";

        //create request specification
        requestSpecification = given();

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(jsonData);

        response = requestSpecification.put();

        System.out.println(response.prettyPrint());

        validatableResponse = response.then();

        validatableResponse.statusCode(200);

        validatableResponse.body("data.name", equalTo("bhavesh"));

    }
    @Test
    public void updateEmployeeBdd() {

        String jsonData = "{\n" +
                "    \"name\": \"bhavesh\",\n" +
                "    \"salary\": \"123\",\n" +
                "    \"age\": \"24\"\n" +
                "}";

        given()
                .baseUri("https://dummy.restapiexample.com/api/v1")
                .contentType(ContentType.JSON)
                .body(jsonData)
                .put("/update/1")
                .then().statusCode(200).body("data.name", equalTo("bhavesh"));

    }



}
