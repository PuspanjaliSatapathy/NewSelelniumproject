package common;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import MyConfig.TestRunnerHooks;

import java.io.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extentReportUtil {
	WebDriver driver = TestRunnerHooks.driverMap.get(Thread.currentThread().getId());
	public static ExtentReports extent;
	public static ExtentTest testName;
	public static ExtentTest scenarioName;
	public static ExtentTest stepName;
//	static Map<Long, ExtentTest> extentTestMap = new HashMap<Long, ExtentTest>(); 
	static String projectPath = System.getProperty("user.dir");
	static String reportLocation = (projectPath+"\\target\\");
	String fileName = reportLocation+"ExtentReport.html";



	public synchronized ExtentReports ExtentReport() throws Exception{

		File reportDirect = new File (reportLocation);
		
/*		if (reportDirect.exists()){
			deleteDirectory(reportDirect);
			reportDirect.delete();
			System.out.println("ExtentReport22");
		} */
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		ExtentReports extent = new ExtentReports();
		htmlReporter.config().setTheme(Theme.STANDARD);	
		htmlReporter.config().setDocumentTitle("Automation Report For You");
		extent.attachReporter(htmlReporter);
		
		
	
		return extent;

		

	}
	public synchronized ExtentTest start_Test(String strName){
		extent = TestRunnerHooks.extentMap.get(Thread.currentThread().getId());
		testName=extent.createTest(strName);
		System.out.println("ExtentReport Test name set up done"+strName);
	//	extentTestMap.put(Thread.currentThread().getId(), testName);
		return testName;
	}


	public synchronized void Reporter(String statu, String description) throws Exception{
		
	//	System.out.println("extent_Repo_Reporter print  "+statu);
		switch (statu.toUpperCase()) {
		case "FAIL":
			
			add_Screensot(description);
			stepName.log(Status.FAIL,description);
			break;

		case "PASS":
			stepName.log(Status.PASS,description);
			break;

		case "WARNING":
			stepName.log(Status.WARNING,description);
			break;

		case "INFO":
			stepName.log(Status.WARNING,description);
			break;

		default: 
			stepName.log(Status.PASS,description);
			throw new Exception ("Reporting Error");

		}	

	}

	public synchronized String add_Screensot(String Errormsg) throws Exception{
		TakesScreenshot scrrenshot = (TakesScreenshot) driver;
		System.out.println(driver.getCurrentUrl());
		File srcPath = scrrenshot.getScreenshotAs(OutputType.FILE);
		String destPath = reportLocation+"ScreenShots"+System.currentTimeMillis();
		File targetPath = new File(destPath);
		FileUtils.contentEquals(srcPath, targetPath);
		FileUtils.getFile(srcPath, destPath);
		stepName.addScreenCaptureFromPath(destPath);
		
	//	stepName.log(Status.FAIL, Errormsg);
		return destPath;

	}
//	public synchronized void FlushReport(){extent.flush();}

	public synchronized void initStep(String tagName,String step) throws Exception{
	//	testName = TestRunnerHooks.extentTestMap.get(Thread.currentThread().getId());
		
	//	scenarioName = testName.createNode("MyScenario");
	//   stepName=testName.createNode(tagName +step);

		stepName=scenarioName.createNode(new GherkinKeyword(tagName),step);
	

	}

	public synchronized void deleteDirectory(File file){
		for ( File subfile : file.listFiles()){
			if (subfile.isDirectory()){
				deleteDirectory(subfile);
			}
			subfile.delete();
		}
		
	}
}
