package com.invoiceapp.Pages;

import org.openqa.selenium.support.PageFactory;

import com.invoiceapp.utilities.Reuseable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Homepage {
	
	protected AppiumDriver<?> driver;
	public static Reuseable reuse;
	
	
	public Homepage(AppiumDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		reuse = new Reuseable(driver);
	}
	
	@AndroidFindBy(id = "toolbar_sync_TvTitle")
	public static MobileElement home_Title;
	
	@AndroidFindBy(id = "mf_btn_create_inv")
	MobileElement home_NewInvoice_Button;
	
	@AndroidFindBy(id = "mf_btn_create_estimate")
	MobileElement home_NewEstimate_Button;

	@AndroidFindBy(id = "mf_btn_create_payment")
	MobileElement home_NewPayment_Button;
	
	public void verifyHomepage() {
		reuse.waitforload(home_Title, 10);
		reuse.waitforload(home_NewPayment_Button, 10);
		home_NewPayment_Button.click();
		
	}
}
