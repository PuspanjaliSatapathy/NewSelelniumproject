package MyConfig;

import java.util.HashMap;
import java.util.Map;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinations"},
monochrome=true,
plugin={"pretty","html:target/HTMLReports"},
tags="@smoketest3"

)
public class TestRunner {
	

}
