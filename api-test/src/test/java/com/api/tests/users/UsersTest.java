package com.api.tests.users;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.socks.api.logger.TestLifecycleLogger;
import com.socks.api.logger.TimingExtension;
import com.socks.api.model.User;
import com.socks.api.service.UserService;

import static com.socks.api.conditions.Conditions.bodyField;
import static com.socks.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(TimingExtension.class)
public class UsersTest implements TestLifecycleLogger {

    private UserService service = new UserService();

    @Tag("smoke")
    @ParameterizedTest(name = "{index} ==> User=''{0}'', code={1}")
    @MethodSource("userProvider")
    void testCanRegisterUser(User user, int code) {
        LOG.info(
            String.format(
                "Test data have been created : \n\n%s\n",
                user.toString()));

        service
            .registerUser(user)
            .shouldHave(statusCode(200))
            .shouldHave(bodyField("id", notNullValue()));
    }

    static Stream<Arguments> userProvider() {
        return Stream.of(
            Arguments.of(new User()
                .setEmail("test@gmail.com")
                .setFirstName("userFirstName")
                .setLastName("userLastName")
                .setPassword("12345678"), 200),
            Arguments.of(new User()
                .setEmail("test@gmail.com")
                .setFirstName("userFirstName")
                .setLastName("userLastName")
                .setPassword("12345678"), 500),
            Arguments.of(new User()
                    .setEmail("test@gmail.com"), 500),
            Arguments.of(new User()
                .setEmail("test@gmail.com")
                .setFirstName("userFirstName"), 500),
            Arguments.of(new User()
                .setEmail("test@gmail.com")
                .setFirstName("userFirstName")
                .setLastName("userLastName"), 500)
        );
    }

}