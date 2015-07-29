package amazontest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestShopByDept {
	
	WebDriver driver= new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
	        driver.get("https://www.amazon.com");
	        driver.findElement(By.linkText("Sign in")).click();
	        driver.findElement(By.id("ap_email")).sendKeys("lah135@pitt.edu");
		driver.findElement(By.id("ap_password")).sendKeys("umc6080");
		driver.findElement(By.id("signInSubmit-input")).click();
	}

//	Given I¡¯m signed in and there is no item in my shopping cart,
//  When I click "Shop By Department" and find the visible itemlist template,
//	and click "Books & Audible" and find "Children's Books" and click it,
//  and click "Ages 3-5 Years Old" in the new page,
//  and click "Edit's Picks" in the new page,
//  and click "Bob and Flo" in the new page,
//  Then I see the product details for the book ¡°Bob and Flo¡± displayed on the new page	

	@Test
	public void test() {
		driver.findElement(By.id("nav-link-shopall")).click();
		WebElement temp = driver.findElement(By.xpath("//div[@class='nav-template nav-flyout-content nav-tpl-itemList']/div"));
		WebElement pbk = temp.findElement(By.xpath("//span[contains(@class,'nav-text') and .//text()='Books & Audible']"));
		pbk.click();		
		WebElement tt = driver.findElement(By.xpath("//*[@id='nav-flyout-shopAll']/div[3]/div[9]/div[1]/a[3]/span"));		   
		tt.click();
		driver.findElement(By.linkText("Ages 3-5 Years Old")).click();
		WebElement et = driver.findElement(By.linkText("Editors' Picks"));
		et.click();
                WebElement bk1 = driver.findElement(By.linkText("Bob and Flo"));
		bk1.click();
		
		try
		{	
		WebElement title = driver.findElement(By.id("productTitle"));
		String str = title.getText();
		assertTrue(str.contains("Bob and Flo"));
		} catch (NoSuchElementException nseex) {
		fail();			
		} 
	}

}
