package com.invoiceapp.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.invoiceapp.utilities.Globalconstants;
import com.invoiceapp.utilities.Reuseable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Permissions {
	
	protected AppiumDriver<?> driver;
	public Reuseable reuse;
	
	public Permissions(AppiumDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		reuse = new Reuseable(driver);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[1]")
	MobileElement header;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
	MobileElement header_invoice_text;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[1]")
	MobileElement header_invoice_image;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")
	MobileElement static_text;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[2]")
	MobileElement static_Storage_header;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[3]")
	MobileElement static_Storage_text;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[4]")
	MobileElement request_permission;
	
	@AndroidFindBy(id = "com.invoiceapp:id/act_per_BtnGotoPermissionSettings")
	MobileElement Go_to_permission_button;
	
	public static String value;

	public void permissions_verification() {
		reuse.waitforload(header, 10);
		value = header.getAttribute("text");
		System.out.println("Actual   = : " + value);
		System.out.println("Expected = : " + Globalconstants.Permissions_header_text);
		if (value.equals(Globalconstants.Permissions_header_text)) {
			System.out.println("Actual   = : " + value);
			System.out.println("Expected = : " + Globalconstants.Permissions_header_text);
		} else {
			System.out.println("Value for Header is not as Expected, Hence failed");
			Assert.assertFalse(true);
		}
		value = header_invoice_text.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.header_invoice_text_string);
		System.out.println("Actual   = : " + value);
		System.out.println("Expected = : " + Globalconstants.header_invoice_text_string);
		value = static_text.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.static_text);
		System.out.println("Actual   = : " + value);
		System.out.println("Expected = : " + Globalconstants.static_text);
		value = static_Storage_header.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.static_Storage_header);
		System.out.println("Actual   = : " + value);
		System.out.println("Expected = : " + Globalconstants.static_Storage_header);
		value = static_Storage_text.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.static_Storage_text);
		System.out.println("Actual   = : " + value);
		System.out.println("Expected = : " + Globalconstants.static_Storage_text);
		value = request_permission.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.request_permission);
		System.out.println("Actual   = : " + value);
		System.out.println("Expected = : " + Globalconstants.request_permission);
		value = Go_to_permission_button.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.Go_to_permission_button_text);
		System.out.println("Actual   = : " + value);
		System.out.println("Expected = : " + Globalconstants.Go_to_permission_button_text);
	}
}
