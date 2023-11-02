package models.pages.methodChaining;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPageWithMethodChaining {
    private AppiumDriver<MobileElement> appiumDriver;
    //Creating a constructor for this class
    public LoginPageWithMethodChaining(AppiumDriver<MobileElement> appiumDriver) {
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
    public LoginPageWithMethodChaining inputUsername(String usernameText){
        this.username().sendKeys(usernameText);
        return this; //returns the instance for the page
    }
    public MobileElement password() {
        return appiumDriver.findElement(passwordSelByID);
    }
    public LoginPageWithMethodChaining inputPassword(String passwordText){
        this.password().sendKeys(passwordText);
        return this; //returns the instance for the page
    }
    public MobileElement loginBtn() {
        return appiumDriver.findElement(loginBtnSelByID);
    }
    public void clickLoginBtn(){  // No need to return the instance at the end of the chain
        this.loginBtn().click();
    }
}
