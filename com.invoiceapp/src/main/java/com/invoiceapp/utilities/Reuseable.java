package com.invoiceapp.utilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Reuseable {
	
	protected static AppiumDriver<?> driver;
	
	public Reuseable(AppiumDriver<?> driver) {
		Reuseable.driver = driver;
	}
	
	public void waitforload(MobileElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void print_output(String expected, String actual) {
		System.out.println("Actual   = : " +actual);
		System.out.println("Expected = : " +expected);
	}
	
	public Boolean scroll_click_ByText(String find_text) {
		
	try {
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ find_text + "\").instance(0))")).click();
		System.out.println(find_text+" Found and selected");
		return true; 
	} catch (Exception e) {
		System.out.println("Unable to find the text" +find_text);
		return false;
	}
	}
}
