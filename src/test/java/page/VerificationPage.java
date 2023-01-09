package page;
import data.DataHelper;
import data.SQLConnect;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement verCode = $("[data-test-id=code] input");
    private SelenideElement buttonNext = $("[data-test-id=action-verify]");

    public DashboardPage setCode(String code) {
        verCode.setValue(code);
        buttonNext.click();
        return new DashboardPage();
    }

}
