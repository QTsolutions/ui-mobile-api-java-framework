package utilities;

import org.testng.annotations.*;

public class Hooks extends BaseFunction{
    public static String appType;
    @BeforeTest
    @Parameters("applicationType")
    public void before(String applicationType){
        appType = applicationType;
        launchSession(appType);
//        if(applicationType.equals("mobile")){
//            appType = applicationType;
//            System.out.println("App type is: "+applicationType);
//            initializeMobileSession();
//        } else if(applicationType.equals("web")){
//            appType = applicationType;
//            launchWebApplication(applicationType, PropFileHandler.readProperty("appUrl"));
//        }else {
//            appType = applicationType;
//            System.out.println("BeforeTest App type is: "+applicationType);
//        }
    }

    @AfterTest
    public void setUpAfter(){
//        if(appType.equals("mobile")){
//            System.out.println("Close app type: "+appType);
//            closeMobileSession();
//        } else if(appType.equals("web")){
//            closeWebSession();
//        }else {
//            System.out.println("AfterTest App type is: "+appType);
//        }

        if(appType.equals("api")){
            System.out.println("AfterTest App type is: "+appType);
        } else {
            closeSession();
        }
    }

}
