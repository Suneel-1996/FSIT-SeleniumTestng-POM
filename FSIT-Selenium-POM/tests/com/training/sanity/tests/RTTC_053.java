package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RetailUpSkillAdmin_053;
import com.training.pom.RetailUpskillAdmin_052;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_053 {


	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RetailUpSkillAdmin_053 retailUpSkillAdmin_053;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		retailUpSkillAdmin_053 = new RetailUpSkillAdmin_053(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

//	@BeforeMethod
//	public void setUp() throws Exception {
//		driver = DriverFactory.getDriver(DriverNames.CHROME);
//		loginPOM = new LoginPOM(driver); 
//		baseUrl = properties.getProperty("baseURL");
//		screenShot = new ScreenShot(driver); 
//		// open the browser 
//		driver.get(baseUrl);
//	}
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority = 0)
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		
		
		screenShot.captureScreenShot("First");
	}
	
	@Test(priority = 1)
	public void clickOrdersandView() {
		retailUpSkillAdmin_053.clickOrders();
		retailUpSkillAdmin_053.clickOrdersUnderOrdersTab();
		retailUpSkillAdmin_053.clickOrderAction();
	}
	@Test(priority = 2)
	public void genarateIcon() {
		//retailUpSkillAdmin_053.clickGenerateButton();
		String actual=retailUpSkillAdmin_053.invoiceMessage();
		String expected="INV-2019-0032";
		Assert.assertEquals(actual, expected);
	}
	@Test(priority = 3)
	public void orderStatusModification() {
		retailUpSkillAdmin_053.orderStatusDropdown("Complete");
	}
	
	@Test(priority = 4)
	public void addHistoryclick() throws InterruptedException {
		retailUpSkillAdmin_053.clickAddHistoryButton();
		Thread.sleep(3000);
		String actual=retailUpSkillAdmin_053.addHistorySuccessmessage().split("\\r?\\n")[0];
		String expected=" Success: You have modified orders!";
		Assert.assertEquals(actual, expected);
	}
	
	//*[@class='fa fa-shopping-cart fw']
}
