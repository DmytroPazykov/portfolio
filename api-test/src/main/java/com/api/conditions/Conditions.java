package com.api.conditions;

import org.hamcrest.Matcher;

public final class Conditions {

    private Conditions() {
    }

    public static StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public static Condition bodyField(String jsonPath, Matcher matcher) {
        return new BodyElementCondition(jsonPath, matcher);
    }
}