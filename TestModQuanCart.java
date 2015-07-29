package amazontest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestModQuanCart {

	    WebDriver driver= new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
	    driver.get("https://www.amazon.com");
	    driver.findElement(By.linkText("Sign in")).click();
	    driver.findElement(By.id("ap_email")).sendKeys("lah135@pitt.edu");
	    driver.findElement(By.id("ap_password")).sendKeys("umc6080");
	    driver.findElement(By.id("signInSubmit-input")).click();
	}
	
// Given I'm logged in and there is one item in my shopping cart,
// When I click the button "Cart" and see the new page,
// and I click the dropdown list under Quantity,
// and I choose the number "3" and click it,
// Then I see the quantity in my shopping cart is updated.
	
	@Test
	public void testModifyQuantity1() {
	    driver.findElement(By.id("nav-cart")).click();
	    driver.findElement(By.id("a-autoid-2-announce")).click();
	    driver.findElement(By.id("dropdown1_2")).click();
	    driver.findElement(By.id("nav-cart")).click();
		
	    try {
	    WebElement el = driver.findElement(By.id("nav-cart-count"));
	    String msg = el.getText();
	    assertTrue(msg.contains("3"));
	    } catch(NoSuchElementException nseex) {
	    fail();			
	    }				
	}
	
// Given I'm logged in and there are three items in my shopping cart,
// When I click the button "Cart" and see the new page,
// and I click the dropdown list under Quantity,
// and I choose the number "10+" and click it,
// and I enter the number "20" and click the button "Update",
// Then I see the quantity in my shopping cart is updated.	

	@Test
	public void testModifyQuantity2() {
	    driver.findElement(By.id("nav-cart")).click();
	    driver.findElement(By.id("a-autoid-2-announce")).click();
	    driver.findElement(By.id("dropdown1_9")).click();
	    driver.findElement(By.name("quantityBox")).sendKeys("20");
	    driver.findElement(By.id("a-autoid-3-announce")).click();
	    driver.findElement(By.id("nav-cart")).click();
		
	    try {
	    WebElement el = driver.findElement(By.id("nav-cart-count"));
	    String msg = el.getText();
	    assertTrue(msg.contains("20"));
	    } catch(NoSuchElementException nseex) {
	    fail();			
	   }				
	}
	
}
