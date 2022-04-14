package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import MyConfig.TestRunnerHooks;
//import TestNGTest.TestNGCucumberRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.TestNGCucumberRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import common.extentReportUtil;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class RunnerSetup {
	public static WebDriver driver;
	

	
	common.extentReportUtil report = new common.extentReportUtil();
/*	
 //	public static TestNGCucumberRunner testNGCucumberRunner;
 	
		
	@Test
	public static void runScenario()
	{
		

		
	} 
		
	@DataProvider
		public static Object[][] getData(){
			String excelpath = "/testdata/Book1.xlsx";
			String sheetName = "Sheet1";
			Object Data [][] =common.excelDataprovide.read(excelpath,sheetName);
			return Data;
		}
		
		*/
		@Before(order=0)
		public void createReportNode(Scenario currentScenario) throws Exception{
		
		
		ExtentTest testName=report.start_Test(currentScenario.getName());
		TestRunnerHooks.extentTestMap.put(Thread.currentThread().getId(), testName);
		report.scenarioName=TestRunnerHooks.extentTestMap.get(Thread.currentThread().getId()).createNode(currentScenario.getName());

	
		
		}
			
		@Before(value="@smoke1",order=1)
		public void tagSepecificHook() throws Exception{
		System.out.println("un any Hook with a condition specific to Tag");
		}
		
		
		@After
		public void teardown(){
		//	System.out.println("I am inside After");
		//	TestRunnerHooks.driverMap.get(Thread.currentThread().getId()).close();
		}
		public static void openBrowser(String browser) throws Exception{
			System.out.println("Inside before hooks"+"**************/n***will Run Only once during the test");
			
			switch (browser.toLowerCase()) {
	        case "chrome":
	        	System.out.println("Inside before hooks1"+browser);
	        	WebDriverManager.chromedriver().setup();
	    		driver = new ChromeDriver();
	    		System.out.println("Inside before hooks2"+browser);
	            break;
	        case "edge":
	        	WebDriverManager.edgedriver().setup();
	    		driver = new ChromeDriver();
	            break;
	        case "firefox":
	        	WebDriverManager.firefoxdriver().setup();
	    		driver = new ChromeDriver();
	            break;
	        default: 
	        	System.out.println("Inside before hooks"+browser);
	        	WebDriverManager.chromedriver().setup();
	    		driver = new ChromeDriver();
			}
			
			TestRunnerHooks.driverMap.put(Thread.currentThread().getId(),driver);
			driver.manage().window().maximize();
		}
		
		public void openReport(String myTestName ) throws Exception{
			
			ExtentReports extent = report.ExtentReport();
			TestRunnerHooks.extentMap.put(Thread.currentThread().getId(), extent);
		//	ExtentTest testName=report.start_Test(myTestName);
		//	TestRunnerHooks.extentTestMap.put(Thread.currentThread().getId(), testName);
			 
			
			} 
		public static void closeBrowser() throws Exception{
			
			TestRunnerHooks.driverMap.get(Thread.currentThread().getId()).close();
		}
		public void flushReport(){
		
			TestRunnerHooks.extentMap.get(Thread.currentThread().getId()).flush();
	
		}
	}
