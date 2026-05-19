package Tema10.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import Tema10.config.ApiConfig;
import Tema10.utils.TokenUtils;

import static org.testng.Assert.*;

public class Exercitiul8Test {

    @Test
    public void testLoginAndGetProfile() {

        String token = TokenUtils.getToken();
        assertNotNull(token, "Token-ul nu ar trebui sa fie null");


        Response meResponse = RestAssured
                .given()
                .baseUri(ApiConfig.DUMMY_JSON_URL)
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/auth/me")
                .then()
                .extract().response();

        assertEquals(meResponse.getStatusCode(), 200, "Status code ar trebui sa fie 200");

        String username = meResponse.jsonPath().getString("username");
        assertNotNull(username, "Username nu ar trebui sa fie null");
        assertFalse(username.isEmpty(), "Username nu ar trebui sa fie gol");

        String email = meResponse.jsonPath().getString("email");
        assertNotNull(email, "Email nu ar trebui sa fie null");
        assertFalse(email.isEmpty(), "Email nu ar trebui sa fie gol");
    }
}