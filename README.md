# Appium-Mobile-Java
`This Appium project is based on Java along with Selenium`

# Prerequisites
1. Appium Desktop Client
2. Appium Inspector
3. Appium Doctor (optional)
4. Java 8
5. Maven
6. Android Studio
7. IntelliJ or Eclipse IDE
8. Emulated device or Physical device

# Appium Desktop Client Installation
1. Download the appium desktop client -> "Appium-Server-GUI-windows-1.22.3-4.exe"  
   Documentation -> http://appium.io/  
   Link -> https://github.com/appium/appium-desktop/releases
2. Download the exe file
3. Run the installer
4. Start appium through Appium GUI Server

# Appium Inspector Installation
1. Download the "Appium-Inspector-windows-2023.8.4.exe"  
   Link -> https://github.com/appium/appium-inspector/releases
2. Download the exe file
3. Run the installer
4. Start appium session through Appium Inspector app

# Appium Doctor Installation - (optional)
To check appium installation and dependencies
1.	`install appium-doctor`  
      Link -> https://github.com/appium/appium-doctor
2. `npm install appium-doctor -g`
3. `appium-doctor -h`  
   `appium-doctor --version`  
   `appium-doctor -android`

# Java 8 Installlation
Link -> https://www.oracle.com/in/java/technologies/javase/javase8-archive-downloads.html

# Maven Installation
Link -> https://maven.apache.org/download.cgi

# Android Studio Installation
Link -> https://developer.android.com/

# IntelliJ IDE Installation
Link -> https://www.jetbrains.com/idea/download/

# Eclipse IDE Installation
Link -> https://eclipseide.org/

# How To Connect emulated device On Windows
`Prerequisites:`
1. `Android Studio` installed on your system
2. `ANDROID_HOME`, `ANDROID_SDK_ROOT` is set in environment variables

`Things for emulated device setup: `
1. Make device ready, Start the avd session from android studio, Make the emulated device up.
2. Check adb devices for list of available devices in cmd  
   `adb devices`

# How To Connect physical device On Windows
`Prerequisites:`
1. Java installed on your system
2. `JAVA_HOME` is set in environment variables  
   `java --version`
3. An android mobile device
4. Connecting cable (For external device)
5. 200 MB ~ 1 GB free space

`Things for physical device setup: `
1. Make device ready, enable developer mode (Search for Build Number in settings, tap 5 times on Build Number to enable developer mode. Search for Developer Mode in settings, enable "USB debugging" ON)
2. Connect device to your computer system through USB cable
3. Check adb devices for list of available devices in cmd  
   `adb devices`
4. Get the appPackage, appActivity with the help of applications like APK info(available on Playstore)

# Framework setup
1. Create a Maven Project
2. Add Libraries/Dependencies in POM.xml file  
   `Selenium Java -> "3.141.59"`,  
   `Appium java client -> "7.5.1"`,  
   `guava -> "30.1.1-jre"`,  
   `commons-lang3 -> "3.12.0"`,  
   `Apache commons-io -> "2.8.0"`

3. Connect device  
   `adb devices`
4. Start appium server  
   `can be start via cmd line or via appium desktop client`
5. Add code to start automation on mobile device  
   `Set desired capabilities`  
   `deviceName`  
   `udid`  
   `platformName`  
   `platformVersion`  
   `appPackage`  
   `appActivity`
6. Appium Server URL(local Host) - http://127.0.0.1:4723/wd/hub

# Framework Description
This framework consist of packages such as `pages`,`testcases`,`utilities` and `resources`. And testng.xml file for running the testcases.
`pages` consist of web pages and mobile pages for locating elements and performing actions.  
`testCases` consist of mobile and web related tests.  
`utilities` consist of Java classes such as `AppiumDriverEx` for appium driver session, `DriverFactory` for web session, BaseFunction for defining basic framework functions, `Hooks` for Before and After test hooks, `ExtentReportManager` for spark report configuration with testNG.xml, `PropFileHandler` for reading the properties file.  
`resources` consist of config.properties file for testData.

# How to Run the testcases
There is a testng.xml file in the root folder.    
Open the testng.xml file   
Include the respected classes along with their respective methods to the test.  
Use the specific Application type parameter i.e. `mobile`/`web`  
Right-click on the xml file and select run with testng.  