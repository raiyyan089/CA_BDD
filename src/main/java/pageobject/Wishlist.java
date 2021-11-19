package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uistore.WishlistUI;

public class Wishlist {
public WebDriver driver;
	
	public Wishlist(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement productvisible() {
		return driver.findElement(WishlistUI.product);
	}
	
	public WebElement closepopup() {
		List<WebElement> list=driver.findElements(WishlistUI.popup);
		return list.get(2);
	}
}
