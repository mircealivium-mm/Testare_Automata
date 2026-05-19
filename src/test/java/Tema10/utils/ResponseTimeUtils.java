package Tema10.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.testng.Assert.assertTrue;

public class ResponseTimeUtils {

    private static final long MAX_RESPONSE_TIME_MS = 3000;

    public static void assertResponseTime(Response response) {
        long responseTime = response.getTime();
        assertTrue(responseTime < MAX_RESPONSE_TIME_MS,
                "Response time prea mare: " + responseTime + "ms. Max acceptat: " + MAX_RESPONSE_TIME_MS + "ms");
    }
}
