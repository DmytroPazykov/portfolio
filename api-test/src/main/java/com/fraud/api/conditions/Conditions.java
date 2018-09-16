package com.fraud.api.conditions;

import org.hamcrest.Matcher;

import com.fraud.api.conditions.BodyElementCondition;
import com.fraud.api.conditions.StatusCodeCondition;

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