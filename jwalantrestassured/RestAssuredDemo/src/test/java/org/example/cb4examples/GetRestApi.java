package org.example.cb4examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRestApi {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void getAllEmployeesWay1() {

        given().log().all()
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employees")
                .then().log().all()
                .statusCode(200);

    }

    @Test
    public void getAllEmployeesWay2() {
        // validate response
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";

        //create a request specification
        requestSpecification = RestAssured.given();

        //calling method
        response = requestSpecification.get();

        //print response
        System.out.println(response.prettyPrint());

        validatableResponse = response.then();

        //get status code
        validatableResponse.statusCode(200);


    }

    @Test
    public void getAllEmployeesTestStatusCodeBdd() {
        //If you don’t want to use ValidatableResponse for the assertion,
        // you can use Response from io.restassured .response to get the status code and status line,
        // which are asserted using JUnit.Assert.
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";

        //create a request specification
        requestSpecification = RestAssured.given();

        //calling method
        response = requestSpecification.get();

        //print response
        System.out.println(response.prettyPrint());

        // Get status line
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

        // Get status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void verifyEmployeesDetails() {
// Given
        given()

                // When
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employee/1")

                // Then
                .then()
                .statusCode(200)

                // To verify
                .body("data.employee_name", equalTo("Tiger Nixon"))
                .body("message", equalTo("Successfully! Record has been fetched."))
                .body("data.id", equalTo(1));
    }

    @Test
    public void verifyEmployeesDetailsFromAllEmployees() {

        given()
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employees")
                .then()
                .statusCode(200)
                .body("data[9].employee_name", equalTo("Sonya Frost"))
                .body("data[9].employee_age", equalTo(23))
                .body("data[15].employee_salary", equalTo(198500));
    }

    @Test
    public void studentApp() {

        // Given
        given()

                // When
                .when()
                .get("http://localhost:8080/student/list")

                // Then
                .then()
                .statusCode(200)
                .body("[5].programme", equalTo("Disaster Management"))
                .body("[5].courses[0]", equalTo("Disaster Preparedness"));

        // To verify booking id at index 3
//                .body("data.employee_name", equalTo("Garrett Winters"))
//                .body("message", equalTo("Successfully! Record has been fetched."));

    }




}
