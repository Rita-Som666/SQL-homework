package ru.netology.pages;

import com.codeborne.selenide.Condition;
import ru.netology.data.DataHelper.AuthInfo;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    public VerificationPage validLogin(AuthInfo user) {

        $("[data-test-id='login'] .input__control").sendKeys(user.getLogin());
        $("[data-test-id='password'] .input__control").sendKeys(user.getPassword());
        $("[data-test-id='action-login']").click();
        return new VerificationPage();
    }

    public void invalidLogin(AuthInfo user) {
        $("[data-test-id='login'] .input__control").sendKeys(user.getLogin());
        $("[data-test-id='password'] .input__control").sendKeys(user.getPassword());
        $("[data-test-id='action-login']").click();

        $(byText("Неверно указан логин или пароль")).shouldBe(Condition.visible);
    }
}