package common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import MyConfig.TestRunnerHooks;
import io.github.bonigarcia.wdm.WebDriverManager;

public class commonmethods {

	  WebDriver driver = TestRunnerHooks.driverMap.get(Thread.currentThread().getId());
	

	
	public void openUrl(String url)throws Exception {

		driver.get(url);

		Thread.sleep(1000);
		
	}
	//comment2

	public void eneterText(String text, String textbox) throws Exception{
		
		System.out.println("text box is "+textbox);
		getElement(textbox).sendKeys(text);
	}

	public void keyInEle(String Key,String element)throws Exception{
		switch (Key) {
		case "ENTER":
			getElement(element).sendKeys(Keys.ENTER);
			break;
		case "CLEAR":
			getElement(element).sendKeys(Keys.CLEAR);
			break;
		case "ARROWDOWN":
			getElement(element).sendKeys(Keys.ARROW_DOWN);
			break;
		case "ARROWUP":
			getElement(element).sendKeys(Keys.ARROW_UP);
			break;
		default: 
			System.out.println("Invalid Key Value");
		}
	}
	
	public void verifyTextOnElement(String text, String element)throws Exception {
		
			String actualText = getElement(element).getText();
			
			if (!actualText.contains(text)){
				System.out.println("Actual text is " +actualText);
				System.out.println("Expected text is  " +text);

				throw new Exception ("element dosnt contain text "+ text);
			}
				
		}

	public WebElement getElement(String locatorpath)throws Exception {
	//	By locator = null;
	// locatorpath.toLowerCase().split(":")[0].contains("xpath");

	//	locator = By.xpath(locatorpath.split(":", 2)[1]);
		
		WebElement ele= driver.findElement(By.xpath(locatorpath.split(":", 2)[1]));
		System.out.println(ele.getText());
		return ele;
	}

	public void browser_Button_Functions(String browserButton)throws Exception {
		switch (browserButton.toUpperCase()) {
		case "BACK":
			driver.navigate().back();
			System.out.println("back button clicked");
			break;
		case "FROWARD":
			driver.navigate().forward();
			break;
		case "REFRESH":
			driver.navigate().refresh();
			break;
		default: 
			System.out.println("Invalid Key Value");
		}
		
	}






}
