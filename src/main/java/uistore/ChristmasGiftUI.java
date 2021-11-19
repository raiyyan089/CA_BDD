//ChristmasGifUI

package uistore;

import org.openqa.selenium.By;

public class ChristmasGiftUI {
	public static By firstproduct=By.xpath("//*[@class='grid-product__title']");
	
	public static By addtocart=By.xpath("//*[@name='add']");
	
	public static By verifyproduct=By.xpath("//*[@class='cart__product-name']");
	
	public static By checkout=By.xpath("//*[@name='checkout']");

	public static By closepopup=By.xpath("//*[@class='wa-optin-widget-close-img']");
	
	public static By returntocart=By.xpath("//*[@class='step__footer__previous-link']");
	
	public static By cartproduct=By.xpath("//*[@class='cart__product-name']");
}
