package SeleniumHandsOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PgmMacysHomepage {
	WebDriver d1 ;

	

	public PgmMacysHomepage(WebDriver d1)
	{
		// TODO Auto-generated constructor stub
		this.d1 = d1;
	}



	public boolean SearchJeans(){
		WebDriverWait wait = new WebDriverWait(d1,30);
		//this.d1=d1;
	/*	System.setProperty("Webdriver.firefox.driver", "geckodriver.exe");
		FirefoxDriver d1 = new FirefoxDriver();
		d1.get("https://www.macys.com");
		d1.manage().window().maximize();*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[starts-with(@id,'flexid')]/a[contains(text(),'JUNIORS')]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='nav_cat_sub_3']/li/a[text()='Jeans']"))).click();
		//String actual = d1.getTitle();
		boolean chk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currentCatNavHeading"))).isDisplayed();
		return chk;
		
	}

}
