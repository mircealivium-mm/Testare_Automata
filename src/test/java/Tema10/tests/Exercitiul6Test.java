package Tema10.tests;

import Tema10.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Exercitiul6Test {

    @Test
    public void testCustomHeader() {
        Response response = RestAssured
                .given()
                .baseUri(ApiConfig.HTTPBIN_URL)
                .header("Course-Name", "API Automation")
                .when()
                .get("/headers")
                .then()
                .extract().response();


        assertEquals(response.getStatusCode(), 200, "Status code ar trebui sa fie 200");


        String courseName = response.jsonPath().getString("headers.Course-Name");
        assertNotNull(courseName, "Header-ul Course-Name nu ar trebui sa fie null");
        assertEquals(courseName, "API Automation", "Valoarea header-ului ar trebui sa fie 'API Automation'");
    }
}
