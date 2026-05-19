package Tema10.tests;

import Tema10.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Exercitiul4Test {

    @Test
    public void testGetProductsWithLimit() {
        Response response = RestAssured
                .given()
                .baseUri(ApiConfig.DUMMY_JSON_URL)
                .queryParam("limit", 5)
                .when()
                .get("/products")
                .then()
                .extract().response();


        assertEquals(response.getStatusCode(), 200, "Status code ar trebui sa fie 200");


        int limit = response.jsonPath().getInt("limit");
        assertEquals(limit, 5, "Limita ar trebui sa fie 5");


        List<?> products = response.jsonPath().getList("products");
        assertNotNull(products, "Lista de produse nu ar trebui sa fie null");
        assertEquals(products.size(), 5, "Lista ar trebui sa contina exact 5 produse");
    }
}
