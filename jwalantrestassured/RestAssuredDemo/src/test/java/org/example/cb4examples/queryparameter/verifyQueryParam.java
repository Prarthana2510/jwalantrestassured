package org.example.cb4examples.queryparameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


/*Query parameters are a way to pass information to an API flexibly and simply.
They are added to the end of the API endpoint URL as a series of key-value pairs.
To append query params to the end of a URL, a ‘?’*/
public class verifyQueryParam {

    @Test
    public void verifyUser() {

        String baseUrl = "https://reqres.in/api";
        String endPoint = "/users";

        //given
        given().log().all()
                .baseUri(baseUrl)
                .queryParam("page", "2")

                //Then
                .when()
                .get(endPoint)
                .then().log().all()

                //To verify the response body
                .statusCode(200)
                .body("page", equalTo(2))
                .body("per_page", equalTo(6))
                .body("total_pages", equalTo(2))
                .body("data[1].first_name", equalTo("Lindsay"));

    }
}
