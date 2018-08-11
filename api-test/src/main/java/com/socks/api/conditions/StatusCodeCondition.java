package com.socks.api.conditions;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;

import static com.socks.api.logger.TestLifecycleLogger.LOG;
import static java.lang.String.format;

@AllArgsConstructor
public class StatusCodeCondition implements Condition {

    private int statusCode;

    @Override
    public void check(Response response) {

        LOG.info(
            format("Checking if response status code is %s",
                String.valueOf(statusCode)));

        response.then().assertThat().statusCode(statusCode);
    }
}
