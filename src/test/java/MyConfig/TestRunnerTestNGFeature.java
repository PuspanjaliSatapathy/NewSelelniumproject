package MyConfig;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import StepDefinations.RunnerSetup;
import io.cucumber.core.gherkin.Pickle;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;




@CucumberOptions(features="src/test/resources/Features/googlesearch.feature",
glue= {"StepDefinations"},
monochrome=true,
plugin={"pretty","html:target/HTMLReports"},
tags="@smoketest3"
		)
public class TestRunnerTestNGFeature {

	public static Map<Long, WebDriver> driverMap = new HashMap<Long,WebDriver>();
	
	public static Map<Long, ExtentReports> extentMap = new HashMap<Long, ExtentReports>(); 
	public static Map<Long, ExtentTest> extentTestMap = new HashMap<Long, ExtentTest>();
//	public static Map<Long, ExtentTest> extentStepNameMap = new HashMap<Long, ExtentTest>();
	
	static RunnerSetup setup = new RunnerSetup();
	
	   private TestNGCucumberRunner testNGCucumberRunner;
	 
	   
	    @BeforeClass(alwaysRun = true)
	    public void setUpClass() {
	    	System.out.println("Before callss entered");
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    	try {
				setup.openBrowser("chrome");
				setup.openReport("Test Result Report"+java.time.LocalDate.now());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    }
	    

	   @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
	    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
	    	System.out.println("inside test");
	        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	        
	    }
	 
	    @DataProvider
	    public Object[][] scenarios() {
	        if (testNGCucumberRunner == null) {
	        	System.out.println("testNGCucumberRunner is null ");
	            return new Object[0][0];
	        }
	        
	        Object[][] originalScenarios = testNGCucumberRunner.provideScenarios();
	        
	        for (Object[] scenario : originalScenarios ) {
	        	PickleWrapper pickelWrapper = (PickleWrapper) scenario[0];
	        io.cucumber.testng.Pickle pickle = pickelWrapper.getPickle();
	        }
	        return testNGCucumberRunner.provideScenarios();
	        
	    }
	  
	
	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() {
	    	System.out.println("I am inside After");
	        if (testNGCucumberRunner == null) {
	            return;
	        }
	        testNGCucumberRunner.finish();
			System.out.println("**************/n***will Run Only once at the end of the test");
			try {
				setup.closeBrowser();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setup.flushReport();
	    }
}
