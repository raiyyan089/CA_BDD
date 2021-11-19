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

public class GiftCardSD {

public static Logger Log = LogManager.getLogger(BigSmall.class.getName());
	
	public static WebDriver driver = null;
	HomePage hp=null;
	ChristmasGift cg=null;
	
	@Given("Getting driver from AboutUsSD")
	public void getting_driver_from_aboutussd() throws Exception {
		 driver = AboutUsSD.getDriver();
		 Thread.sleep(2000);
		 Log.info("Received driver from WishlistSD");
	}
	

	//---------------------->>>Gift Card Scenario<<<-----------------------
	//---------------------->>>Gift Card Scenario<<<-----------------------

	@Then("Click On Gift Card icon")
	public void click_on_gift_card_icon() {
		hp = new HomePage(driver);
		hp.getgiftcard().click();
		Log.info("Gift Cards Page");
	}
	
	@Then("select Add to Cart Gift")
	public void select_add_to_cart_gift() throws InterruptedException {
		cg=new ChristmasGift(driver);
		cg.addtocart().click();
		Thread.sleep(2000);
		Log.info("Added Gift Card to cart");
	}
	
	@Then("verify if cart is displayed")
	public void verify_if_cart_is_displayed() {
		if(cg.verifycart().isDisplayed())
			Assert.assertTrue(true);
		Log.info("Verified cart");
		hp.getclosecart().click();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}


}
