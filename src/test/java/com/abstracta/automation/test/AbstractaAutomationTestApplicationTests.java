package com.abstracta.automation.test;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.abstracta.automation.test.pages.CartPage;
import com.abstracta.automation.test.pages.HomePage;
import com.abstracta.automation.test.pages.ProductPage;
import com.abstracta.automation.test.util.ScreenshotUtil;

@ContextConfiguration(classes = AbstractaAutomationTestApplicationTests.class)
@SpringBootTest
public class AbstractaAutomationTestApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(AbstractaAutomationTestApplicationTests.class);

	static WebDriver driver;
	ScreenshotUtil screenshotUtil;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/src/test/resources/chromedriver"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testAddRemoveProduct() throws InterruptedException {


		
		ScreenshotUtil screenshotUtil = new ScreenshotUtil(driver);

		driver.get("https://opencart.abstracta.us/");

		HomePage homePage = new HomePage(driver);
		
		ScreenshotUtil.takeScreenshot("home");
		
		homePage.searchForProduct("iPhone");

		ProductPage productPage = homePage.selectFirstProduct();
		productPage.addToCart();
		
		ScreenshotUtil.takeScreenshot("product-page");

		Thread.sleep(5000);

		CartPage cartPage = productPage.goToCart();
		cartPage.viewCart();
		
		ScreenshotUtil.takeScreenshot("cart-iphone");		

		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.linkText("iPhone")).getText().toString(),("iPhone"));
		
		cartPage.removeProductFromCart();
		Thread.sleep(5000);
		assertTrue(cartPage.isCartEmpty());
		
		ScreenshotUtil.takeScreenshot("cart-void");
	}
}