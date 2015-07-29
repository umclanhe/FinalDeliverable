package amazontest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestAddDeleteAddItem {
	
            WebDriver driver= new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
	    driver.get("https://www.amazon.com");
	    driver.findElement(By.linkText("Sign in")).click();
	    driver.findElement(By.id("ap_email")).sendKeys("lah135@pitt.edu");
	    driver.findElement(By.id("ap_password")).sendKeys("umc6080");
	    driver.findElement(By.id("signInSubmit-input")).click();
	}
	
// Given I'm logged in and there is no item in the cart,
// When I choose the option of dropdown list ¡°Books¡±,
// and enter the book name ¡°the little prince¡±,
// and click the button ¡°search¡±,
// and see the search result page and I click "The Little Prince",
// I see the product detail page for "The Little Prince" and click "Add to Cart" button,
// I see a updated page and click the button "Cart",
// I see the book "The Little Prince" in the cart and I click the button "Delete" under the book,
// I see the update information on the shopping cart and I click the link for "The Little Prince",
// I go back to the product detail page for "The Little Prince" and click the button "Add to Cart" again,
// Then I see the confirmation message in the new page of cart information.	

	@Test
	public void test() {
		Select dropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
		dropdown.selectByValue("search-alias=stripbooks");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("the little prince ");
		WebElement schdiv = driver.findElement(By.cssSelector("#nav-search .nav-search-submit .nav-input"));
		schdiv.click();
		WebElement lk = driver.findElement(By.linkText("The Little Prince"));
		lk.click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("hlb-view-cart-announce")).click();
		WebElement dt = driver.findElement(By.xpath(".//*[@id='activeCartViewForm']/div[2]/div/div[4]/div[2]/div[1]/div/div/div[2]/div/span[1]/span/input"));
		dt.click();
		driver.findElement(By.linkText("The Little Prince")).click();
		driver.findElement(By.className("a-button-input")).click();
		
		try {
		WebElement el = driver.findElement(By.id("huc-v2-order-row-confirm-text"));
		String st = el.getText();
		assertTrue(st.contains("Added to Cart"));			
		} catch(NoSuchElementException nseex) {
		fail();
		}
	}

}
