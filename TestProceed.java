package amazontest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestProceed {
	    
	    WebDriver driver= new FirefoxDriver();
		
	@Before
	public void setUp() throws Exception {
	        driver.get("https://www.amazon.com");
	        driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("ap_email")).sendKeys("lah135@pitt.edu");
	        driver.findElement(By.id("ap_password")).sendKeys("umc6080");
		driver.findElement(By.id("signInSubmit-input")).click();
		}
	
// Given I'm logged in and there are 5 items in my shopping cart,
// When I click the button "Cart",
// and I see the new page and click the button "Proceed to Checkout",
// and I see the new page and click the button "Continue",
// Then I see the error message in the updated page.
	
	@Test
	public void testCheckout1() {
		driver.findElement(By.id("nav-cart")).click();
		driver.findElement(By.name("proceedToCheckout")).click();
		driver.findElement(By.name("shipToThisAddress")).click();
		
		try {
		WebElement me = driver.findElement(By.xpath(".//*[@id='addressIMB']/div/h4"));
		String mst = me.getText();
		assertTrue(mst.contains("Important Message"));			
		} catch(NoSuchElementException nseex) {
		fail();			
		}		
	}
	
// Given I'm logged in and there are 5 items in my shopping cart,
// When I click the button "Cart",
// and I see the new page and click the button "Proceed to Checkout",
// and I see the new page and I fill in the required forms,
// and I click the button "Continue",
// and I see the new page and I select "original address" and click "Ship to this address",
// Then I see the delivery options in the updated page.
	
	@Test
	public void testCheckout2() {
		driver.findElement(By.id("nav-cart")).click();
		driver.findElement(By.name("proceedToCheckout")).click();
		driver.findElement(By.id("enterAddressFullName")).sendKeys("Su Juan");
		driver.findElement(By.id("enterAddressAddressLine1")).sendKeys("135 N Bellefield Ave");
		driver.findElement(By.id("enterAddressCity")).sendKeys("Pittsburgh");
		driver.findElement(By.id("enterAddressStateOrRegion")).sendKeys("PA");
		driver.findElement(By.id("enterAddressPostalCode")).sendKeys("15260");
		driver.findElement(By.id("enterAddressPhoneNumber")).sendKeys("412-624-5230");
		driver.findElement(By.name("shipToThisAddress")).click();
		driver.findElement(By.name("addr")).click();
		driver.findElement(By.name("useSelectedAddress")).click();		
		
		try {
		WebElement mt = driver.findElement(By.xpath(".//*[@id='shippingOptionFormId']/div[2]/div/div[2]/div/div[1]/h3"));
		String st = mt.getText();
		assertTrue(st.contains("Choose a delivery option:"));			
		} catch(NoSuchElementException nseex) {
		fail();			
		}		
	}

}
