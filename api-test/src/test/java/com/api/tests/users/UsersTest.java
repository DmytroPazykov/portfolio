package com.api.tests.users;

import java.util.stream.Stream;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.api.logger.TestLifecycleLogger;
import com.api.logger.TimingExtension;
import com.socks.model.User;
import com.socks.service.UserService;

import static com.api.conditions.Conditions.bodyField;
import static com.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(TimingExtension.class)
public class UsersTest implements TestLifecycleLogger {

    private final UserService service = new UserService();

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
                .setEmail("asdad@gmail.com")
                .setFirstName(RandomStringUtils.randomAlphabetic(10))
                .setLastName(RandomStringUtils.randomAlphabetic(10))
                .setPassword("12345678"), 200),
            Arguments.of(new User()
                .setEmail("asasdasdd@gmail.com")
                .setFirstName(RandomStringUtils.randomAlphabetic(10))
                .setLastName(RandomStringUtils.randomAlphabetic(10))
                .setPassword("12345678"), 500),
            Arguments.of(new User()
                .setEmail("asdasdasd@gmail.com"), 500),
            Arguments.of(new User()
                .setEmail("asdadsadas@gmail.com")
                .setFirstName(RandomStringUtils.randomAlphabetic(10)), 500),
            Arguments.of(new User()
                .setEmail("test@gmail.com")
                .setFirstName(RandomStringUtils.randomAlphabetic(10))
                .setLastName(RandomStringUtils.randomAlphabetic(10)), 500)
        );
    }

}