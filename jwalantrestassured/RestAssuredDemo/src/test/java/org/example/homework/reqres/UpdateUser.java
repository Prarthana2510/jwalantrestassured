package org.example.homework.reqres;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    @Test
    public void updateUser() {


        given().log().all()
                .when()
                .put("https://reqres.in/api/users/5")
                .then().log().all()
                .statusCode(200);
                //.body("updatedAt", "2023-12-28T14:45:20.925Z");

        //.body("updatedAt", equalTo("2023-12-28T14:45:20.925Z"));



//        given().log().all()
//                .when()
//                .get("https://reqres.in/api/resource")
//                .then().log().all()
//                .statusCode(200);


    }

}
