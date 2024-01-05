package org.example.homework.reqres;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    @Test
    public void deleteUser() {


        given().log().all()
                .when()
                .delete("https://reqres.in/api/users/5")
                .then()
                .statusCode(204).log().all();


                //.body("updatedAt", "2023-12-28T14:45:20.925Z");

        //.body("updatedAt", equalTo("2023-12-28T14:45:20.925Z"));



//        given().log().all()
//                .when()
//                .get("https://reqres.in/api/resource")
//                .then().log().all()
//                .statusCode(200);


    }

}
