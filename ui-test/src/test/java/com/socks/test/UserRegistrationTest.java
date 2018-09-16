package com.socks.test;

import org.junit.jupiter.api.Test;

import com.socks.model.User;
import com.socks.pages.MainPage;
import com.socks.service.UserFactory;

import base.BaseTest;

public class UserRegistrationTest extends BaseTest {

    @Test
    void registerUserTest() {
        User user = UserFactory.getDefaultUser();

        MainPage
            .open()
            .register(user)
            .shouldBeLoggedAs(user);

    }
}
