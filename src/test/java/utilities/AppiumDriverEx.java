package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverEx {
    public static AppiumDriver<MobileElement> getAppiumDriver(){

        //Driver instance
        AppiumDriver<MobileElement> appiumDriver = null;

        try{
            //Set DesiredCapabilities to sent to Appium server
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.PLATFORM_NAME,"Android");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.AUTOMATION_NAME,"uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.UDID,"emulator-5554");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_PACKAGE,"com.wdiodemoapp");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
            desiredCapabilities.setCapability(MobileCapabilityTypeEx.NEW_COMMAND_TIMEOUT,120);

//            Below capability is used to install the apk file to the connected device for the first time
//            desiredCapabilities.setCapability("app", "C:\\Users\\harsh\\Downloads\\Android-NativeDemoApp-0.4.0.apk");

            //Setup the Appium server url to connect to
            URL appiumServer = new URL("http://localhost:4725/wd/hub");

            appiumDriver = new AppiumDriver<>(appiumServer, desiredCapabilities);
            appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }catch(Exception e){
            e.printStackTrace();

        }
        return appiumDriver;
    }
}
