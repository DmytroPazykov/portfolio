package com.twitter.test;

import com.api.logger.TimingExtension;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.twitter.model.User;
import com.twitter.pages.LoginBlock;
import com.twitter.pages.TwitterLoginPage;
import com.twitter.service.UserFactory;

import com.twitter.base.BaseTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

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

    @Test
    void calculatorTest(){
        SelenideElement button_2 = $(By.id("com.android.calculator2:id/digit_2"));
        SelenideElement button_add = $(By.id("com.android.calculator2:id/op_add"));
        SelenideElement button_7 = $(By.id("com.android.calculator2:id/digit_7"));
        SelenideElement button_equals = $(By.id("com.android.calculator2:id/eq"));
        SelenideElement result_field = $(By.id("com.android.calculator2:id/formula"));

        button_2.click();
        button_add.click();
        button_7.click();
        button_equals.click();
        result_field.shouldHave(Condition.exactText("9"));


    }
}
