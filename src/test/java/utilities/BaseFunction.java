package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.*;


import java.time.Duration;
import java.util.Properties;

public class BaseFunction {

    protected static AppiumDriver<MobileElement> appiumDriver;
    public static String browser;
    private DriverFactory driverFactory;
    protected static WebDriver driver;
    Properties prop;

    protected void hardwait(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private By getBy(String locatorType, String locatorValue) {
        switch (Locators.valueOf(locatorType)) {
            case id:
                return By.id(locatorValue);
            case name:
                return By.name(locatorValue);
            case xpath:
                return By.xpath(locatorValue);
            case cssSelector:
                return By.cssSelector(locatorValue);
            case classname:
                return By.className(locatorValue);
            case linktext:
                return By.linkText(locatorValue);
            default:
                return By.id(locatorValue);
        }
    }

    protected By getLocator(By elementToken, String replacement) {
        if (!replacement.isEmpty()) {
            String loc = elementToken.toString().replaceAll("\'", "\\\"");
            String type = loc.split(":", 2)[0].split("\\.")[1];
            String variable = loc.split(":", 2)[1].replaceAll("\\$\\{.+?\\}", replacement);
            return getBy(type, variable);
        } else
            return elementToken;
    }


    protected WebElement element(By elementToken) {
        hardwait(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",
                driver.findElement(getLocator(elementToken, "")));
        hardwait(1);
        js.executeScript("arguments[0].setAttribute('style', '');", driver.findElement(getLocator(elementToken, "")));
        return driver.findElement(getLocator(elementToken, ""));
    }

    protected void scrollIntoWebElement(By elem)
    {
        WebElement element = element(elem);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    protected void scrollIntoWebElement(WebElement elem)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); ",elem);
    }

    public void initializeWebSession() {
        logMessage("*********************** Session Started ****************************");
        new PropFileHandler();
        String browserName = PropFileHandler.readProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_Driver(browserName);
        logMessage("Browser is: " + browserName.toUpperCase());
        driver.manage().window().maximize();
    }

    public static void closeWebSession() {
        if (driver != null) {
            driver.quit();
            logMessage("*********************** Web Session closed *****************************");
        }
    }

    public void launchWebApplication(String url) {
        initializeWebSession();
        driver.get(url);
    }

    public void waitForWebElementToBeVisible(By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //---------------------------------------- Mobile Setup ----------------------------------------------------------------------
    public void initializeMobileSession() {
        logMessage("*********************** Mobile Session Started ****************************");
        appiumDriver = new AppiumDriverEx().getAppiumDriver();
    }
    public static void closeMobileSession() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            logMessage("*********************** Mobile Session closed *****************************");
        }
    }
    public static void logMessage(String msg) {
        Reporter.log(msg, true);
    }
    public void waitForMobileElementToBeVisible(By locator)
    {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void mobileElementClick(By elementToken){
        waitForMobileElementToBeVisible(elementToken);
        appiumDriver.findElement(elementToken).click();
    }
    protected WebElement mobileElement(By elementToken){
        waitForMobileElementToBeVisible(elementToken);
        return appiumDriver.findElement(elementToken);
    }
    protected void mobileElementSendKeys(By elementToken, String text){
        waitForMobileElementToBeVisible(elementToken);
        appiumDriver.findElement(elementToken).sendKeys(text);
    }
    protected String mobileElementGetText(By elementToken)
    {
        waitForMobileElementToBeVisible(elementToken);
        return appiumDriver.findElement(elementToken).getText();
    }
    protected void mobileElementScrollIntoView(String visibleText){
        appiumDriver
                .findElement(MobileBy
                        .AndroidUIAutomator(
                                "new UiScrollable(new UiSelector().scrollable(true).index(0)).scrollIntoView(new UiSelector().text(\""+visibleText+"\"))"));
    }
}
