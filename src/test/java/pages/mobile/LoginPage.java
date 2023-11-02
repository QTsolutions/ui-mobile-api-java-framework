package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.BaseFunction;

public class LoginPage extends BaseFunction {
    //Creating a constructor for this class
    public LoginPage(){
        super();
        PageFactory.initElements(appiumDriver, this);
    }

    //Defining the locators, final is used because we are not modifying these selectors
    public static By usernameSelByID = MobileBy.AccessibilityId("input-email");
    public static By passwordSelByID = MobileBy.AccessibilityId("input-password");
    private final By confirmPassSelByID = MobileBy.AccessibilityId("input-repeat-password");
    public static By loginBtnSelByID = MobileBy.AccessibilityId("button-LOGIN");
    public static By signUpBtnSelByXPATH = MobileBy.xpath("//*[@text='SIGN UP']");
    public static By loginBtnSelByXPATH = MobileBy.xpath("//*[@text='OK']");
    public static By successTitleAlertXPATH = MobileBy.xpath("//*[@text='Success']");
    public static By loginSignupTitleXPATH = MobileBy.xpath("//*[@text='Login / Sign up Form']");
    public static By signUpLabelByXPATH = MobileBy.xpath("//*[@text='Sign up']");
    public static By signedUpMessageXPATH = MobileBy.xpath("//*[@resource-id='android:id/message']");
    public static By signedUpAlertXPATH = MobileBy.xpath("//*[@text='Signed Up!']");

    //Action Methods
    public void inputUsername(String usernameText) {
        mobileElementSendKeys(usernameSelByID, usernameText);
    }
    public void inputPassword(String passwordText){
        mobileElementSendKeys(passwordSelByID, passwordText);
    }
    public void inputConfirmPassword(String confirmPassText){
        mobileElementSendKeys(confirmPassSelByID, confirmPassText);
    }
    public void clickLoginBtn(){
        mobileElementClick(loginBtnSelByID);
    }
    public void clickSignUpBtn(){
        mobileElementClick(signUpBtnSelByXPATH);
    }
    public String signedUpMessage(){
        return mobileElementGetText(signedUpMessageXPATH);
    }
    public boolean signedUpAlert(){
        return mobileElement(signedUpAlertXPATH).isDisplayed();
    }
    public void clickSignUp(){
    mobileElementClick(signUpLabelByXPATH);
    }
    public void clickOkAlert(){
        mobileElementClick(loginBtnSelByXPATH);
    }
    public boolean successAlert(){
        return mobileElement(successTitleAlertXPATH).isDisplayed();
    }
    public boolean loginSignupTitle(){
        return mobileElement(loginSignupTitleXPATH).isDisplayed();
    }

}
