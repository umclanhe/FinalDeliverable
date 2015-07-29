package amazontest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestMyAccount {
	
        WebDriver driver= new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
	    driver.get("https://www.amazon.com");
	    driver.findElement(By.linkText("Sign in")).click();
	    driver.findElement(By.id("ap_email")).sendKeys("lah135@pitt.edu");
		driver.findElement(By.id("ap_password")).sendKeys("umc6080");
		driver.findElement(By.id("signInSubmit-input")).click();
	}
	
// Given I'm logged in and don't buy any item,
// When I click "Hello,tulipsu Your Account" and see the item-list template,
// and choose "Your Account" to click,
// and see the button "Your Orders" in the new page and click it,
// and see the new page for "Your Orders" and click "Open Orders",
// Then I see the information on "Open Orders" on the updated page.

	@Test
	public void testCountManage() {
	    driver.findElement(By.id("nav-link-yourAccount")).click();
		WebElement mc = driver.findElement(By.xpath(".//*[@id='nav-flyout-yourAccount']/div[2]/a[1]/span"));
		mc.click();
	    driver.findElement(By.linkText("Your Orders")).click();
	    driver.findElement(By.xpath(".//*[@id='orderTypeMenuContainer']/ul/li[3]/span/a")).click();
	    
	    try{
	    WebElement wb = driver.findElement(By.xpath(".//*[@id='ordersContainer']/div[1]/div"));
	    String str = wb.getText();
	    assertTrue(str.contains("Looking for an order? All of your orders have shipped."));
	    	
	    } catch(NoSuchElementException nseex) {
	    fail();	
	    }
		
	}

}
