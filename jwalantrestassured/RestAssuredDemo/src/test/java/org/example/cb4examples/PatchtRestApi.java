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

public class PatchtRestApi {

    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @Test
    public void patchuser() {

        String jsonData = "{\"first_name\": \"bhaveshpatel\"}";

        RestAssured.baseURI = "https://reqres.in/api/users/2";

        //create request specification
        requestSpecification = given();

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.body(jsonData);

        response = requestSpecification.patch();

        System.out.println(response.prettyPrint());

        validatableResponse = response.then();

        validatableResponse.statusCode(200);

        validatableResponse.body("first_name", equalTo("bhaveshpatel"));

    }

    @Test
    public void updateUserBdd(){

        String jsonData = "{\"first_name\": \"bhaveshpatel1\"}";
        given()
                .baseUri("https://reqres.in/api/users/2")
                .contentType(ContentType.JSON)
                .body(jsonData)
                .when()
                .patch()
                .then().statusCode(200)
                .body("first_name", equalTo("bhaveshpatel1"));

        System.out.println("Response :" + validatableResponse.extract().asPrettyString());


    }




}
