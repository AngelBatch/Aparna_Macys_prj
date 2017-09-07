package SeleniumHandsOn;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PgmMacysSearchResultPage {
	
	WebDriver d1;
	//WebDriverWait wait;
	public PgmMacysSearchResultPage(WebDriver d1){
		this.d1= d1;
	}
	public int expectedcountJeans(){
		WebDriverWait wait = new WebDriverWait(d1,30);
	String count = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productCount"))).getText();
		//String count =		d1.findElement(By.xpath(".//*[@id='productCount']")).getText();
				int expected = Integer.parseInt(count);
		System.out.println("Expected Count "+expected );
		return expected;
	}
	public int count() throws InterruptedException{
		int temp_count = 0;
		boolean itemcheck = true;
		HashMap<Integer,Integer> page = new HashMap<Integer,Integer>();
		int pageno=1;
		int  actualcount=0;
		while(itemcheck)
		
		{
			//i=i+1;
			Thread.sleep(5000);	

		List<WebElement> items = d1.findElements(By.xpath("//ul[@class='thumbnails large-block-grid-3 csg_v1']/li[@class='productThumbnail borderless']"));
		temp_count = items.size();
		System.out.println("temp_count" +temp_count);
		page.put(pageno, temp_count);
		System.out.println(page.get(pageno));
		//actualcount=page.get(pageno)+temp_count;
		actualcount= actualcount+page.get(pageno);
		
				try{
			d1.findElement(By.xpath("//a[@class='arrowRight arrowButton paginationSpacer']")).click();
			pageno=pageno+1;
					}
		catch (Exception e)
		{
			itemcheck = false;
		}
		} 		
		int actual = actualcount;
		return actual;
	}

}
