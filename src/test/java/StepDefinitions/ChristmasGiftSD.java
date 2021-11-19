package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobject.AllofitPage;
import pageobject.ChristmasGift;
import pageobject.HomePage;
import pageobject.ShopByCategory;
import reusableComponents.WebDriverHelper;
import runnerTestNG.BigSmall;
import utility.ReadPropertyFile;

public class ChristmasGiftSD {
	
public static Logger Log = LogManager.getLogger(BigSmall.class.getName());
	
	public static WebDriver driver = null;
	HomePage hp=null;
	ChristmasGift cg=null;
	
	@Given("Getting driver from SeachSD")
	public void getting_driver_from_searchsd() throws Exception {
		 driver = SearchSD.getDriver();
		 Thread.sleep(2000);
		 Log.info("Received Driver from SearchSD");
	}
	
	//---------------------->>>Christmas Gift Scenario<<<-----------------------
	//---------------------->>>Christmas Gift Scenario<<<-----------------------

	@Then("Click On Christmas Gift Menu")
	public void click_on_christmas_gift_menu() {
		hp = new HomePage(driver);
		hp.getchristgift().click();
		Log.info("Successfully navigated to Christmas Gifts");
	}
	
	@Then("Click On First Christmas Product to Open")
	public void click_on_first_christmas_product_to_open() throws InterruptedException {
		cg=new ChristmasGift(driver);
		cg.getfirstproduct().click();
		Thread.sleep(2000);
		Log.info("Selected first product");
	}
	
	@Then("select Add to Cart Christmas")
	public void select_add_to_cart_christmas() throws InterruptedException {
		cg.addtocart().click();
		Thread.sleep(500);
		Log.info("Added product to cart");
	}
	
	@Then("Go to Checkout")
	public void go_to_checkout() throws InterruptedException {
		cg.gotocheckout().click();
		Log.info("Clicked on Checkout");
		Thread.sleep(2000);
	}
	
	@Then("Close the Popup if it appears")
	public void close_the_popup_if_it_appears() throws InterruptedException {
		if(cg.closepopup().isDisplayed()) {
			cg.closepopup().click();
			Log.info("Closed pop up after dsiplay");
		}
		Thread.sleep(2000);
		
	}
	
	@Then("Return to Cart")
	public void return_to_cart() throws InterruptedException {
		cg.returntocart().click();
		Thread.sleep(1000); 	
		Log.info("Proceeded to checkout and returned to cart");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
}
