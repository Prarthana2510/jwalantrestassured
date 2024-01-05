package org.example.homework.restfulbooker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateUser {
    ValidatableResponse validatableResponse;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    @Test
    public void createUser() {


        String jsonData = "{\n" +
                "    \"firstname\" : \"Jack\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        validatableResponse = given()
                .contentType(ContentType.JSON)
                .body(jsonData)
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .body("booking.firstname", equalTo("Jack"));

        System.out.println(validatableResponse.extract().asPrettyString());
    }
}
