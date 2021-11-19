package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uistore.ChristmasGiftUI;

public class ChristmasGift {
	
	
	public WebDriver driver;
	
	public ChristmasGift(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getfirstproduct() {
		return driver.findElement(ChristmasGiftUI.firstproduct);
	}

	public WebElement addtocart() {
		return driver.findElement(ChristmasGiftUI.addtocart);
	}
	
	public WebElement verifyproduct() {
		return driver.findElement(ChristmasGiftUI.verifyproduct);
	}

	public WebElement gotocheckout() {
		return driver.findElement(ChristmasGiftUI.checkout);
	}

	public WebElement returntocart() {
		return driver.findElement(ChristmasGiftUI.returntocart);
	}
	
	public WebElement closepopup() {
		return driver.findElement(ChristmasGiftUI.closepopup);
	}
	
	public WebElement verifycart() {
		return driver.findElement(ChristmasGiftUI.cartproduct);
	}
}
