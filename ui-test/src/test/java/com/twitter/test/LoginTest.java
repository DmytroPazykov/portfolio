package com.twitter.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.twitter.model.User;
import com.twitter.pages.LoginBlock;
import com.twitter.pages.TwitterLoginPage;
import com.twitter.service.UserFactory;

import com.twitter.base.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    @Tag("ui")
    void userCanNotLoginWithIncorrectData() {
        User user = UserFactory.getRandomUser();

        TwitterLoginPage
                .open()
                .loginAs(user);

        at(LoginBlock.class)
                .loginErrorDisplayed("The username and password you entered did not match our records. Please double-check and try again.");
    }

    @Test
    @Tag("ui")
    void userCanLogin() {
        User user = UserFactory.getDefaultUser();

        TwitterLoginPage
                .open()
                .loginAs(user)
                .shouldBeLoggedAs(user);
    }

    @Test
    @Tag("ui")
    void userCanNotLoginWithIncorrectDataFailCase() {
        User user = UserFactory.getRandomUser();

        TwitterLoginPage
                .open()
                .loginAs(user);

        at(LoginBlock.class)
                .loginErrorDisplayed("fail");
    }
}
