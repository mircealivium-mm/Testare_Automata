package Tema10.tests;

import Tema10.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Exercitiul2Test {

    @Test
    public void testGetAllProducts() {
        Response response = RestAssured
                .given()
                .baseUri(ApiConfig.FAKE_STORE_URL)
                .when()
                .get("/products")
                .then()
                .extract().response();


        assertEquals(response.getStatusCode(), 200, "Status code ar trebui sa fie 200");


        List<?> products = response.jsonPath().getList("$");
        assertNotNull(products, "Lista de produse nu ar trebui sa fie null");
        assertFalse(products.isEmpty(), "Lista de produse nu ar trebui sa fie goala");


        String title = response.jsonPath().getString("[0].title");
        String category = response.jsonPath().getString("[0].category");
        String image = response.jsonPath().getString("[0].image");

        assertNotNull(title, "Title nu ar trebui sa fie null");
        assertFalse(title.isEmpty(), "Title nu ar trebui sa fie gol");

        assertNotNull(category, "Category nu ar trebui sa fie null");
        assertFalse(category.isEmpty(), "Category nu ar trebui sa fie goala");

        assertNotNull(image, "Image nu ar trebui sa fie null");
        assertFalse(image.isEmpty(), "Image nu ar trebui sa fie goala");
    }
}