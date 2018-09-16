package com.api.conditions;

import org.hamcrest.Matcher;

import com.api.logger.TestLifecycleLogger;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.ToString;

import static java.lang.String.format;

@ToString
@AllArgsConstructor
public class BodyElementCondition implements Condition {

    private String jsonPath;

    private Matcher matcher;

    @Override
    public void check(Response response) {
        TestLifecycleLogger.LOG.info(
            format("Checking if JsonParameter %s is %s", jsonPath, matcher.toString()));

        response
            .then()
            .assertThat()
            .body(jsonPath, matcher);
    }
}
