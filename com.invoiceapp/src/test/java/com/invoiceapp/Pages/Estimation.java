package com.invoiceapp.Pages;

import org.openqa.selenium.support.PageFactory;
import com.invoiceapp.utilities.Reuseable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Estimation {
	
	protected AppiumDriver<?> driver;
	public Reuseable reuse;
	public Hamburger hamburger;
	
	public Estimation(AppiumDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		reuse = new Reuseable(driver);
		hamburger = new Hamburger(driver);
	}
	
	@AndroidFindBy(xpath = "//android.widget.ExpandableListView/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.LinearLayout")
	static MobileElement estimateMenu;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Add New']")
	MobileElement estimate_AddNew;
	
	@AndroidFindBy(id = "act_lf_EdtRegistrationConfirmPassword")
	MobileElement Registration_ConfPassword;
	
	
	public void addnewEstimation() {		
		reuse.waitforload(estimateMenu, 5);
		estimateMenu.click();
		reuse.waitforload(estimate_AddNew, 5);
		estimate_AddNew.click();	
	}
}
