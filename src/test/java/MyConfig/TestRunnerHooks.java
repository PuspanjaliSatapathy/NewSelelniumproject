package MyConfig;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import StepDefinations.RunnerSetup;
import common.commonmethods;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
glue= {"StepDefinations","com.jacksparrow.automation.steps_definitions.functional"},
monochrome=true,
plugin={"pretty","html:target/HTMLReports"},
tags="@smoketest3"
		)
public class TestRunnerHooks {

	public static Map<Long, WebDriver> driverMap = new HashMap<Long,WebDriver>();
	
	public static Map<Long, ExtentReports> extentMap = new HashMap<Long, ExtentReports>(); 
	public static Map<Long, ExtentTest> extentTestMap = new HashMap<Long, ExtentTest>();
//	public static Map<Long, ExtentTest> extentStepNameMap = new HashMap<Long, ExtentTest>();
	
	static RunnerSetup setup = new RunnerSetup();


	@BeforeClass()
	public static void setUpExecution() {
		System.out.println("Before callss entered");
		try {
			setup.openBrowser("chrome");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			setup.openReport("Test Result Report"+java.time.LocalDate.now());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void teardown() throws Exception{
		System.out.println("I am inside After");
		System.out.println("**************/n***will Run Only once at the end of the test");
		setup.closeBrowser();
		setup.flushReport();
	}
	
}
