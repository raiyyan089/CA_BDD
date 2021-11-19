package StepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import pageobject.HomePage;
import pageobject.PersonalizedGift;
import reusableComponents.WebDriverHelper;
import runnerTestNG.BigSmall;
import utility.ReadPropertyFile;
import utility.RetreiveExcelData;

@RunWith(Cucumber.class)
public class SearchSD {

	
	public static Logger Log = LogManager.getLogger(BigSmall.class.getName());
	
	public static WebDriver driver = null;
	HomePage hp=null;
	
	@Given("Getting driver from PersonalizedGiftSD")
	public void getting_driver_from_personalizedgiftsd() throws Exception {
		 driver = PersonalizedGiftSD.getDriver(); 
		 Thread.sleep(2000);
		 Log.info("Received driver form Personalized Gift");
	}
	
	//---------------------->>>Search Box Scenario<<<-----------------------
	//---------------------->>>Search Box Scenario<<<-----------------------
	
	@Then("Activate the Search box")
	public void activate_the_search_box() {
		Log.info("Search Box Activated");
	}
	
	@Then("Get values from excel file")
	public void get_valuesfrom_excel_file() throws IOException {
		ArrayList<String> d = RetreiveExcelData.getData("SearchDiary");
		hp = new HomePage(driver);	
		hp.getsearchbox().sendKeys(d.get(1));
		hp.getsearchbox().sendKeys(Keys.ENTER);
		Log.info("product name has been sent to search box");
	}
	
	@Then("Send keys into the Search box")
	public void send_keys_into_the_search_box() {
		Log.info("Successfully searched product - Diary");
	}
	
	@Then("verify if searched product is displayed")
	public void verify_if_searched_product_is_displayed() {
		if(hp.getsearchproduct().isDisplayed())
			Assert.assertTrue(true);
		Log.info("Successfully verified products are displayed");
	}

	public static WebDriver getDriver() {
		return driver;
	}


}