package ru.netology.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class DashBoardPage {
    public DashBoardPage(){
        $("[data-test-id='dashboard']").shouldBe(Condition.visible);
    }
}
