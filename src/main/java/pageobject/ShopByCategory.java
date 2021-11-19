package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uistore.ShopByCategoryUI;


public class ShopByCategory {
public WebDriver driver;
	
	public ShopByCategory(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getbirthdaygift() {
		List<WebElement> list=driver.findElements(ShopByCategoryUI.birthdaygift);
		return list.get(1);
	}
	
	public WebElement getfirstproduct() {
		return driver.findElement(ShopByCategoryUI.firstproduct);
	}
	
	public WebElement addtowishlist() {
		return driver.findElement(ShopByCategoryUI.addtowishlist);
	}
	
	public WebElement verifyadded() {
		return driver.findElement(ShopByCategoryUI.viewwishlist);
	}
}
