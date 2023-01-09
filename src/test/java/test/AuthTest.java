package test;

import data.DataHelper;
import data.SQLConnect;
import org.junit.jupiter.api.AfterAll;
import page.AuthPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {
//    @AfterAll
//    void clearBase() {
//        SQLConnect.clearAllTables();
//    }

    @Test
    void validLoginTest() {
        var authPage = open("http://localhost:9999", AuthPage.class);
        var verPage = authPage.validLogin(DataHelper.getValidFirstUser());
        var dashboardPage = verPage.setCode(SQLConnect.getVerifyCode().getVerCode());

    }

    @Test
    void noValidLogin() {
        var authPage = open("http://localhost:9999", AuthPage.class);
        authPage.validLogin(DataHelper.getRandomUser());
        authPage.visibleErrorNotification();

    }

}
