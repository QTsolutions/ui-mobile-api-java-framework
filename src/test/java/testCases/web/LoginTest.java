package testCases.web;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.web.ContactListPage;
import pages.web.LoginPage;
import utilities.BaseFunction;

public class LoginTest extends BaseFunction {
    LoginPage loginPage = new LoginPage();
    ContactListPage contactListPage = new ContactListPage();
    @Test
    public void registeredUserLogin(){
        loginPage.userLandsOnTheLoginPage();
        loginPage.userEnterAndSubmitCredentials();
        //        Assert
        contactListPage.userLandsOnContactListPage();
        contactListPage.userClicksOnLogout();
        loginPage.userLandsOnTheLoginPage();
        //        Assert
    }
}
