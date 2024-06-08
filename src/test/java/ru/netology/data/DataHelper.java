package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private DataHelper() {}
    private static final Faker faker = new Faker(new Locale("en"));

    @Value
    public static class AuthInfo {
         String login;
         String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo() {
        return new AuthInfo("petya", "123qwerty");
    }

    public static AuthInfo getRandomInfo(){
        return new AuthInfo(faker.name().firstName(), faker.internet().password());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class VerificationCode {
         String code;
    }

    public static String getVerificationCodeFor(AuthInfo authInfo) {
        return SQLHelper.getVerCode();
    }

    public static String getRandomCode(AuthInfo authInfo){
        return faker.number().digits(5);
    }
}
