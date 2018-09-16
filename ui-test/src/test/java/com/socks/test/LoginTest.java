package com.socks.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.socks.model.User;
import com.socks.pages.LoginModel;
import com.socks.pages.MainPage;
import com.socks.service.UserFactory;

import base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    @Tag("ui")
    void userCanLogin() {
        User user = UserFactory.getDefaultUser();

        MainPage
            .open()
            .loginAs(user);

        at(LoginModel.class).loginErrorDisplayed();
    }
}
