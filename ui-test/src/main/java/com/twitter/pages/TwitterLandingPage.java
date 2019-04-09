package com.twitter.pages;

import com.twitter.base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.twitter.model.User;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class TwitterLandingPage extends BasePage {

    private SelenideElement loggedUserLink = $(".DashboardProfileCard-name");

    @Step
    public TwitterLandingPage shouldBeLoggedAs(User user) {
        loggedUserLink
                .waitUntil(Condition.visible, 10000)
                .shouldHave(Condition.exactText(user.getFirstName()));
        return this;
    }
}
