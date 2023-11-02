package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunction;
import utilities.PropFileHandler;

public class LoginPage extends BaseFunction {
    public LoginPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    //Defining the locators, final is used because we are not modifying these selectors
    public static By contactListAppTitle = By.xpath("//h1[text()='Contact List App']");
    public static By emailTextfield = By.xpath("//input[@id='email']");
    public static By passwordField = By.xpath("//input[@id='password']");
    public static By submitBtn = By.xpath("//button[@id='submit']");
    public static By signUpBtn = By.xpath("//button[@id='signup']");

    //Action Methods
    public void userLandsOnTheLoginPage(){
        waitForWebElementToBeVisible(contactListAppTitle);
        element(contactListAppTitle).isDisplayed();
    }

    public void userEnterAndSubmitCredentials(){
        element(emailTextfield).sendKeys(PropFileHandler.readProperty("username"));
        element(passwordField).sendKeys(PropFileHandler.readProperty("password"));
        element(submitBtn).click();
    }
}
