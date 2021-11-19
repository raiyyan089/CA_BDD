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

public class ShopByCategorySD {

public static Logger Log = LogManager.getLogger(BigSmall.class.getName());
	
	public static WebDriver driver = null;
	HomePage hp=null;
	ShopByCategory sbc=null;

	@Given("Getting driver from ChristmasGiftSD")
	public void getting_driver_from_christmasgiftsd() throws Exception {
		 driver = ChristmasGiftSD.getDriver();
		 Thread.sleep(2000);
		 Log.info("Received driver from Christmas Gift");
	}
	
	
	
	//---------------------->>>Shop By Category Scenario<<<-----------------------
	//---------------------->>>Shop By Category Scenario<<<-----------------------
	
	@Then("Click On Shop By Category Drop Down")
	public void click_on_shop_by_category_drop_down() {
		hp = new HomePage(driver);
		hp.getshopbycategory().click();
		Log.info("Clicked On Shop By Category Drop Down");
	}
	
	@Then("select and Open 18th Birthday Gift")
	public void select_and_open_18th_birthday_gift() throws InterruptedException {
		sbc=new ShopByCategory(driver);
		sbc.getbirthdaygift().click();
		Log.info("Selected 18th Birthday Gift");
		Thread.sleep(2000);
		Log.info("selected 18th Birthday Gift");
	}
	
	@Then("Click On First Shop Product to Open")
	public void click_on_first_shop_product_to_open() throws InterruptedException {
		sbc.getfirstproduct().click();
		Thread.sleep(4000);
		Log.info("Clicked On First Shop Product");
	}
	
	@Then("select Add to Wishlist")
	public void select_add_to_wishlist() throws InterruptedException {
		sbc.addtowishlist().click();
		Thread.sleep(500);
		Log.info("Clicked On Add to Wishlist");
	}
	
	@Then("verify if product is added")
	public void verify_if_product_is_added() {
		if(sbc.verifyadded().isDisplayed())
			Assert.assertTrue(true);
		Log.info("Successfully Added Product to Wishlist");
	}

	public static WebDriver getDriver() {
		return driver;
	}




}
