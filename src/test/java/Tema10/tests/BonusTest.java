package Tema10.tests;

import Tema10.config.ApiConfig;
import Tema10.data.TestData;
import Tema10.utils.RequestUtils;
import Tema10.utils.ResponseTimeUtils;
import Tema10.utils.TokenUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class BonusTest {

    @Test
    public void testGetProductsWithLimitAndResponseTime() {
        Map<String, Object> params = Map.of("limit", TestData.PRODUCTS_LIMIT);

        Response response = RequestUtils.getWithParams(
                ApiConfig.DUMMY_JSON_URL,
                "/products",
                params
        );

        assertEquals(response.getStatusCode(), 200);

        List<?> products = response.jsonPath().getList("products");
        assertEquals(products.size(), TestData.PRODUCTS_LIMIT);

        ResponseTimeUtils.assertResponseTime(response);
    }

    @Test
    public void testSearchProductsResponseTime() {
        Map<String, Object> params = Map.of("q", TestData.SEARCH_QUERY);

        Response response = RequestUtils.getWithParams(
                ApiConfig.DUMMY_JSON_URL,
                "/products/search",
                params
        );

        assertEquals(response.getStatusCode(), 200);

        List<?> products = response.jsonPath().getList("products");
        assertFalse(products.isEmpty());

        ResponseTimeUtils.assertResponseTime(response);
    }

    @Test
    public void testLoginAndProfileWithHelpers() {
        String token = TokenUtils.getToken();
        assertNotNull(token);

        Response response = RequestUtils.getWithToken(
                ApiConfig.DUMMY_JSON_URL,
                "/auth/me",
                token
        );

        assertEquals(response.getStatusCode(), 200);

        String username = response.jsonPath().getString("username");
        String email = response.jsonPath().getString("email");

        assertNotNull(username);
        assertNotNull(email);

        ResponseTimeUtils.assertResponseTime(response);
    }
}
