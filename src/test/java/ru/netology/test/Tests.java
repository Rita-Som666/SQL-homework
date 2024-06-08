package ru.netology.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.pages.DashBoardPage;
import ru.netology.pages.LoginPage;
import ru.netology.pages.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataHelper.getAuthInfo;
import static ru.netology.data.SQLHelper.*;

public class Tests {
    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    VerificationPage verificationPage = new VerificationPage();


    @AfterEach
    void tearDown(){
cleanCodes();
    }

    @AfterAll
    static void tearDownAll(){
        cleaner();
    }

    @BeforeEach
    void setUp(){
        open("http://localhost:9999", LoginPage.class);

    }

    @Test
    void successLogin(){
        var user = getAuthInfo();
        var code = getVerCode();

        loginPage.validLogin(user);
        verificationPage.validCode(code);
    }
}
