package com.socks.api.service;

import com.socks.api.AssertableResponse;
import com.socks.api.model.User;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.socks.api.logger.TestLifecycleLogger.LOG;

public class UserService {

    private RequestSpecification setup() {
        return RestAssured.given()
            .contentType(ContentType.JSON)
            .filters(new RequestLoggingFilter(),
                new ResponseLoggingFilter())
            .baseUri("http://178.128.192.196/");
    }

    public AssertableResponse registerUser(User user) {

        LOG.info("Registering user");

        Response register = setup()
            .body(user)
            .when()
            .post("register")
            .then().extract().response();

        return new AssertableResponse(register);
    }
}
