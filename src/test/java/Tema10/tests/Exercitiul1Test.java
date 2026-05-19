package Tema10.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import Tema10.config.ApiConfig;
import Tema10.data.TestData;

import static org.testng.Assert.*;

public class Exercitiul1Test {

    @Test
    public void testGetProduct() {
        Response response = RestAssured
                .given()
                .baseUri(ApiConfig.FAKE_STORE_URL)
                .when()
                .get("/products/1")
                .then()
                .extract().response();


        assertEquals(response.getStatusCode(), 200, "Status code ar trebui sa fie 200");


        int id = response.jsonPath().getInt("id");
        assertEquals(id, 1, "ID-ul ar trebui sa fie 1");


        String title = response.jsonPath().getString("title");
        assertNotNull(title, "Title nu ar trebui sa fie null");
        assertFalse(title.isEmpty(), "Title nu ar trebui sa fie gol");


        float price = response.jsonPath().getFloat("price");
        assertTrue(price > 0, "Price ar trebui sa fie mai mare decat 0");
    }
}
