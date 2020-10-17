package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RetailUpskillAdmin_052;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RetailUpskillAdmin_052 retailUpskillAdmin_052;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		retailUpskillAdmin_052 = new RetailUpskillAdmin_052(driver);
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
	public void clickOnCustomerIcon() {
		retailUpskillAdmin_052.clickMenuCustomer();
		WebElement customermenu= driver.findElement(By.xpath("//*[@id='menu-customer']/ul"));
		List<WebElement> menuList = customermenu.findElements(By.tagName("li"));
		List<String> checkList= new ArrayList<String>();
		checkList.add("Customers");
		checkList.add("Customer Groups");
		checkList.add("Custom Fields");
		System.out.println(menuList.size());
//		for(WebElement e:menuList) {
//			System.out.print(e.getText()+",");
//		}
		int i=0;
		int passedCounts=0;
		for(WebElement cl:menuList) {
			
			if(checkList.contains(cl.getText())) {
				passedCounts+=1;
			}
			else {
				
			}
			i+=1;
				
		}
		//Assert.assertEquals(actual, expected);
		Assert.assertEquals(passedCounts, checkList.size());
	}
	@Test(priority=2)
	public void clickOnCustomerLink() {
		retailUpskillAdmin_052.clickCustomerLink();
	}
	
	@Test(priority =3)
	public void clickEditIconOfCustomer() {
		retailUpskillAdmin_052.clickCustomerEdit();
	}
	
	@Test(priority = 4)
	public void clearFirstNameTextBoxClear() {
		retailUpskillAdmin_052.firstNameTextBoxClear();
	}
	//
	
	
	
	@Test(priority = 5)
	public void clearFirstNameTextBoxSendKeys() {
		retailUpskillAdmin_052.firstNameTextBoxSendKeys("Asmita");
	}
	
	@Test(priority = 6)
	public void clickAddressTab() {
		retailUpskillAdmin_052.addressBarClick();
	}
	@Test(priority =7)
	public void sendKeysPostCode() {
		retailUpskillAdmin_052.postCodeSendKeys("8796545");
	}
	
	@Test(priority = 8)
	public void rewardsPointsTabClick() {
		retailUpskillAdmin_052.clickRewardPointsTab();
	}
	
	@Test(priority = 9)
	public void descriptionTextBox() {
		retailUpskillAdmin_052.enterRewardDescription("review");
	}
	
	@Test(priority = 10)
	public void pointsTextBox() {
		retailUpskillAdmin_052.inputPointsSendKeys("50");
	}
	
	@Test(priority = 11)
	public void addRewards() throws InterruptedException
	{
		retailUpskillAdmin_052.addRewardButton();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		String actual=retailUpskillAdmin_052.rewardSuccessMessage().split("\\r?\\n")[0];
		System.out.println(actual);
		String expected="Success: You have modified customers!";
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 12)
	public void saveButton() {
		retailUpskillAdmin_052.clickOnSave();
		String actual=retailUpskillAdmin_052.saveSuccessMessage().split("\\r?\\n")[0];
		//System.out.println(actual);
		String expected="Success: You have modified customers!";
	Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 13)
	public void reportsIcon() {
		retailUpskillAdmin_052.clickReportsIcon();
		retailUpskillAdmin_052.clickCustomerReport();
		WebElement reportListElement= driver.findElement(By.xpath("//*[@id='menu-report']"));
		List<WebElement> reportList=reportListElement.findElements(By.tagName("li").className("parent"));
		
		List<String> expected=new ArrayList<String>();
		expected.add("Sales");
		expected.add("Products");
		expected.add("Customers");
		int i=0;
		int passedCounts=0;
		
		//List<String> checker= new ArrayList<String>();
		
		for(WebElement e:reportList) {
			//checker.add(e.getText());
			if (expected.contains(e.getText())) {
				
				passedCounts+=1;
			} 
		}
		
//		boolean val=checker.containsAll(expected);
//		Assert.assertEquals(val, true);
		Assert.assertEquals(passedCounts, expected.size());
	}
	
	@Test(priority = 14)
	public void reportCustomersLink() {
		//retailUpskillAdmin_052.clickCustomerReport();
		WebElement listOptions = driver.findElement(By.xpath("//*[@id='menu-report']/ul/li[3]/ul"));
		List<WebElement> list=listOptions.findElements(By.tagName("li"));
//		for(WebElement e:list) {
//			System.out.println(e.getText());
//		}
		List<String> expected1=new ArrayList<String>();
		expected1.add("Customers Online");
		expected1.add("Orders");
		expected1.add("Reward Points");
		for(WebElement e:list) {
			System.out.print(e.getText()+",");
		}
		int i=0;
		int passedCounts=0;
		System.out.println(list.size());
		for(WebElement e:list) {
			
			if (expected1.contains(e.getText())) {
				
				passedCounts+=1;
			} 
			i+=1;
		}
		Assert.assertEquals(passedCounts, expected1.size());
	}
	@Test(priority = 15)
	public void clickRewardPointsFromReports() {
		retailUpskillAdmin_052.clickRewardPointsFromReports();
	}
}
