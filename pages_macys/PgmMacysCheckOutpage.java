package SeleniumHandsOn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PgmMacysCheckOutpage {
//WebDriverWait  wait;
WebDriver d1;


	public PgmMacysCheckOutpage(WebDriver d1){
		// TODO Auto-generated method stub
		
		this.d1=d1;
	}
	
	public boolean checkout(){
		WebDriverWait wait = new WebDriverWait(d1,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continueCheckout"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("isWithoutProfile"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rc-shipping-continue"))).click();
		
		List<WebElement> mandatory = d1.findElements(By.xpath(".//*[@class='error_msg']"));
		for(WebElement mandatories:mandatory)
		{
			System.out.println(mandatories.getText());
			
			
		}
		
	
		boolean error = mandatory.isEmpty();
		return error;
	}

}
