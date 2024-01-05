package org.example.homework.restfulbooker;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetParticularUser {


    @Test
    public void verifyUserDetails() {
        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/1")
                .then().log().all()
                .statusCode(200)
                .body("firstname", equalTo("Eric"));


    }
}
