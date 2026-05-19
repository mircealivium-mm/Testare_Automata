package Tema10.tests;

import Tema10.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Exercitiul7Test {

    @Test
    public void testBasicAuth() {
        Response response = RestAssured
                .given()
                .baseUri(ApiConfig.HTTPBIN_URL)
                .auth().basic("user", "passwd")
                .when()
                .get("/basic-auth/user/passwd")
                .then()
                .extract().response();


        assertEquals(response.getStatusCode(), 200, "Status code ar trebui sa fie 200");


        boolean authenticated = response.jsonPath().getBoolean("authenticated");
        assertTrue(authenticated, "Utilizatorul ar trebui sa fie autentificat");
    }
}
