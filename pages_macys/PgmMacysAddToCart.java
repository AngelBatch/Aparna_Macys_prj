package SeleniumHandsOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PgmMacysAddToCart {
	WebDriver d1;
	//WebDriverWait wait;
	
	public PgmMacysAddToCart(WebDriver d1){
		this.d1=d1;
	}
	public Boolean AddToCart() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(d1,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='thumbnails']/li[@class='productThumbnail borderless'][1]"))).click();
	d1.findElement(By.xpath(".//*[@class='swatchesList']/li[3]/div")).click();
	Select slt = new Select(d1.findElement(By.className("productQuantity")));
			
			slt.selectByVisibleText("2");
	
	//d1.findElementById("searchSubmit").click();
	d1.findElement(By.xpath("//div[contains(@id,'orderPanel')]//button")).click();
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkoutLink"))).click();
	Boolean cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='itemName']/a[@class='productName productUrl'] [contains(text(),'Jeans')]"))).isDisplayed();
	return cart;
	}
	
	public String RemoveCart(){
		WebDriverWait wait = new WebDriverWait(d1,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[starts-with(@id,'lineitem')]/div/div/div[3]"))).click();
		String message= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_generalmessage"))).getText();
		System.out.println(message);
		return message;
	//	String message2 = "Removed from bag";
	//	Boolean removeCart= Assert.assertEquals(message, message2);
	}
}