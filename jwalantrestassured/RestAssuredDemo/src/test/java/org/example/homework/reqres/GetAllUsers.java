package org.example.homework.reqres;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsers {

    @Test
    public void getAllUsers() {


        given().log().all()
                .when()
                .get("https://reqres.in/api/users")
                .then().log().all()
                .statusCode(200);


//        given().log().all()
//                .when()
//                .get("https://reqres.in/api/resource")
//                .then().log().all()
//                .statusCode(200);


    }

}
