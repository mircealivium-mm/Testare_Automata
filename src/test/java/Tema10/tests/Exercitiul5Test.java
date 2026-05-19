package Tema10.tests;

import Tema10.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Exercitiul5Test {

    @Test
    public void testSearchProducts() {
        Response response = RestAssured
                .given()
                .baseUri(ApiConfig.DUMMY_JSON_URL)
                .queryParam("q", "phone")
                .when()
                .get("/products/search")
                .then()
                .extract().response();


        assertEquals(response.getStatusCode(), 200, "Status code ar trebui sa fie 200");


        List<?> products = response.jsonPath().getList("products");
        assertNotNull(products, "Lista de produse nu ar trebui sa fie null");
        assertFalse(products.isEmpty(), "Lista de produse nu ar trebui sa fie goala");


        String title = response.jsonPath().getString("products[0].title");
        float price = response.jsonPath().getFloat("products[0].price");

        assertNotNull(title, "Title nu ar trebui sa fie null");
        assertFalse(title.isEmpty(), "Title nu ar trebui sa fie gol");
        assertTrue(price > 0, "Price ar trebui sa fie mai mare decat 0");
    }
}
