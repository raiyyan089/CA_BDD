package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import reusableComponents.WebDriverHelper;
import runnerTestNG.BigSmall;
import utility.ReadPropertyFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class HomePageSD {

	public static Logger Log = LogManager.getLogger(BigSmall.class.getName());
	
	public static WebDriver driver = null;
	public static ReadPropertyFile rp = null;
	
	@Given("^Open the Browser$")
	public void open_the_browser() throws Throwable {
		rp = new ReadPropertyFile();
		driver = WebDriverHelper.initializeDriver();
		Log.info("Browser Launched successfully");
	}

	@Then("^Hit the url$")
	public void hit_the_url() throws Throwable {
		driver = WebDriverHelper.getDriver();
		driver.get(rp.getUrl());
		System.out.println("Navigated to URL");
		
		driver.manage().window().maximize();
		Log.info("Landing at Home Page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static ReadPropertyFile getReadProbObject()
	{
		return rp;
	}
}
