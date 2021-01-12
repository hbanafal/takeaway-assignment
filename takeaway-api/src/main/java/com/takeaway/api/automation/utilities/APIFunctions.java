package com.takeaway.api.automation.utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIFunctions {

    private static String BASE_URI = GenericFunctions.getConfigProperties().getProperty("baseURI");

    private static String USER_ID = GenericFunctions.getConfigProperties().getProperty("user_id");

    private static RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(BASE_URI + "/api/" + USER_ID)
            .addHeader("Content-Type", "application/json;charset=utf-8")
            .addHeader("Authorization", "Bearer " + getAccessToken()).build();

    public static Response response;

    public static Response getRequest(String url) {
        response = RestAssured.given(reqSpec).get(url);
        return response;
    }

    public static <T> Response postRequest(String url) {
        response = RestAssured.given(reqSpec).post(url);
        return response;
    }

    public static <T> Response updateRequest(String url) {
        response = RestAssured.given(reqSpec).put(url);
        return response;
    }

    public static <T> Response deleteRequest(String url) {
        response = RestAssured.given(reqSpec).delete(url);
        return response;
    }

    private static String getAccessToken() {
        return RestAssured.given().formParam("grant_type", "client_credentials")
                .formParam("client_id", GenericFunctions.getConfigProperties().getProperty("client_id"))
                .formParam("client_secret", GenericFunctions.getConfigProperties().getProperty("client_secret")).when()
                .post(BASE_URI + "/token").jsonPath().getString("access_token");
    }
}
