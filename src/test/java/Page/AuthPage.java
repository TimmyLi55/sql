package Page;

import Data.DataHelper;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement actionButton = $("[data-test-id=action-login]");
    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public VerificationPage validLogin() {
        loginField.setValue(DataHelper.getValidFirstUser().getLogin());
        passwordField.setValue(DataHelper.getValidFirstUser().getPassword());
        actionButton.click();
        return new VerificationPage();

    }

    public AuthPage noValidLogin() {
        loginField.setValue(DataHelper.getRandomUser().getLogin());
        passwordField.setValue((DataHelper.getRandomUser().getPassword()));
        actionButton.click();
        return this;
    }

    public AuthPage visibleErrorNotification() {
        errorNotification.shouldHave(visible).shouldHave(text("Неверно указан логин или пароль"));
        return this;
    }

    public AuthPage clearLoginAndPassword() {
        loginField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        passwordField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        return this;
    }
}
