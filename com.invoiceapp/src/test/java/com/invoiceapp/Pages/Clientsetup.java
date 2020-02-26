package com.invoiceapp.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.codoid.products.exception.FilloException;
import com.invoiceapp.utilities.Dataprovider;
import com.invoiceapp.utilities.Globalconstants;
import com.invoiceapp.utilities.Reuseable;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Clientsetup {	
	
	protected AppiumDriver<?> driver;
	public Reuseable reuse;
	
	public Clientsetup(AppiumDriver<?> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		reuse = new Reuseable(driver);
	}
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[1]/android.widget.TextView[1]")	
	MobileElement client_setup_static_header_text;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[1]/android.widget.TextView[2]")
	MobileElement client_setup_static_help_text;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_ob_cur_curencyText")
	MobileElement client_setup_select_Country_text;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_ob_cur_curencyTextShow")
	MobileElement client_setup_select_Country_button;
	
	@AndroidFindBy(id = "com.invoiceapp:id/dlg_cf_TvTitle")
	MobileElement client_setup_popup_countrylist;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[3]/android.widget.TextView[1]")
	MobileElement client_setup_currency_format;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obcur_Tv_LabelSubHeading")
	MobileElement client_setup_currency_format_helptext;
	
	@AndroidFindBy(id = "com.invoiceapp:id/rdo_cur_symbol")
	MobileElement client_setup_select_currency_format_assymbol;
	
	@AndroidFindBy(id = "com.invoiceapp:id/rdo_cur_text")
	MobileElement client_setup_select_currency_format_astext;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obu_BtnSkip")
	public MobileElement client_setup_add_Skip;
	
	@AndroidFindBy(id = "com.invoiceapp:id/frag_obu_BtnNext")
	MobileElement client_setup_add_Next;
	
	@AndroidFindBy(id = "com.invoiceapp:id/dlg_nc_TvTitle")
	MobileElement client_setup_popup_title;
	
	@AndroidFindBy(id = "com.invoiceapp:id/dlg_nc_TvMsg")
	MobileElement client_setup_popup_body;
	
	@AndroidFindBy(id = "com.invoiceapp:id/dlg_nc_BtnYes")
	MobileElement client_setup_popup_yes_button;
	
	@AndroidFindBy(id = "com.invoiceapp:id/dlg_nc_BtnNo")
	MobileElement client_setup_popup_No_button;
	
	public static String value;
	public static Boolean result;
	
	public void client_setup_verify_UI(ExtentTest info) {
		reuse.waitforload(client_setup_static_header_text, 10);
		value = client_setup_static_header_text.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.client_setup_static_header_text);
		reuse.print_output(Globalconstants.client_setup_static_header_text, value);
		value = client_setup_static_help_text.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.client_setup_static_help_text);
		reuse.print_output(Globalconstants.client_setup_static_help_text, value);
		value = client_setup_select_Country_text.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.client_setup_select_Country_text);
		reuse.print_output(Globalconstants.client_setup_select_Country_text, value);
		value = client_setup_currency_format.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.client_setup_currency_format);
		reuse.print_output(Globalconstants.client_setup_currency_format, value);
		value = client_setup_currency_format_helptext.getAttribute("text");
		Assert.assertEquals(value, Globalconstants.client_setup_currency_format_helptext);
		reuse.print_output(Globalconstants.client_setup_currency_format_helptext, value);
		result = client_setup_select_Country_button.isDisplayed();
		Assert.assertTrue(result);
		result = client_setup_select_currency_format_assymbol.isDisplayed();
		Assert.assertTrue(result);
		result = client_setup_select_currency_format_astext.isDisplayed();
		Assert.assertTrue(result);
		result = client_setup_add_Skip.isDisplayed();
		Assert.assertTrue(result);
		result = client_setup_add_Next.isDisplayed();
		Assert.assertTrue(result);
	}
	
	// Add a Data Provider
	public void client_setup_selectCountry(ExtentTest info) throws InterruptedException, FilloException {
		reuse.waitforload(client_setup_select_Country_button, 5);
		client_setup_select_Country_button.click();
		info.log(Status.PASS, "Clicked the Country Button");
		reuse.waitforload(client_setup_popup_countrylist, 5);
		result = reuse.scroll_click_ByText(Dataprovider.getData("Location", "SNo", "1", "Country").toString());
		assert(result);
		if (result == true) {
			info.log(Status.PASS, "Selected the country " +Dataprovider.getData("Location", "SNo", "1", "Country").toString());
		} else {
			info.log(Status.PASS, "Unable to find/select the country " +Dataprovider.getData("Location", "SNo", "1", "Country").toString());
		}
		Thread.sleep(2000);
		value = client_setup_select_Country_button.getAttribute("text");
		Assert.assertEquals(Dataprovider.getData("Location", "SNo", "1", "Country").toString(), value);
		System.out.println("Country button text changed to "+value);
	}
	
	public void client_setup_selectCurrency(String type) throws InterruptedException {
		if(type == "Symbol") {
			client_setup_select_currency_format_assymbol.click();
			result = client_setup_select_currency_format_assymbol.isSelected();
			System.out.println(result);
		}
		else if(type == "Text") {
			client_setup_select_currency_format_astext.click();
			result = client_setup_select_currency_format_astext.isSelected();
			System.out.println(result);
		}
		else {
			System.out.println("Please select a valid type either \"Symbol\" or \"Text\" ");
		}
	}
	
	public void next_verify() throws InterruptedException {
		reuse.waitforload(client_setup_add_Next, 10);
		client_setup_add_Next.click();
		// Add verification steps                                                                                                                          
		}
	
	
	public void verify_GST_Popup() {
		try {
			reuse.waitforload(client_setup_popup_title, 5);
			value = client_setup_popup_title.getAttribute("text");
			if (value.equals(Globalconstants.client_setup_popup_title_text)) {
				client_setup_popup_yes_button.click();
				System.out.println("Selected \"Yes\" for GST popup");
			}
		}catch(Exception e) {
			System.out.println("GST Popup is not prompted... ");
		}
	}
}






















