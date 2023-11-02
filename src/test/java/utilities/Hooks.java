package utilities;

import org.testng.annotations.*;

public class Hooks extends BaseFunction{
    public static String appType;
    @BeforeTest
    @Parameters("applicationType")
    public void before(String applicationType){
        if(applicationType.equals("mobile")){
            appType = applicationType;
            System.out.println("App type is: "+applicationType);
            initializeMobileSession();
        } else {
            appType = applicationType;
            launchWebApplication(PropFileHandler.readProperty("appUrl"));
        }
    }

    @AfterTest
    public void setUpAfter(){
        if(appType.equals("mobile")){
            System.out.println("Close app type: "+appType);
            closeMobileSession();
        } else {
            closeWebSession();
        }
    }

}
