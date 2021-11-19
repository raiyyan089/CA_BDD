package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import StepDefinitions.HomePageSD;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import pageobject.HomePage;
import pageobject.Login;
import reusableComponents.WebDriverHelper;
import runnerTestNG.BigSmall;
import utility.ReadPropertyFile;


@RunWith(Cucumber.class)
public class LoginSD{
	
	public static Logger Log = LogManager.getLogger(BigSmall.class.getName());
	
	public static WebDriver driver = null;
	HomePage hp=null;
	Login l=null;

	@Given("Getting driver from HomePageSD")
	public void getting_driver_from_homepagesd() throws Exception {
		driver = HomePageSD.getDriver();
		Thread.sleep(2000);
		Log.info("Driver received from HomePageSD");
	}
	
	@Then("Click On Sign In in Menu Bar")
	public void click_on_sign_in_in_menu_bar() throws InterruptedException {
		hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.login().click();
		Log.info("Successfully directed to Sign In Page");
		Thread.sleep(3000);
	}
	
	@Then("Enter {string} and Enter {string}")
	public void enter_and_enter(String string, String string2) {
		l=new Login(driver);

		l.setemail().clear();
		l.setemail().sendKeys(string);
		Log.info("Entered username-> "+string);
		l.setpassword().clear();
		l.setpassword().sendKeys(string2);
		Log.info("Entered password-> "+string2);
	}
	
	@Then("Click On Sign In Button")
	public void click_on_sign_in_button() throws InterruptedException {
		Login l=new Login(driver);
    	l.login().click();
		Log.info("Clicked on Submit button");
		Thread.sleep(2000);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}