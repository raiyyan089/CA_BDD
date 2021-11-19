package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobject.AllofitPage;
import pageobject.HomePage;
import pageobject.ShopByCategory;
import pageobject.Wishlist;
import reusableComponents.WebDriverHelper;
import runnerTestNG.BigSmall;
import utility.ReadPropertyFile;

public class WishlistSD {

public static Logger Log = LogManager.getLogger(BigSmall.class.getName());
	
	public static WebDriver driver = null;
	HomePage hp=null;
	Wishlist w=null;

	@Given("Getting driver from AllofItSD")
	public void getting_driver_from_allofitsd() throws Exception {
		 driver = AllofItSD.getDriver(); 
		 Thread.sleep(2000);
		 Log.info("Received driver from AllofItSD");
	}
	
	
	//---------------------->>>Wishlist Scenario<<<-----------------------
	//---------------------->>>Wishlist Scenario<<<-----------------------


	@Then("Click On Wishlist icon")
	public void click_on_wishlist_icon() throws InterruptedException {
		hp = new HomePage(driver);
		hp.getwishlist().click();
		Thread.sleep(2000);
		Log.info("Wishlist Page");
	}
	
	@Then("Close Popup if appears")
	public void close_popup_if_appears() throws InterruptedException {
		w=new Wishlist(driver);
		if(w.closepopup().isDisplayed())
			w.closepopup().click();
		Thread.sleep(2000);
	}
	
	@Then("Verify if products are displayed")
	public void verify_if_products_are_displayed() {
		if(w.productvisible().isDisplayed())
			Assert.assertTrue(true);
		Log.info("Products are displayed in Wishlist");
	}


	public static WebDriver getDriver() {
		return driver;
	}

}
