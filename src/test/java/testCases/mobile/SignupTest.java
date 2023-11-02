package testCases.mobile;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.mobile.FormsPage;
import pages.mobile.LoginPage;
import pages.mobile.NavigationsPage;
import utilities.BaseFunction;

public class SignupTest extends BaseFunction{
    LoginPage loginPage = new LoginPage();
    NavigationsPage navigationsPage = new NavigationsPage();
    FormsPage formsPage = new FormsPage();

    @Test()
    public void userSignUp(){
        navigationsPage.clickLoginLabel();
        loginPage.clickSignUp();
        loginPage.inputUsername("shoaib@gmail.com");
        loginPage.inputPassword("123456@Qwe");
        loginPage.inputConfirmPassword("123456@Qwe");
        loginPage.clickSignUpBtn();
        Assert.assertTrue(loginPage.signedUpAlert());
        Assert.assertTrue(loginPage.signedUpMessage().contains("You successfully signed up!"));
        loginPage.clickOkAlert();
    }
}
