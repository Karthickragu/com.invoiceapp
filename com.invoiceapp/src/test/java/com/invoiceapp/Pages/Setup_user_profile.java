package com.invoiceapp.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.invoiceapp.utilities.Reuseable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class Setup_user_profile {
	
	protected AppiumDriver<?> driver;
	public Reuseable reuse;
	public TouchAction action;
	
	public Setup_user_profile(AppiumDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		reuse = new Reuseable(driver);
	}
	
	@AndroidFindBy(id = "act_up_Edt_CompName")
	MobileElement compName;
	
	@AndroidFindBy(id = "act_up_Edt_PersonName")
	MobileElement personName;
	
	@AndroidFindBy(id = "act_up_Edt_Add1")
	MobileElement address;
	
	
	@AndroidFindBy(id = "act_up_Edt_BusinessId")
	MobileElement value_GSTIN;
	
	@AndroidFindBy(id = "act_up_Edt_Email")
	MobileElement eMail;
	
	@AndroidFindBy(id = "act_up_Edt_ContactNo")
	MobileElement contactPhone;
	
	@AndroidFindBy(id = "act_up_EdtWebsiteLink")
	MobileElement webLink;
	
	@AndroidFindBy(id = "imgSign")
	MobileElement signatureBox;
	
	@AndroidFindBy(id = "act_up_FABAddSignature")
	MobileElement signature_Add;
	
	@AndroidFindBy(id = "dlg_sp_BtnManualSignature")
	MobileElement popup_ManualSignature;
	
	@AndroidFindBy(id = "sign_save_button")
	MobileElement save_ManualSignature;
	
	@AndroidFindBy(id = "act_up_btn_save")
	MobileElement save_Record_DoneButon;
	
	
	
	public void addingUserProfile() throws InterruptedException {
		reuse.waitforload(compName, 5);
		compName.sendKeys("Home");
		personName.sendKeys("Karthick");
		address.sendKeys("Near Cambridge University");
		value_GSTIN.sendKeys("1234455667788990");
		eMail.sendKeys("karthick_gstin@reddinfmail.com");
		contactPhone.sendKeys("2167182334");
		reuse.scroll_click_ByText("Signature");
		webLink.sendKeys("www.google.com");
		Assert.assertTrue(signatureBox.isDisplayed());
		signature_Add.click();
		reuse.waitforload(popup_ManualSignature, 5);
		popup_ManualSignature.click();
		Thread.sleep(2000);
		try {
			action = new TouchAction(driver);
			action.press(PointOption.point(87,247)).moveTo(PointOption.point(172,130)).moveTo(PointOption.point(201,357)).moveTo(PointOption.point(563,263)).moveTo(PointOption.point(915,247)).release().perform();
			save_ManualSignature.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		save_Record_DoneButon.click();
		reuse.waitforload(Homepage.home_Title, 10);
	}

}
