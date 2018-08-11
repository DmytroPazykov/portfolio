package com.socks.api.conditions;

import org.hamcrest.Matcher;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;

import static com.socks.api.logger.TestLifecycleLogger.LOG;
import static java.lang.String.format;

@AllArgsConstructor
public class BodyElementCondition implements Condition {

    private String stringName;

    private Matcher matcher;

    @Override
    public void check(Response response) {
        LOG.info(
            format("Checking if JsonString %s is %s", stringName, matcher.toString()));

        String value = response.getBody().jsonPath().getString(stringName);

        matcher.matches(value);
    }
}
