package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunction;

public class HomePage extends BaseFunction {
    //Creating a constructor for this class
    public HomePage(){
        super();
        PageFactory.initElements(driver, this);
    }

    //Defining the locators
    public static By loginLabelSelByID = MobileBy.AccessibilityId("Login");

//    Action Methods
    public void clickLoginLabel(){
        element(loginLabelSelByID);
    }

}
