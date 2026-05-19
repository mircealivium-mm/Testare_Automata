package Tema10.tests;

import Tema10.config.ApiConfig;
import Tema10.data.TestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Exercitiul3Test {

    @Test
    public void testCreateProduct() {
        String category = TestData.PRODUCT_CATEGORY;
        String body = "{\n" +
                "   \"title\": \"" +TestData.PRODUCT_TITLE+"\",\n" +
                "   \"price\": 29.99,\n" +
                "   \"category\": \"" + category + "\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .baseUri(ApiConfig.FAKE_STORE_URL)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/products")
                .then()
                .extract().response();


        assertEquals(response.getStatusCode(), 201, "Status code ar trebui sa fie 200");


        String title = response.jsonPath().getString("title");
        assertEquals(title, TestData.PRODUCT_TITLE, "Title-ul ar trebui sa fie cel trimis");


        String responseCategory = response.jsonPath().getString("category");
        assertEquals(responseCategory, "electronics", "Category ar trebui sa fie cea trimisa");
    }
}
