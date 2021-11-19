//PersonalizedGift.java

package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uistore.PersonalizedGiftUI;

public class PersonalizedGift {
	
	
	public WebDriver driver;
	
	public PersonalizedGift(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getsortby() {
		return driver.findElement(PersonalizedGiftUI.sortby);
	}
	
	public WebElement gethightolow() {
		return driver.findElement(PersonalizedGiftUI.hightolow);
	}
	
	public WebElement getmaxprice() {
		return driver.findElement(PersonalizedGiftUI.maxprice);
	}

}
