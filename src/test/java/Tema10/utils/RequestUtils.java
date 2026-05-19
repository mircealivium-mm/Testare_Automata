package Tema10.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RequestUtils {

    public static Response get(String baseUri, String path) {
        return RestAssured
                .given()
                .baseUri(baseUri)
                .when()
                .get(path)
                .then()
                .extract().response();
    }

    public static Response getWithParams(String baseUri, String path, Map<String, Object> params) {
        return RestAssured
                .given()
                .baseUri(baseUri)
                .queryParams(params)
                .when()
                .get(path)
                .then()
                .extract().response();
    }

    public static Response post(String baseUri, String path, String body) {
        return RestAssured
                .given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(path)
                .then()
                .extract().response();
    }

    public static Response getWithToken(String baseUri, String path, String token) {
        return RestAssured
                .given()
                .baseUri(baseUri)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(path)
                .then()
                .extract().response();
    }
}
