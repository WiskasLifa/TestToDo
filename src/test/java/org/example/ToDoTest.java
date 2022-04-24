package org.example;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ToDoTest {

    @Before
public void setup(){
        RestAssured.baseURI="https://api.todoist.com";
        RestAssured.basePath="/rest/v1/";
RestAssured.requestSpecification=RestAssured.given()
        .header("Authorization","Bearer 7d76a47b3412403c0c36d0d6a4606f99cb3c22ea")
        .contentType(ContentType.JSON);
RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

    @Test
    public void createNewProject(){
        String projectName = "ProjektWojtka";
        ValidatableResponse newProject = SerenityRest
                .given()
                .body("{\"name\": \"" + projectName + "\"}")
                .when()
                .post("projects")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
