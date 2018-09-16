package com.socks.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.socks.model.User;

import base.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class LoginModel extends BasePage {

    private SelenideElement userName = $("#username-modal");
    private SelenideElement password = $("#password-modal");
    private SelenideElement loginBtn = $("#login-modal .modal-body button");
    private SelenideElement loginError = $("#login-message > div");

    public void login(User user){
        userName.setValue(user.getEmail());
        password.setValue(user.getPassword());

        loginBtn.click();
    }

    public LoginModel loginErrorDisplayed(){
        loginError
            .shouldBe(Condition.visible)
            .shouldHave(Condition.exactText("Invalid login credentials."));

        return this;
    }
}
