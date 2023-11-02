package pages.mobile;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseFunction;

public class FormsPage extends BaseFunction {
    //Creating a constructor for this class
    public FormsPage(){
        super();
        PageFactory.initElements(appiumDriver, this);
    }

    //Defining the locators
    public static By activeBtnSelByXPATH = MobileBy.xpath("//*[@text='Active']");

    //Action Methods
    public void clickActiveButton(){
        mobileElementScrollIntoView("Active");
        waitForMobileElementToBeVisible(activeBtnSelByXPATH);
        mobileElementClick(activeBtnSelByXPATH);
    }

}
