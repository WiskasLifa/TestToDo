package org.example;

import io.restassured.RestAssured;
import org.junit.Test;

public class AppTest {
@Test
public void hello_world_test(){

    RestAssured
            .given().baseUri("http://numbersapi.com")
            .log().all()
            .when()
            .get("/1111/year")
            .then()
            .log().all();
    }
}