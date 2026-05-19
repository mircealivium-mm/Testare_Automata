package Tema10.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import Tema10.config.ApiConfig;

import static org.testng.Assert.*;

public class Exercitiul10Test {

    // Test negativ 1: produs inexistent
    @Test
    public void testGetProductInexistent() {
        Response response = RestAssured
                .given()
                .baseUri(ApiConfig.DUMMY_JSON_URL)
                .when()
                .get("/products/99999")
                .then()
                .extract().response();

        assertEquals(response.getStatusCode(), 404, "Produsul inexistent ar trebui sa returneze 404");
    }

    // Test negativ 2: login cu parola gresita
    @Test
    public void testLoginParolaGresita() {
        String body = "{\n" +
                "   \"username\": \"emilys\",\n" +
                "   \"password\": \"parolaGresita123\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .baseUri(ApiConfig.DUMMY_JSON_URL)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/auth/login")
                .then()
                .extract().response();

        assertEquals(response.getStatusCode(), 400, "Login cu parola gresita ar trebui sa returneze 400");

        String message = response.jsonPath().getString("message");
        assertNotNull(message, "Mesajul de eroare nu ar trebui sa fie null");
        assertFalse(message.isEmpty(), "Mesajul de eroare nu ar trebui sa fie gol");
    }

    // Test negativ 3: token invalid
    @Test
    public void testTokenInvalid() {
        Response response = RestAssured
                .given()
                .baseUri(ApiConfig.DUMMY_JSON_URL)
                .header("Authorization", "Bearer token_invalid_123")
                .when()
                .get("/auth/me")
                .then()
                .extract().response();

        assertEquals(response.getStatusCode(), 401, "Token invalid ar trebui sa returneze 401");

        String message = response.jsonPath().getString("message");
        assertNotNull(message, "Mesajul de eroare nu ar trebui sa fie null");
        assertFalse(message.isEmpty(), "Mesajul de eroare nu ar trebui sa fie gol");
    }
}