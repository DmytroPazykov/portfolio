package com.twitter.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.twitter.model.User;

import com.twitter.base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class LoginBlock extends BasePage {

    private SelenideElement userName = $(".LoginForm-username .email-input");
    private SelenideElement password = $(".LoginForm-password [type='password']");
    private SelenideElement loginBtn = $(".LoginForm  input[value='Log in']");
    private SelenideElement loginError = $(".alert-messages .message-text");

    @Step
    public void login(User user){
        userName.setValue(user.getEmail());
        password.setValue(user.getPassword());

        loginBtn.click();
    }

    @Step
    public LoginBlock loginErrorDisplayed(String errorMessage){
        log.debug("Error message should be visible - " + errorMessage);
        loginError
            .shouldBe(Condition.appears)
            .shouldHave(Condition.exactText(errorMessage));

        return this;
    }
}
