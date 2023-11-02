package models.pages.mainInteractionMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage {
    private AppiumDriver<MobileElement> appiumDriver;
    //Creating a constructor for this class
    public LoginPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    //Defining the locators, final is used because we are not modifying these selectors
    private final By usernameSelByID = MobileBy.AccessibilityId("input-email");
    private final By passwordSelByID = MobileBy.AccessibilityId("input-password");
    private final By loginBtnSelByID = MobileBy.AccessibilityId("button-LOGIN");

    //Getters
    public AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    public MobileElement username() {
        return appiumDriver.findElement(usernameSelByID);
    }

    public void inputUsername(String usernameText){
        this.username().sendKeys(usernameText);
    }
    public MobileElement password() {
        return appiumDriver.findElement(passwordSelByID);
    }
    public void inputPassword(String passwordText){
        this.password().sendKeys(passwordText);
    }
    public MobileElement loginBtn() {
        return appiumDriver.findElement(loginBtnSelByID);
    }
    public void clickLoginBtn(){
        this.loginBtn().click();
    }
}
