package models.pages.mainInteractionMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class HomePage {
    private AppiumDriver<MobileElement> appiumDriver;

    //Creating a constructor for this class
    public HomePage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    //Defining the locators, final is used because we are not modifying these selectors
    private final By loginLabelSelByID = MobileBy.AccessibilityId("Login");

    //Getters
    public AppiumDriver<MobileElement> getAppiumDriver() {
        return appiumDriver;
    }

    public MobileElement loginLabel() {
        return appiumDriver.findElement(loginLabelSelByID);
    }
    public void clickLoginLabel(){
        this.loginLabel().click();
    }

}
