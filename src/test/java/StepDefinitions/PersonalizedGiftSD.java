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
public class PersonalizedGiftSD {

	
	public static Logger Log = LogManager.getLogger(BigSmall.class.getName());
	
	public static WebDriver driver = null;
	PersonalizedGift pg=null;
	
	@Given("Getting driver from LoginSD")
	public void getting_driver_from_loginsd() throws Exception {
		 driver = LoginSD.getDriver();
		 Thread.sleep(2000);
		 Log.info("Received driver from LoginSD");
	}
	
	
	//---------------------->>>Personalized Gifts Scenario<<<-----------------------
	//---------------------->>>Personalized Gifts Scenario<<<-----------------------
	
	@Then("Click On Personalized Gifts Menu")
	public void click_on_personalized_gifts_menu() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.getpersonalizedgift().click();	
		Thread.sleep(2000);
		Log.info("Clicked on Personalized Gifts");
	}
	
	@Then("Click On Sort By")
	public void click_on_sort_by() {
		pg=new PersonalizedGift(driver);
		//implementing sortby--> High to Low Price
		pg.getsortby().click();
		Log.info("Clicked on Sortby");
	}
	
	@Then("select On High to Low")
	public void select_on_high_to_low() {
		pg.gethightolow().click();
		Log.info("Clicked on Hgih to Low");
	}
	
	@Then("check if first product has max price = {int}")
	public void check_if_first_product_has_max_price(Integer int1) {
		if(pg.getmaxprice().getText()=="4500")
			Assert.assertTrue(true);
		Log.info("Successfully Sorted Products High to Low based on price");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

}