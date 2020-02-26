package com.invoiceapp.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.invoice.base.Testengine;
import com.invoiceapp.utilities.Globalconstants;
import com.invoiceapp.utilities.Reuseable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Splashscreen  {
	
	protected AppiumDriver<?> driver;
	private static Logger log;
	public Permissions permission;
	public Reuseable reuse;
	
	public Splashscreen(AppiumDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log = Testengine.log;
		permission = new Permissions(driver);
		reuse = new Reuseable(driver);
	}
	
	@AndroidFindBy(id = "com.invoiceapp:id/act_ils_IvAppIcon")
	MobileElement splash_image_icon;
	
	@AndroidFindBy(id = "com.invoiceapp:id/appNameTV")
	MobileElement splash_image_text;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
	MobileElement allow_media_access_Deny;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	MobileElement allow_media_access_Allow;
			
	public void splash_verify(ExtentTest info) throws Exception {
		reuse.waitforload(splash_image_icon, 10);
		Boolean result = splash_image_icon.isDisplayed();
		String value = splash_image_text.getAttribute("text");
		log.info("Verifying the Splash screen");
		info.log(Status.INFO, "Verifying the Splash screen");
		log.info("Verifying for the Splash image and the result is  " +result);
		log.info("Verifying for the Splash text "+value);
		info.log(Status.INFO, "Verifying for the Splash text "+value);
		if (result == true) {
			info.log(Status.PASS, "splash image icon is displaying in the Splash Screen");
			assert result;
		} else {
			info.log(Status.FAIL, "splash image icon is NOT displaying in the Splash Screen");
			assert false;
		}
		if (value.equals(Globalconstants.splashscreen_logotxt)) {
			System.out.println("Actual   = : " +value);
			System.out.println("Expected = : " +Globalconstants.splashscreen_logotxt);
			info.log(Status.PASS, "splash image Text is displaying in the Splash Screen as expected");
			info.log(Status.INFO, "EXPECTED: "+Globalconstants.splashscreen_logotxt);
			info.log(Status.INFO, "Actual  : "+value);
			assert true;
		} else {
			System.out.println("Actual   = : " +value);
			System.out.println("Expected = : " +Globalconstants.splashscreen_logotxt);
			info.log(Status.FAIL, "splash image Text is NOT displaying as expected in the Splash Screen");
			info.log(Status.INFO, "EXPECTED: "+Globalconstants.splashscreen_logotxt);
			info.log(Status.INFO, "Actual  : "+value);	
		}
	}
	
	public void allow_media_access_Allow(ExtentTest info) {
		reuse.waitforload(allow_media_access_Allow, 15);
		allow_media_access_Allow.click();
		info.log(Status.PASS, "Allowing Media access");
	}
	
	public void allow_media_access_Deny(ExtentTest info) {
		reuse.waitforload(allow_media_access_Deny, 15);
		allow_media_access_Deny.click();
		info.log(Status.PASS, "Denying Media access");
		permission.permissions_verification();
	}
	
}
