package org.example.homework.restfulbooker;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsers {

    @Test
    public void getAllUsers() {


        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then().log().all()
                .statusCode(200);


//        given().log().all()
//                .when()
//                .get("https://reqres.in/api/resource")
//                .then().log().all()
//                .statusCode(200);


    }

}
