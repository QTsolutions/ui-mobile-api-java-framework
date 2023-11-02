package pages.mobile;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import testCases.mobile.LoginTest;
import utilities.BaseFunction;

public class NavigationsPage extends BaseFunction {
    //Creating a constructor for this class
    public NavigationsPage(){
        super();
        PageFactory.initElements(appiumDriver, this);
    }

    //Defining the locators
    public static By loginLabelSelByID = MobileBy.AccessibilityId("Login");
    public static By formsLabelSelByID = MobileBy.AccessibilityId("Forms");

    //Action Methods
    public LoginPage clickLoginLabel(){
        mobileElementClick(loginLabelSelByID);
        return new LoginPage();
    }
    public void clickFormsLabel(){
        mobileElementClick(formsLabelSelByID);
    }


}
