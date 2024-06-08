package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper.VerificationCode;

import static com.codeborne.selenide.Selenide.$;


public class VerificationPage {
    private SelenideElement code = $("[data-test-id='code'] .input__control");
    private SelenideElement button = $("[data-test-id='action-verify']");

    public VerificationPage() {
        code.shouldBe(Condition.visible);
    }

    public void verify (String verifyCode) {
        code.sendKeys(verifyCode);


    }

    public DashBoardPage validCode(String verifyCode){
        verify(verifyCode);
        button.click();
        return new DashBoardPage();
    }
}
