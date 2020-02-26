package com.invoiceapp.Pages;

import org.openqa.selenium.support.PageFactory;

import com.invoiceapp.utilities.Reuseable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Registration {
	
	protected AppiumDriver<?> driver;
	public Reuseable reuse;
	
	public Registration(AppiumDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		reuse = new Reuseable(driver);
	}
	
	@AndroidFindBy(id = "act_lf_EdtRegistrationEmail")
	static MobileElement Registration_EMail;
	
	@AndroidFindBy(id = "act_lf_EdtRegistrationPassword")
	MobileElement Registration_Password;
	
	@AndroidFindBy(id = "act_lf_EdtRegistrationConfirmPassword")
	MobileElement Registration_ConfPassword;
	
	
	@AndroidFindBy(id = "act_lf_BtnRegistrationSubmit")
	MobileElement Sign_In;
	
	@AndroidFindBy(id = "act_lf_TvForgotPassword")
	MobileElement ForgotPassword;
	
	@AndroidFindBy(id = "act_lf_BtnSignIn")
	MobileElement ExistingAccount;
	
	@AndroidFindBy(id = "act_lf_BtnLoginCancel")
	MobileElement Cancel;
	
	
	public void registerNewUser() {
		reuse.waitforload(Registration_EMail, 5);
		Registration_EMail.sendKeys("Ragav");
		Registration_Password.sendKeys("Password");
		Registration_ConfPassword.sendKeys("Password");
		Sign_In.click();
	}

	
}
