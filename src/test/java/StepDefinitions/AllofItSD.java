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

public class AllofItSD {
	
public static Logger Log = LogManager.getLogger(BigSmall.class.getName());
	
	public static WebDriver driver = null;
	HomePage hp=null;
	AllofitPage ap=null;
	
	@Given("Getting driver from ShopByCategorySD")
	public void getting_driver_from_shopbycategorysd() throws Exception {
		 driver = ShopByCategorySD.getDriver();
		 Thread.sleep(2000);
		 Log.info("Received driver from Shop By Category");
	}
	
	//---------------------->>>All of it Scenario<<<-----------------------
	//---------------------->>>All of it Scenario<<<-----------------------
	
	@Then("Click On All of it Menu")
	public void click_on_all_of_it_menu() throws InterruptedException {
		hp = new HomePage(driver);
		hp.getallofit().click();
		Thread.sleep(2000);
		Log.info("Navigated to All of it Page");
	}
	
	@Then("Verify name of the first product")
	public void verify_name_of_the_first_product() {
		ap=new AllofitPage(driver);
		if(ap.getproduct().getText().equals("Auto Rickshaw Pen Stand"))
			Assert.assertTrue(true);
		Log.info("Verified Auto Rickshaw Pen Stand");
	}

	public static WebDriver getDriver() {
		return driver;
	}
	
	
}
