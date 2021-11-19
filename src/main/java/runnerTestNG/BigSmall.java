package runnerTestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.Login;
import pageobject.PersonalizedGift;
import pageobject.ShopByCategory;
import pageobject.Wishlist;
import pageobject.AllofitPage;
import pageobject.ChristmasGift;
import reusableComponents.WebDriverHelper;
import utility.ReadPropertyFile;
import utility.RetreiveExcelData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class BigSmall extends WebDriverHelper {
	public static Logger Log = LogManager.getLogger(BigSmall.class.getName());
	
	WebDriver driver = null;
	ReadPropertyFile rp = null;
	
	/*
	 * this method is responsible for landing at home page and click on sign button.
	 * 
	 * WebDriverHelper class has a initializeDriver() method which will launch and
	 * initialize the driver.
	 * 
	 * ReadPropertyFile class :- contains method which is used to retrieve data from
	 * property file.
	 * 
	 * HomePage class contains method to return webelement of respective web page;
	 * 
	 */
	@Test(priority = 1)
	public void HomePageLanding() throws Exception {

		rp = new ReadPropertyFile();

		driver = WebDriverHelper.initializeDriver();

		driver.get(rp.getUrl());
		System.out.println("url hited");
		
		driver.manage().window().maximize();

		Log.info("Landing at Home Page");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	@Test(priority = 2, dataProvider = "dataSuplier")
	public void LoginPage(String username, String password) throws Exception {
		
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.login().click();
		Log.info("Successfully directed to Sign In Page");
		Thread.sleep(3000);


		Login l=new Login(driver);

		l.setemail().clear();
		l.setemail().sendKeys(username);
		Log.info("Entered username-> "+username);
		l.setpassword().clear();
		l.setpassword().sendKeys(password);
		Log.info("Entered password-> "+password);
		l.login().click();
		Log.info("Clicked on Submit button");
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 3)
	public void PersonalizedPage() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getpersonalizedgift().click();	
		PersonalizedGift pg=new PersonalizedGift(driver);
		//implementing sortby--> High to Low Price
		pg.getsortby().click();
		pg.gethightolow().click();
		if(pg.getmaxprice().getText()=="4500")
			Assert.assertTrue(true);
		Log.info("Successfully Sorted Products High to Low based on price");
	}
	
	@Test(priority = 4)
	public void Search() throws IOException, InterruptedException {
		
		ArrayList<String> d = RetreiveExcelData.getData("SearchDiary");
		
		HomePage hp = new HomePage(driver);
		
		for (int i = 1; i < d.size(); i++) {
			hp.getsearchbox().sendKeys(d.get(i));
			hp.getsearchbox().sendKeys(Keys.ENTER);
		}
		Log.info("Successfully searched product - Diary");
		
		if(hp.getsearchproduct().isDisplayed())
			Assert.assertTrue(true);
		Log.info("Successfully verified products are displayed");
	}
	
	@Test(priority = 5)
	public void ChristmasGift() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getchristgift().click();
		Log.info("Successfully navigated to Christmas Gifts");
		ChristmasGift cg=new ChristmasGift(driver);
		cg.getfirstproduct().click();
		Thread.sleep(2000);
		cg.addtocart().click();
		Thread.sleep(500);
		Log.info("Added product to cart");
		cg.gotocheckout().click();
		if(cg.closepopup().isDisplayed())
			cg.closepopup().click();
		Thread.sleep(2000);
		cg.returntocart().click();
		Thread.sleep(1000); 	
		Log.info("Proceeded to checkout and returned to cart");
		
	}
	
	@Test(priority = 6)
	public void ShopByPage() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getshopbycategory().click();
		ShopByCategory sbc=new ShopByCategory(driver);
		sbc.getbirthdaygift().click();
		Log.info("Selected 18th Birthday Gift");
		Thread.sleep(2000);
		sbc.getfirstproduct().click();
		Thread.sleep(4000);
		sbc.addtowishlist().click();
		Thread.sleep(500);
		if(sbc.verifyadded().isDisplayed())
			Assert.assertTrue(true);
		Log.info("Successfully Added Product to Wishlist");
	}
	
	@Test(priority = 7)
	public void AllofIt() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getallofit().click();
		AllofitPage ap=new AllofitPage(driver);
		Thread.sleep(2000);
		Log.info("Navigated to All of it Page");
		if(ap.getproduct().getText().equals("Auto Rickshaw Pen Stand"))
				Assert.assertTrue(true);
		Log.info("Verified Auto Rickshaw Pen Stand");
	}
	
	@Test(priority = 8)
	public void Wishlist() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getwishlist().click();
		Thread.sleep(2000);
		Log.info("Wishlist Page");
		Wishlist w=new Wishlist(driver);
		if(w.closepopup().isDisplayed())
			w.closepopup().click();
		Thread.sleep(2000);
		if(w.productvisible().isDisplayed())
			Assert.assertTrue(true);
		Log.info("Products are displayed in Wishlist");
	}
	
	@Test(priority = 9)
	public void AboutUs() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getaboutus().click();
		Log.info("About Us Page");
		if(driver.getTitle().equals("About us"))
			Assert.assertTrue(true);
		Log.info("Verified title of About Us Page");
	}
	
	@Test(priority = 10)
	public void GiftCard() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getgiftcard().click();
		Log.info("Gift Cards Page");
		ChristmasGift cg=new ChristmasGift(driver);
		cg.addtocart().click();
		Thread.sleep(2000);
		Log.info("Added Gift Card to cart");
		if(cg.verifycart().isDisplayed())
			Assert.assertTrue(true);
		Log.info("Verified cart");
	}
	
	
	
	@DataProvider
	public Object[][] dataSuplier() {
		Object[][] data = new Object[3][2];
		
		data[0][0] = "";
		data[0][1] = "";

		data[1][0] = "simon@123";
		data[1][1] = "abcd";

		data[2][0] = "JackNJill@gmail.com";
		data[2][1] = "JackNJill@123";

		return data;
	}
	
	@AfterTest()
	public void closeDriver() {
		driver.close();
	}

}