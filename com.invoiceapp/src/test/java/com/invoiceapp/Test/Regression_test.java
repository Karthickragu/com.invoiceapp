package com.invoiceapp.Test;

import java.lang.reflect.Method;
import java.util.Base64;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.invoice.base.Testengine;
import com.invoiceapp.Pages.Clientsetup;
import com.invoiceapp.Pages.Company_setup;
import com.invoiceapp.Pages.Estimation;
import com.invoiceapp.Pages.Hamburger;
import com.invoiceapp.Pages.Homepage;
import com.invoiceapp.Pages.NewClient;
import com.invoiceapp.Pages.Permissions;
import com.invoiceapp.Pages.Registration;
import com.invoiceapp.Pages.Setup_user_profile;
import com.invoiceapp.Pages.Splashscreen;
import com.invoiceapp.utilities.Reporters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;

@Listeners(com.invoiceapp.Test.Regression_test.class)
public class Regression_test extends Testengine implements ITestListener {
	
	public static Splashscreen splash;
	public static Company_setup comp_setup;
	public static Clientsetup client;
	public static Hamburger hamburger;
	public static Registration register;
	public static Permissions permission;
	public static Estimation estimation;
	public static Setup_user_profile profilesetup;
	public static Homepage home;
	public static NewClient newclient;
	public static ExtentTest test;
	
//	Regression_test() {
//		
//	}
	
	@BeforeClass
	public void initPages() {
		splash = new Splashscreen(driver);
		comp_setup = new Company_setup(driver);
		client = new Clientsetup(driver);	
		hamburger = new Hamburger(driver);
		register = new Registration(driver);
		permission = new Permissions(driver);
		estimation = new Estimation(driver);
		profilesetup = new Setup_user_profile(driver);
		home = new Homepage(driver);
		newclient = new NewClient(driver);
		//Reporters rep1 = new Reporters();
		test = Reporters.test;
	}

	
	
	
	@BeforeMethod
	@Parameters({"Device"})
	public void startup(Method result, String device) {
		methodName = result.getName();
		test = Reporters.extent.createTest(result.getName());
		test.assignCategory(device);
		date = new Date();
		log.info("App Launched at " + date);
		System.out.println("-------------------------------------------  " + methodName + " Test started at " + date
				+ " -------------------------------------------\n ");
	}


	@AfterMethod
	public void Exittest(Method result) {
//		logger1.log(Status.INFO, "Test Case " + result.getName() + "Ended at " + date);
		// date = new Date();
		//driver.closeApp();
		Reporters.extent.flush();
		// log.info("App forced to closed at " + date);
//		extent.flush();
		System.out.println("------------------------------------------- Test ended at " + date
				+ " -------------------------------------------\n");
		
	}
	
	
	public static void launchApp() {
		try {
		driver.launchApp();
		}catch (Exception e) {
			System.out.println("Driver is not initiated properly. Hence test is TERMINATED!!!");
		}
	}
	
	
	@Test
    public void verifySimilarityCalculation() {
        byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
        SimilarityMatchingResult result = driver
                .getImagesSimilarity(screenshot, screenshot, new SimilarityMatchingOptions()
                        .withEnabledVisualization());
        System.out.println(result.getVisualization().length);
        System.out.println(result.getScore());
    }
	
	
	
/*
	@Test(priority = 1)
	public static void TC001() throws Exception {
		log.info("TC001 - Executing");
		driver.launchApp();
		splash.splash_verify(test);
		splash.allow_media_access_Allow(test);
	}
*/
	
	@Test(priority = 2)
	public static void TC002() throws Exception {
		log.info("TC002 - Executing");		
		launchApp();
		splash.allow_media_access_Deny(test);
		driver.closeApp();
	}

	@Test(priority = 3)
	public static void TC003() throws Exception {
		log.info("TC003 - Executing");
		launchApp();
		splash.allow_media_access_Allow(test);
		comp_setup.addCompany_screen_Verification();
		comp_setup.addCompany();
		driver.closeApp();
	}

	@Test(priority = 4)
	public static void TC004() throws Exception {
		System.out.println("TC004 - Executing");
		launchApp();
		splash.allow_media_access_Allow(test);
		comp_setup.addCompany();
		comp_setup.next_verify();
		client.verify_GST_Popup();
		client.client_setup_verify_UI(test);
		client.client_setup_selectCountry(test);
		client.client_setup_selectCurrency("Text");
		driver.closeApp();
	}
	
	@Test(priority = 5)
	public static void TC005() throws Exception {
		System.out.println("TC005 - Executing");
		launchApp();
		splash.allow_media_access_Allow(test);
		client.client_setup_add_Skip.click();
		client.verify_GST_Popup();
		hamburger.hamburgerMenu();
		hamburger.createNewAccount();
		driver.closeApp();
	}


	@Test(priority = 6)
	public static void TC006() throws Exception {
		System.out.println("TC006 - Executing");
		launchApp();
		splash.allow_media_access_Allow(test);
		client.client_setup_add_Skip.click();
		client.verify_GST_Popup();
		hamburger.hamburgerMenu();
		estimation.addnewEstimation();
		profilesetup.addingUserProfile();	
	}
	
	@Test(priority = 7)
	public static void TC007() throws Exception {
		System.out.println("TC007 - Executing");
		home.verifyHomepage();
		newclient.addNewClient();
		newclient.VerifyNewClient();
		newclient.selectDate();
	}
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		totalTCs = totalTCs + 1;

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		passedTCs = passedTCs + 1;

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		failedTCs = failedTCs + 1;
		System.out.println("Test case failed...");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		skippedTCs = skippedTCs + 1;
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
