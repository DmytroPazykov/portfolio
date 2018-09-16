package com.api.conditions;

import com.api.logger.TestLifecycleLogger;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.ToString;

import static java.lang.String.format;

@ToString
@AllArgsConstructor
public class StatusCodeCondition implements Condition {

    private int statusCode;

    @Override
    public void check(Response response) {

        TestLifecycleLogger.LOG.info(
            format("Checking if response status code is %s",
                String.valueOf(statusCode)));

        response.then().assertThat().statusCode(statusCode);
    }
}
