package com.socks.pages;

import com.codeborne.selenide.SelenideElement;
import com.socks.model.User;

import base.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationModel extends BasePage {

    private SelenideElement username = $("#register-username-modal");
    private SelenideElement firstName = $("#register-first-modal");
    private SelenideElement lastName = $("#register-last-modal");
    private SelenideElement email = $("#register-email-modal");
    private SelenideElement password = $("#register-password-modal");
    private SelenideElement registrBtn = $("#register-modal .modal-body button");

    public void registerUser(User user) {
        username.setValue(user.getUserName());
        firstName.setValue(user.getFirstName());
        lastName.setValue(user.getLastName());
        email.setValue(user.getEmail());
        password.setValue(user.getPassword());

        registrBtn.click();
    }
}
