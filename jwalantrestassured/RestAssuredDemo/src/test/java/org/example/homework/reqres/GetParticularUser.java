package org.example.homework.reqres;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetParticularUser {

    //https://reqres.in/api/users/5
    @Test
    public void verifyUserDetails() {
        given()
                .when()
                .get("https://reqres.in/api/users/5")
                .then().log().all()
                .statusCode(200)
                .body("data.first_name", equalTo("Charles"));


    }
}
