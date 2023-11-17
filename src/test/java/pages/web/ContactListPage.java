package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunction;

public class ContactListPage extends BaseFunction {
    public ContactListPage(){
        super();
        PageFactory.initElements(driver, this);
    }

    //Defining the locators, final is used because we are not modifying these selectors
    public static By contactListTitle = By.xpath("//h1[text()='Contact List']");
    public static By logoutButton = By.xpath("//button[@id='logout']");

    //Action Methods
    public boolean userLandsOnContactListPage(){
        waitForElementToBeVisible(contactListTitle);
        return highlightedElement(contactListTitle).isDisplayed();
    }
    public void userClicksOnLogout(){
        highlightedElement(logoutButton).click();
    }
}
