package ru.netology.pages;

import ru.netology.data.DataHelper.AuthInfo;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    public VerificationPage validLogin(AuthInfo user) {

        $("[data-test-id='login'] .input__control").sendKeys(user.getLogin());
        $("[data-test-id='password'] .input__control").sendKeys(user.getPassword());
        $("[data-test-id='action-login']").click();
        return new VerificationPage();
    }
}