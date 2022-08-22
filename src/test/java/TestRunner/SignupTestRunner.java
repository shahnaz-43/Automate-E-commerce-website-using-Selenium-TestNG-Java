package TestRunner;

import Base.Setup;
import Pages.LoginPage;
import Pages.SignupPage;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignupTestRunner extends Setup {
    @Test
    public void doSignup() throws InterruptedException, IOException, ParseException {
        driver.get("http://automationpractice.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.linkLogin.click();
        SignupPage signupPage = new SignupPage(driver);
        Utils utils = new Utils();
        Utils utils2 = new Utils();

        String emailUserAcc = "testautouser" + utils.generateRandomNumber(1000, 9999);
        String email = emailUserAcc + "@test.com";
        String emailUserAcc2 = "testautouser2" + utils.generateRandomNumber(1000, 9999);
        String email2 = emailUserAcc2 + "@testtwo.com";
        String password = utils.generateRandomPassword(8);
        String password2 = utils.generateRandomPassword(7);
        String mobile = "175" + utils.generateRandomNumber(1000000, 9999999);

        signupPage.doRegUser(email, password, mobile, true);
        utils.writeUserInfo(email, password);
        signupPage.doRegUser(email2, password2, mobile, false);
        utils.writeUserInfo(email2, password2);
    }
}




