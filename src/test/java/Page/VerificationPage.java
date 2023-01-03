package Page;
import Data.SQLConnect;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement verCode = $("[data-test-id=code] input");
    private SelenideElement buttonNext = $("[data-test-id=action-verify]");

    public DashboardPage validCode() {
        verCode.setValue(SQLConnect.getVerifyCode().getVerCode());
        buttonNext.click();
        return new DashboardPage();
    }

}
