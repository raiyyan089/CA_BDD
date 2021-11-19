package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uistore.AllofitUI;
import uistore.PersonalizedGiftUI;

public class AllofitPage {
	
	
	public WebDriver driver;
	
	public AllofitPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getproduct() {
		return driver.findElement(AllofitUI.firstproduct);
	}
	

}
