package com.invoiceapp.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporters {
	
	protected static ExtentHtmlReporter htmlreport;
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	public void reportLocation(String device_Name) {
		String folder_TStamp = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String fileName = device_Name+"_"+timeStamp;
		htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Reports/" +folder_TStamp+ "/" + fileName + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		
		htmlreport.config().setDocumentTitle(device_Name);
		htmlreport.config().setReportName("REPORT For " +device_Name + " Device");
		
	}
}
