package com.fraud.api.conditions;

import org.hamcrest.Matcher;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.ToString;

import static com.fraud.api.logger.TestLifecycleLogger.LOG;
import static java.lang.String.format;

@ToString
@AllArgsConstructor
public class BodyElementCondition implements Condition {

    private String jsonPath;

    private Matcher matcher;

    @Override
    public void check(Response response) {
        LOG.info(
            format("Checking if JsonParameter %s is %s", jsonPath, matcher.toString()));

        response
            .then()
            .assertThat()
            .body(jsonPath, matcher);
    }
}
