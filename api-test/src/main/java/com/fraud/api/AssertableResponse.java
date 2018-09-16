package com.fraud.api;

import com.fraud.api.conditions.Condition;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class AssertableResponse {

    @Getter
    private Response response;

    @Step("Response should have {0}")
    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }

    @Step("Check if response has Json model {0}")
    public <T> T returnResponseAs(Class<T> type) {
        return response.as(type);
    }
}
