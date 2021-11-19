package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uistore.HomeUI;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement login() {
		return driver.findElement(HomeUI.signin);
	}
	
	public WebElement getpersonalizedgift() {
		return driver.findElement(HomeUI.personalizedgift);
	}
	
	public WebElement getnewgift() {
		return driver.findElement(HomeUI.Newgift);
	}
	
	public WebElement getchristgift() {
		return driver.findElement(HomeUI.christmasgift);
	}
	
	public WebElement getshopbycategory() {
		List<WebElement> list=driver.findElements(HomeUI.shopbycategory);
		return list.get(3);
	}
	
	public WebElement getallofit() {
		return driver.findElement(HomeUI.allofit);
	}
	
	public WebElement getwishlist() {
		return driver.findElement(HomeUI.wishlist);
	}
	
	public WebElement getaboutus() {
		return driver.findElement(HomeUI.aboutus);
	}
	
	public WebElement getgiftcard() {
		return driver.findElement(HomeUI.giftcard);
	}
	
	public WebElement getmyaccount() {
		return driver.findElement(HomeUI.myaccount);
	}
	
	public WebElement getsearchbox() {
		return driver.findElement(HomeUI.searchbox);
	}
	
	public WebElement getclosecart() {
		List<WebElement> list=driver.findElements(HomeUI.closecart);
		return list.get(4);
	}
	
	public WebElement getsearchproduct() {
		List<WebElement> list=driver.findElements(HomeUI.searchproduct);
		return list.get(0);
	}
}
