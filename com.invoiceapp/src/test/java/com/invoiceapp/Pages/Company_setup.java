package com.invoiceapp.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.codoid.products.exception.FilloException;
import com.invoiceapp.utilities.Dataprovider;
import com.invoiceapp.utilities.Globalconstants;
import com.invoiceapp.utilities.Reuseable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Company_setup {
	
	protected AppiumDriver<?> driver;
	public Reuseable reuse;
	
	public Company_setup(AppiumDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		reuse = new Reuseable(driver);
	}
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obup_TvLabel1")
	MobileElement setup_static_text;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[2]")
	MobileElement setup_static_help_text;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obup_IvQuestion")
	MobileElement setup_static_help_icon;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView")
	MobileElement setup_add_logo_text;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obup_IvAddCompLogo")
	MobileElement setup_add_logo_icon;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.TextView")
	MobileElement setup_add_signature_text;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obup_IvAddSignature")
	MobileElement setup_add_signature_icon;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obup_EdtCompName")
	MobileElement setup_add_companyName_textfield;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obup_EdtPersonName")
	MobileElement setup_add_personName_textfield;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obup_EdtAdd1")
	MobileElement setup_add_Address_textfield;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obup_EdtEmail")
	MobileElement setup_add_Email_textfield;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obup_Edt_ContactNo")
	MobileElement setup_add_Contact_textfield;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obu_BtnSkip")
	MobileElement setup_add_Skip;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obu_BtnNext")
	MobileElement setup_add_Next;
	
	
	public static String value;
	public static Boolean result;
	
	public void addCompany_screen_Verification() {
		reuse.waitforload(setup_static_text, 10);
		
		value = setup_static_text.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.addcustomer_static_text);
		reuse.print_output(Globalconstants.addcustomer_static_text, value);
		
		value = setup_static_help_text.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.addcustomer_static_help_text);
		reuse.print_output(Globalconstants.addcustomer_static_help_text, value);
		
		value = setup_add_logo_text.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.addcustomer_add_logo_text);
		reuse.print_output(Globalconstants.addcustomer_add_logo_text, value);
		
		value = setup_add_signature_text.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.addcustomer_add_signature_text);
		reuse.print_output(Globalconstants.addcustomer_add_signature_text, value);
		
		value = setup_add_companyName_textfield.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.addcustomer_add_companyName_textfield);
		reuse.print_output(Globalconstants.addcustomer_add_companyName_textfield, value);
		
		value = setup_add_personName_textfield.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.addcustomer_add_personName_textfield);
		reuse.print_output(Globalconstants.addcustomer_add_personName_textfield, value);
		
		value = setup_add_Address_textfield.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.addcustomer_add_Address_textfield);
		reuse.print_output(Globalconstants.addcustomer_add_Address_textfield, value);
		
		value = setup_add_Email_textfield.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.addcustomer_add_Email_textfield);
		reuse.print_output(Globalconstants.addcustomer_add_Email_textfield, value);
		
		value = setup_add_Contact_textfield.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.addcustomer_add_Contact_textfield);
		reuse.print_output(Globalconstants.addcustomer_add_Contact_textfield, value);
		
		result = setup_static_help_icon.isDisplayed();
		Assert.assertTrue(result);
		result = setup_add_logo_icon.isDisplayed();
		Assert.assertTrue(result);
		result = setup_add_signature_icon.isDisplayed();
		Assert.assertTrue(result);
	}
	
	
	// Add a Data Provider
	public void addCompany() throws InterruptedException, FilloException {
		reuse.waitforload(setup_add_companyName_textfield, 10);
		setup_add_companyName_textfield.sendKeys(Dataprovider.getData("Data", "SNo", "1", "companyName").toString());
		setup_add_personName_textfield.sendKeys(Dataprovider.getData("Data", "SNo", "1", "Person_Name").toString());
		setup_add_Address_textfield.sendKeys(Dataprovider.getData("Data", "SNo", "1", "Address").toString()); 
		setup_add_Email_textfield.sendKeys(Dataprovider.getData("Data", "SNo", "1", "Email").toString());
		setup_add_Contact_textfield.sendKeys(Dataprovider.getData("Data", "SNo", "1", "Contact").toString());
	}
	
	public void next_verify() throws InterruptedException {
		reuse.waitforload(setup_add_Next, 10);
		setup_add_Next.click();
//		Reuseable.waitforload(Clientsetup.client_setup_popup_title, 10);
//		value = Clientsetup.client_setup_popup_title).getAttribute("text");
//		Assert.assertEquals(value, Globalconstants.client_setup_popup_title_text);
		}
		
	}

