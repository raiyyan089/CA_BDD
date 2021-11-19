package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uistore.LoginUI;

public class Login {
	
	public WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement setemail() {
		return driver.findElement(LoginUI.email);
	}
	
	public WebElement setpassword() {
		return driver.findElement(LoginUI.password);
	}
	
	public WebElement login() {
		return driver.findElement(LoginUI.siginbutton);
	}
	
}
