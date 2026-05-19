package Tema10.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import Tema10.config.ApiConfig;
import Tema10.data.TestData;

public class TokenUtils {

    public static String getToken() {
        String body = "{\n" +
                "   \"username\": \"" + TestData.LOGIN_USERNAME + "\",\n" +
                "   \"password\": \"" + TestData.LOGIN_PASSWORD + "\"\n" +
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

        return response.jsonPath().getString("accessToken");
    }
}