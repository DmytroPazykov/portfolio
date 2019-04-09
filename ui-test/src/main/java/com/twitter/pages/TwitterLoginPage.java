package com.twitter.pages;

import com.twitter.base.BasePage;
import com.codeborne.selenide.Selenide;
import com.twitter.model.User;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class TwitterLoginPage extends BasePage {

    private LoginBlock loginBlock = new LoginBlock();

    @Step
    public static TwitterLoginPage open() {
        return Selenide.open("", TwitterLoginPage.class);
    }

    @Step
    public TwitterLandingPage loginAs(User user) {
        loginBlock.login(user);

        return new TwitterLandingPage();
    }
}
