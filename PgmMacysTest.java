package SeleniumHandsOn;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PgmMacysTest {
public FirefoxDriver d1;

	@BeforeTest
	public void Browser(){
		System.setProperty("Webdriver.firefox.driver", "geckodriver.exe");
	this.d1 = new FirefoxDriver();
		this.d1.get("https://www.macys.com/"); 
		this.d1.manage().window().maximize();
	}
	@Test(description="SearchJeans",priority=1)
	public void SearchJean(){
		PgmMacysHomepage hpage = new PgmMacysHomepage(this.d1 );
		
		boolean result = hpage.SearchJeans();
		Assert.assertTrue(result);
	}
	
@Test(description="CountJeans", dependsOnMethods={"SearchJean"},priority=2)
	public void CountJeans() throws InterruptedException{
		
		PgmMacysSearchResultPage jcount = new PgmMacysSearchResultPage(d1);
		int expected =  jcount.expectedcountJeans();
		int actual = jcount.count();
		Assert.assertEquals(actual, expected);
	}
	@Test(description="AddtoCart", dependsOnMethods={"SearchJean"},priority=3)	
	public void AddToCart() throws InterruptedException{
		PgmMacysAddToCart Cart = new PgmMacysAddToCart(this.d1);
		boolean check = Cart.AddToCart();
		Assert.assertTrue(check);
	}
	@Test(description="RemoveCart", dependsOnMethods={"SearchJean"},enabled=false,priority=4)
	public void RemoveCart(){
		PgmMacysAddToCart removeCart = new PgmMacysAddToCart(this.d1);
		String actualmessage= removeCart.RemoveCart();
		String expectedmessage = "Removed from bag";
		Assert.assertEquals(actualmessage, expectedmessage); 
	}
	@Test(description="Mandatory Fields", dependsOnMethods={"AddToCart"},priority=5)
		public void MandatoryFields(){
		PgmMacysCheckOutpage chkout = new PgmMacysCheckOutpage(this.d1);
		boolean mandatory= chkout.checkout();
		
		Assert.assertFalse(mandatory);
		
	}
	
}
