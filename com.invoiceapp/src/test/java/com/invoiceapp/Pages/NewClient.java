package com.invoiceapp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.invoiceapp.utilities.Reuseable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewClient {

	
	protected AppiumDriver<?> driver;
	public static Reuseable reuse;
	
	
	public NewClient(AppiumDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		reuse = new Reuseable(driver);
	}
	
	@AndroidFindBy(id = "Client")
	MobileElement newClient_Header;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id = 'com.invoiceapp:id/ca_FABCreateClient']")
	MobileElement newClient_addNewClient;
	
	@AndroidFindBy(id = "am_edt_org_name")
	MobileElement newCliententry_OrgName;
	
	@AndroidFindBy(id = "am_edt_email")
	MobileElement newCliententry_EMail;
	
	@AndroidFindBy(id = "am_edt_address1")
	MobileElement newCliententry_Address;
	
	@AndroidFindBy(id = "am_edt_contact_no")
	MobileElement newCliententry_Contact;
	
	@AndroidFindBy(id = "am_btn_save")
	MobileElement newCliententry_Save;
	
	@AndroidFindBy(id = "adp_cla_tv_OrgName")
	MobileElement client_AddedRecord;
	
	@AndroidFindBy(id = "ipact_btn_set_todate")
	MobileElement client_setDate;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[1][@resource-id = 'android:id/date_picker_header_year']")
	MobileElement setDate_calender_year;
	
	@AndroidFindBy(xpath = "//android.view.View[@text = '5']")
	MobileElement setDate_calender_MonthandDate;
	
	@AndroidFindBy(accessibility = "Previous month")
	MobileElement setDate_calender_previousMonth;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'OK']")
	MobileElement setDate_calender_OK;
	
	
	public void addNewClient() {
		reuse.waitforload(newClient_addNewClient, 5);
		newClient_addNewClient.click();
		String orgName = "OrgNameRagav";
		reuse.waitforload(newCliententry_OrgName, 5);
		newCliententry_OrgName.sendKeys(orgName);
		newCliententry_EMail.sendKeys("wfwds@gmail.com");
		newCliententry_Address.sendKeys("234 sdfsdf st");
		newCliententry_Contact.sendKeys("2345234423");
		newCliententry_Save.click();
		reuse.waitforload(newClient_addNewClient, 5);
		reuse.waitforload(client_AddedRecord, 5);
		if(client_AddedRecord.getAttribute("text").equals(orgName)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
	}
	
	public void VerifyNewClient() {
		
		reuse.waitforload(client_AddedRecord, 5);
		client_AddedRecord.click();
		reuse.waitforload(client_setDate, 5);
		client_setDate.click();
	}
	
	// Need to set date as 2015-12-16
	
	public void selectDate() throws InterruptedException {
		reuse.waitforload(setDate_calender_year, 15);
		reuse.waitforload(setDate_calender_MonthandDate, 5);
		int selected_Date = 16;
		String selected_month = "Jun";
		for (int i=1; i<=12; i++) {
			String timestamp = setDate_calender_MonthandDate.getAttribute("content-desc");
			if (timestamp.contains(selected_month)) {
				String xpathforSelection = "//android.view.View[@text = '"+selected_Date+"']";
				driver.findElement(By.xpath(xpathforSelection)).click();
			} else {
				setDate_calender_previousMonth.click();
			}
		}
		setDate_calender_year.click();
		reuse.scroll_click_ByText("2013");
		setDate_calender_OK.click();
		
	}
	
	
	
}
