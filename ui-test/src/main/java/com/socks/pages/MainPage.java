package com.socks.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.socks.model.User;

import base.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static org.awaitility.Awaitility.await;

public class MainPage extends BasePage {

    private SelenideElement registerLink = $("#register > a");
    private SelenideElement loggedUserLabel = $("#howdy  a");
    private SelenideElement loginBtn = $("#login > a");

    private RegistrationModel registrationModel = new RegistrationModel();
    private LoginModel loginModel = new LoginModel();

    public static MainPage open() {
        return Selenide.open("/", MainPage.class);
    }

    public MainPage register(User user) {
        registerLink.click();
        registrationModel.registerUser(user);

        return new MainPage();
    }

    public void loginAs(User user) {
        loginBtn.click();

        loginModel.login(user);
    }

    public MainPage shouldBeLoggedAs(User user) {
        await()
            .ignoreException(NoSuchElementException.class)
            .atMost(10, TimeUnit.SECONDS)
            .pollInterval(2, TimeUnit.SECONDS)
            .untilAsserted(() ->
                loggedUserLabel
                    .shouldBe(Condition.visible)
                    .shouldHave(
                        Condition.exactText(
                            String.format("Logged in as %s %s",
                                user.getFirstName(),
                                user.getLastName())))
            );
        return this;
    }
}
