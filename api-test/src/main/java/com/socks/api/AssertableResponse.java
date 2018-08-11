package com.socks.api;

import com.socks.api.conditions.Condition;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AssertableResponse {

    private Response response;

    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }
}
