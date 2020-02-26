package com.invoiceapp.Pages;

import org.openqa.selenium.support.PageFactory;

import com.invoiceapp.utilities.Reuseable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Hamburger {
	
	protected AppiumDriver<?> driver;
	public Reuseable reuse;
	
	public Hamburger(AppiumDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		reuse = new Reuseable(driver);
	}

	
	@AndroidFindBy(accessibility = "Invoice Manager")
	MobileElement Hamburger;
	
	@AndroidFindBy(id = "com.invoiceapp:id/mf_tv_payment_no_item")
	MobileElement Cloud_Account;
	
	@AndroidFindBy(id = "com.invoiceapp:id/mf_tv_sum_of_pay_title")
	MobileElement Dont_have_Account;
	
	public void hamburgerMenu() {
		reuse.waitforload(Hamburger, 10);
		Hamburger.click();
	}

	public void createNewAccount() {
		reuse.waitforload(Cloud_Account, 10);
		Cloud_Account.click();
		reuse.waitforload(Dont_have_Account, 10);
		Dont_have_Account.click();
		reuse.waitforload(Registration.Registration_EMail, 10);
	}
	
	
	
}
