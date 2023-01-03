package test;

import Page.AuthPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {
    @Test
    void ValidLoginTest() {
        var authPage = open("http://localhost:9999", AuthPage.class);
        var verPage = authPage.validLogin();
        var dashboardPage = verPage.validCode();

    }

    @Test
    void NoValidLogin() {
        var authPage = open("http://localhost:9999", AuthPage.class);
        authPage.noValidLogin();
        authPage.visibleErrorNotification();

    }

}
