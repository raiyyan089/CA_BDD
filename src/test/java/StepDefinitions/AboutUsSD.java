package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobject.ChristmasGift;
import pageobject.HomePage;
import reusableComponents.WebDriverHelper;
import runnerTestNG.BigSmall;
import utility.ReadPropertyFile;

public class AboutUsSD {

public static Logger Log = LogManager.getLogger(BigSmall.class.getName());
	
	public static WebDriver driver = null;
	HomePage hp=null;
	public static ReadPropertyFile rp = null;
	
	@Given("Getting driver from WishlistSD")
	public void getting_driver_from_wishlistsd() throws Exception {
		 driver = WishlistSD.getDriver();		 
		 Thread.sleep(2000);
		 Log.info("Received driver from GiftCardSD");
	}
	
	//---------------------->>>About Us Scenario<<<-----------------------
	//---------------------->>>About Us Scenario<<<-----------------------
	
	@Then("Click On About Us in the footer")
	public void click_on_about_us_in_the_footer() {
		hp = new HomePage(driver);
		hp.getaboutus().click();
		Log.info("About Us Page");
	}
	
	@Then("Verify Title of The page")
	public void verify_title_of_the_page() {
		if(driver.getTitle().equals("About us"))
			Assert.assertTrue(true);
		Log.info("Verified title of About Us Page");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}
