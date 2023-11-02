package testCases.mobile;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.mobile.LoginPage;
import pages.mobile.NavigationsPage;
import utilities.BaseFunction;
public class LoginTest extends BaseFunction{
    LoginPage loginPage = new LoginPage();
    NavigationsPage navigationsPage = new NavigationsPage();

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
        initializeMobileSession();
    }
    @AfterMethod
    public void afterSetUp(){
        System.out.println("After Method");
        closeMobileSession();
    }

    @Test()
    public void userLogin(){
        navigationsPage.clickLoginLabel();
        loginPage.inputUsername("shoaib@gmail.com");
        loginPage.inputPassword("123456@Qwe");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.successAlert());
        loginPage.clickOkAlert();
    }

    @Test()
    public void userLogin1(){
        navigationsPage.clickLoginLabel();
        Assert.assertTrue(loginPage.loginSignupTitle());
        loginPage.inputUsername("harsh@gmail.com");
        loginPage.inputPassword("987654@Qwe");
        loginPage.clickLoginBtn();
        Assert.assertTrue(loginPage.successAlert());
        loginPage.clickOkAlert();
    }
}
