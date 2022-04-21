package StepDefinations;

import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;


import MyConfig.TestRunnerHooks;
import common.commonmethods;
import common.extentReportUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	commonmethods comm = new commonmethods();
//	ExtentTest testName = TestRunnerHooks.extentTestMap.get(Thread.currentThread().getId());
	
	extentReportUtil reportingUtil = new extentReportUtil();
	
	String Pagename = null;
	//testing comment for commit
	
	@Given("^User launched \"(.*)\"$")
	public void user_launched(String url) throws Exception {

		System.out.println("Inside browser launch Step "+url);
		reportingUtil.initStep("Given","User launched"+url);
		try{
			switch (url) {
			case "myURL":
				url="https://www.linkedin.com/";
				comm.openUrl(url);
//				testName.pass(url+ " URL launch success");
				reportingUtil.Reporter("PASS", "Browser launched");
				break;
			case "googlesearch":
				url="https://www.google.com/";
				comm.openUrl(url);
//				testName.pass(url+ " URL launch success");
				break;
			default: 
				url="";
//				testName.fail(url+ " URL launch success");
				reportingUtil.Reporter("FAIL", "Browser launched");
				break;
				
			}
		//	//reportingUtil.extent_Repo_Reporter("PASS", "message passed");
		}catch(Exception e){
//			testName.fail(url+ " URL launch success");
			reportingUtil.Reporter("FAIL", "Browser launched");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		//	//reportingUtil.extent_Repo_Reporter("Fail", e.getMessage());
		//	//Assert.fail(e.getMessage());
			
		}
	}
	@Then("User verify {string} page is loaded")
	public void i_verufy_page_is_loaded(String page) throws Exception {
		reportingUtil.initStep("Then","User verify"+ page+ "page is loaded");
		try{
			Pagename = page;
			Thread.sleep(1000);
//			testName.pass("User verify " +page+" page is loaded");

		} catch (Exception e){
//			testName.fail("User verify " +page+" page is loaded");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
			reportingUtil.Reporter("Fail", e.getMessage());
			//Assert.fail(e.getMessage());
			
		}
	}

	@When("^User enter \"(.*)\" into textbox \"(.*)\"$")
	public void user_enter_into_textbox(String searchtext, String textbox) throws Exception {
		reportingUtil.initStep("When","User enter"+ searchtext+ "into textbox" +textbox);

		try {
			textbox = common.PageMapping.objectMappingWithPage(Pagename, textbox);
			System.out.println("search text "+searchtext);
				
			comm.eneterText(searchtext,textbox);
	//		testName.pass("User enter : "+ searchtext +" into textbox "+textbox);

		} catch (Exception e) {
		//	testName.fail("User enter : "+ searchtext +" into textbox "+textbox);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
			reportingUtil.Reporter("Fail", e.getMessage());
			//Assert.fail(e.getMessage());
			
		}
	}
	
	@When("^User hit \"(.*)\" on \"(.*)\"$")
	public void user_hit_on(String Key, String element) throws Exception {
		reportingUtil.initStep("When","User hit"+Key+" on "+element);
		try {
			element=common.PageMapping.objectMappingWithPage(Pagename, element);
			comm.keyInEle(Key,element);
		//	testName.pass("User hit "+Key+" on " +element);


		} catch (Exception e) {
		//	testName.fail("User hit "+Key+" on " +element);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
			reportingUtil.Reporter("Fail", e.getMessage());
			//Assert.fail(e.getMessage());
			
		}
	}
	
	@Then("^User verify \"(.*)\" contains Text \"(.*)\"$")
	public void user_verify_contains_Text(String element, String Text)throws Throwable {
		reportingUtil.initStep("Then","User verify "+element+" contains Text  "+Text);
		
		try {
			element=common.PageMapping.objectMappingWithPage(Pagename, element);
			comm.verifyTextOnElement(Text,element);
	//		testName.pass("User verify "+element+" contains Text " +Text);

		

		} catch (Exception e) {
	//		testName.fail("User verify "+element+" contains Text " +Text);
			reportingUtil.Reporter("Fail", e.getMessage());
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			
			e.printStackTrace();
			//Assert.fail(e.getMessage());
	
		}
	}
	
	@Then("^User hit browser button \"(.*)\"$")
	public void user_hit_browser_button(String string) throws Exception {
		reportingUtil.initStep("Then","User hit browser button  "+string);
		try{
		comm.browser_Button_Functions(string);
//		testName.pass("User hit browser button "+string);
		
		}catch (Exception e) {
//			testName.fail("User hit browser button "+string);
			reportingUtil.Reporter("Fail", e.getMessage());
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			//
			e.printStackTrace();
			//Assert.fail(e.getMessage());
			
		}
	   
	}

//----------------------------------------------------

	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
	    	System.out.println("My Step no 1");
	   
	}

	@Given("User set other precondition")
	public void some_other_precondition() throws Exception {
		reportingUtil.initStep("Given","User set other precondition");
	    	System.out.println("My Step no 2");
	   
	}

	@When("I complete action")
	public void i_complete_action() {
	    	System.out.println("My Step no 3");
	   
	}

	@When("some other action")
	public void some_other_action() {
	    	System.out.println("My Step no 4");
	   
	}

	@When("yet another action")
	public void yet_another_action() {
	    	System.out.println("My Step no 5");
	   
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
	    	System.out.println("My Step no 6");
	   
	}

	@Then("check more outcomes")
	public void check_more_outcomes() {
	    	System.out.println("My Step no 7");
	   
	}

	@Given("I want to write a step with name1")
	public void i_want_to_write_a_step_with_name1() {
	    	System.out.println("My Step no 8");
	   
	}

	@When("I check for the {int} in step")
	public void i_check_for_the_in_step(Integer int1) {
	    	System.out.println("My Step no 9");
	   
	}

	@Then("I verify the success in step")
	public void i_verify_the_success_in_step() {
	    	System.out.println("My Step no 10");
	
	   
	}

	@Given("I want to write a step with name2")
	public void i_want_to_write_a_step_with_name2() {
	    	System.out.println("My Step no 11");
	   
	}

	@Then("I verify the Fail in step")
	public void i_verify_the_fail_in_step() {
	    	System.out.println("My Step no 12");
	   
	}

}
