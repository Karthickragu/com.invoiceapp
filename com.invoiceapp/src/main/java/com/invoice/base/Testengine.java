package com.invoice.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import com.codoid.products.exception.FilloException;
import com.invoiceapp.utilities.Reporters;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Testengine {
	public static AppiumDriver<?> driver;
	public static Properties prop;
	public static Date date;
	public static Logger log;
	public static String testCase;
	public static int totalTCs;
	public static int passedTCs;
	public static int failedTCs;
	public static int skippedTCs;
	public static SoftAssert soft;
	public static String methodName;
	public static Set<String> contextNames;
	public static String device;
	public static String platform;
	public static String device_Name;
	protected static Properties properties;
	public static String propertyFilePath;
	public static String appiumServiceUrl;
	private static AppiumServiceBuilder appiumBuilder;
	public static AppiumDriverLocalService appiumServer;

	public static Reporters rep = new Reporters();

	long starttime = 0, endtime = 0;

	@BeforeSuite
	@Parameters({ "Mode", "deviceName" })
	public void Prerequisite(String mode, String deviceName, @Optional String value) throws MalformedURLException, FilloException {
		System.out.println(mode);

		System.out.println(
				"*******************************************\nReading Config File.... \n******************************************* \n");
		propertyFilePath = "config//Configuration.properties";

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
		System.out.println(
				"*******************************************\nInitiating Appium.... \n******************************************* \n");

		String Appium_Node_Path = "C:\\Program Files\\nodejs\\node.exe";
		String Appium_JS_Path = "C:\\Users\\sathiyar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

		if (mode.equalsIgnoreCase("Android-8.0")) {
			try {
				System.out.println("Selected Mode is " + mode);
				device_Name = mode;
				DesiredCapabilities cap = new DesiredCapabilities();
				// cap.setCapability(MobileCapabilityType.PLATFORM_NAME,
				// properties.getProperty("PLATFORM_NAME"));
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
				cap.setCapability("appActivity", "com.invoiceapp.InvoiceLaunchScreenAct");
				cap.setCapability("appPackage", "com.invoiceapp");
				cap.setCapability("autoLaunch", false);
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
				cap.setCapability("noReset", "false");
				appiumBuilder = new AppiumServiceBuilder();
				appiumBuilder.withAppiumJS(new File(Appium_JS_Path));
				appiumBuilder.usingDriverExecutable(new File(Appium_Node_Path));
				appiumBuilder.withIPAddress("127.0.0.2");
				appiumBuilder.usingAnyFreePort();
				appiumBuilder.withCapabilities(cap);
				appiumBuilder.withStartUpTimeOut(3, TimeUnit.MINUTES);
				appiumBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
				appiumBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
				appiumServer = AppiumDriverLocalService.buildService(appiumBuilder);
				appiumServer.start();
				driver = new AndroidDriver<AndroidElement>(appiumServer, cap);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (mode.equalsIgnoreCase("Android-8.1")) {
			try {
				System.out.println("Selected Mode is " + mode);
				device_Name = mode;
				DesiredCapabilities cap = new DesiredCapabilities();
				// cap.setCapability(MobileCapabilityType.PLATFORM_NAME,
				// properties.getProperty("PLATFORM_NAME"));
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
				cap.setCapability("appActivity", "com.invoiceapp.InvoiceLaunchScreenAct");
				cap.setCapability("appPackage", "com.invoiceapp");
				cap.setCapability("autoLaunch", false);
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
				cap.setCapability("noReset", "false");

				appiumBuilder = new AppiumServiceBuilder();
				appiumBuilder.withAppiumJS(new File(Appium_JS_Path));
				appiumBuilder.usingDriverExecutable(new File(Appium_Node_Path));
				appiumBuilder.withIPAddress("127.0.0.2");
				appiumBuilder.usingAnyFreePort();
				appiumBuilder.withCapabilities(cap);
				appiumBuilder.withStartUpTimeOut(3, TimeUnit.MINUTES);
				appiumBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
				appiumBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
				appiumServer = AppiumDriverLocalService.buildService(appiumBuilder);
				appiumServer.start();
				driver = new AndroidDriver<AndroidElement>(appiumServer, cap);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (mode.equalsIgnoreCase("Android-9") && deviceName.equalsIgnoreCase("emulator-5554")) {
			try {
				System.out.println("Selected Mode is " + mode);
				System.out.println("Selected Device Name is " + deviceName);
				device_Name = mode;
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
				cap.setCapability("avd", "Pixel_2_API_28");
				cap.setCapability("appActivity", "com.invoiceapp.InvoiceLaunchScreenAct");
				cap.setCapability("appPackage", "com.invoiceapp");
				cap.setCapability("autoLaunch", false);
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
				cap.setCapability("unlockType", "pattern");
				cap.setCapability("unlockKey", "14789");
				appiumBuilder = new AppiumServiceBuilder();
				appiumBuilder.withAppiumJS(new File(Appium_JS_Path));
				appiumBuilder.usingDriverExecutable(new File(Appium_Node_Path));
				appiumBuilder.withIPAddress("127.0.0.3");
				appiumBuilder.usingAnyFreePort();
				appiumBuilder.withCapabilities(cap);
				appiumBuilder.withStartUpTimeOut(3, TimeUnit.MINUTES);
				appiumBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
				appiumBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
				appiumServer = AppiumDriverLocalService.buildService(appiumBuilder);
				appiumServer.start();
				driver = new AndroidDriver<AndroidElement>(appiumServer, cap);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (mode.equalsIgnoreCase("Android-9") && deviceName.equalsIgnoreCase("5642c6b9")) {
			try {
				System.out.println("Selected Mode is " + mode);
				System.out.println("Selected Device Name is " + deviceName);
				device_Name = mode;
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "5642c6b9");
				cap.setCapability("appActivity", "com.invoiceapp.InvoiceLaunchScreenAct");
				cap.setCapability("appPackage", "com.invoiceapp");
				cap.setCapability("autoLaunch", false);
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
				cap.setCapability("unlockType", "pattern");
				cap.setCapability("unlockKey", "14789");
				appiumBuilder = new AppiumServiceBuilder();
				appiumBuilder.withAppiumJS(new File(Appium_JS_Path));
				appiumBuilder.usingDriverExecutable(new File(Appium_Node_Path));
				appiumBuilder.withIPAddress("127.0.0.3");
				appiumBuilder.usingAnyFreePort();
				appiumBuilder.withCapabilities(cap);
				appiumBuilder.withStartUpTimeOut(3, TimeUnit.MINUTES);
				appiumBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
				appiumBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
				appiumServer = AppiumDriverLocalService.buildService(appiumBuilder);
				appiumServer.start();
				driver = new AndroidDriver<AndroidElement>(appiumServer, cap);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@BeforeTest
	public static void Prerequsites() {
		System.out.println(
				"*******************************************\nInitiating Logger.... \n******************************************* \n");
		log = Logger.getLogger("Testengine");
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/Config/log4j.properties");
		rep.reportLocation(device_Name);
		totalTCs = 0;
		passedTCs = 0;
		failedTCs = 0;
		skippedTCs = 0;
		// driver.activateApp("com.invoiceapp");
	}

	@AfterSuite
	public void TerminateTest() throws Exception {

		appiumServer.stop();
		// Reporters.extent.flush();

		System.out.println(
				"******************************************* // End of the Test // *******************************************\n");
		System.out.println("Total number of Testcases Executed " + totalTCs);
		System.out.println("Total number of Testcases Passed " + passedTCs);
		System.out.println("Total number of Testcases Failed " + failedTCs);
		System.out.println("Total number of Testcases Skipped " + skippedTCs);
		System.out.println(
				"*************************************************************************************************************\n");

	}
}
