package ru.netology.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.pages.LoginPage;
import ru.netology.pages.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataHelper.*;
import static ru.netology.data.SQLHelper.*;

public class Tests {


    @BeforeEach
    void setUp() {
        open("http://localhost:9999", LoginPage.class);


    }

    @AfterEach
    void tearDown() {
        cleanCodes();
    }

    @AfterAll
    static void tearDownAll() {
        cleaner();
    }


    @Test
    void successLogin() {
        LoginPage loginPage = new LoginPage();
        var user = getAuthInfo();


        loginPage.validLogin(user);
        VerificationPage verificationPage = new VerificationPage();
        var code = getVerCode();

        verificationPage.validCode(code);
    }

    @Test
    void invalidLogin() {
        LoginPage loginPage = new LoginPage();
        var user = getRandomInfo();
        loginPage.invalidLogin(user);
    }

    @Test
    void invalidCode() {
        LoginPage loginPage = new LoginPage();
        var user = getAuthInfo();


        loginPage.validLogin(user);
        VerificationPage verificationPage = new VerificationPage();
        var code = getRandomCode();
        verificationPage.invalidCode(code);
    }
}
