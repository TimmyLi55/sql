package Data;

import com.github.javafaker.Faker;
import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }
    @Value
    public static class VerificationCode{
        private String verCode;
    }

    public static AuthInfo getValidFirstUser() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getRandomUser(){
        var faker = new Faker();
        return new AuthInfo(faker.name().name(),faker.internet().password());
    }

    public static VerificationCode getINValidVerifyCode() {
        var code = new Faker().numerify("#####");
        return new VerificationCode(code);
    }


}
