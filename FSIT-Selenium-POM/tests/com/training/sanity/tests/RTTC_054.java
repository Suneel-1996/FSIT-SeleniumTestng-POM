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
import com.training.pom.RetailUpSkillAdmin_054;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_054 {



	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RetailUpSkillAdmin_054 retailUpSkillAdmin_054;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		retailUpSkillAdmin_054 = new RetailUpSkillAdmin_054(driver);
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
	public void salesIcon() {
		retailUpSkillAdmin_054.clickSalesTab();
		List<String> salesOptions = new ArrayList<String>();
		salesOptions.add("Orders");
		salesOptions.add("Recurring Profiles");
		salesOptions.add("Returns");
		salesOptions.add("Gift Vouchers");
		WebElement salesDropDown=driver.findElement(By.xpath("//*[@id='menu-sale']/ul"));
		List<WebElement> salesLinkOptions=salesDropDown.findElements(By.tagName("li"));
		int passedCount=0;
		
		for(WebElement e: salesLinkOptions) {
			
			if(salesOptions.contains(e.getText())) {
				
			passedCount+=1;	
			}
		}
		Assert.assertEquals(salesOptions.size(), passedCount);
	}
	
@Test(priority = 2)
public void clickOrdersLink() {
	retailUpSkillAdmin_054.clickOrdersLink();
}

@Test(priority = 3)
public void addNewClick() {
	retailUpSkillAdmin_054.clickAddNew();
}

@Test(priority = 4)
public void firstNameTextBox() {
	retailUpSkillAdmin_054.firstNameTextBox("manzoor");
}

@Test(priority = 5)
public void lastNameTextBox() {
	retailUpSkillAdmin_054.lastNameTextBox("mehadi");
}

@Test(priority = 6)
public void emailTextBox() {
	retailUpSkillAdmin_054.emailIdTextBox("manzoor@gmail.com");
}

@Test(priority = 7)
public void telephoneTextBox() {
	retailUpSkillAdmin_054.telephoneTextbox("9876543210");
}

@Test(priority = 8)
public void continueButtonClick() throws InterruptedException {
	retailUpSkillAdmin_054.clickContinueButton();
	String expected="Products";
	Thread.sleep(3000);
	String actual=retailUpSkillAdmin_054.verifyProdcutsTab();
}

@Test(priority = 9)
public void chooseProdcutTextBox() {
	retailUpSkillAdmin_054.chooseProdcutsTextbox("Lorem ipsum dolor sit amet");
}

@Test(priority = 10)
public void productQuantity() {
	retailUpSkillAdmin_054.chooseProdcutsTextbox("1");
}

@Test(priority = 11)
public void addProductButton() {
	retailUpSkillAdmin_054.clickAddProductButton();
}
@Test(priority = 12)
public void clickContinueAddProductButton() {
	retailUpSkillAdmin_054.clickContinueAddProduct();
	Assert.assertEquals(retailUpSkillAdmin_054.verifyPaymentDetialsTab(), true);
}

@Test(priority = 13)
public void paymentFirstName() {
	retailUpSkillAdmin_054.paymentFirstnameTextbox("manzoor");
}



@Test(priority = 14)
public void paymentLastName() {
	retailUpSkillAdmin_054.paymentLastnameTextbox("mehadi");
}
@Test(priority = 15)
public void paymentAddress1() {
	retailUpSkillAdmin_054.paymentAddress1("yeshwanthapur");
}
@Test(priority = 16)
public void paymentAddress2() {
	retailUpSkillAdmin_054.paymentAddress2("bangalore");
}
@Test(priority = 17)
public void paymentCity() {
	retailUpSkillAdmin_054.paymentCityTextbox("bangalore");
}
@Test(priority = 18)
public void paymentPostcode() {
	retailUpSkillAdmin_054.paymentPostcode("560022");
}
@Test(priority = 19)
public void paymentCountry() {
	retailUpSkillAdmin_054.paymentCountryDropdown("India");
}

@Test(priority = 20)
public void paymentState() {
	retailUpSkillAdmin_054.paymentState("Karnataka");
}
@Test(priority = 21)
public void paymentContinue() throws InterruptedException {
	retailUpSkillAdmin_054.clickPaymentContinue();
	Thread.sleep(3000);
	boolean actual=retailUpSkillAdmin_054.verifyOrderDetails();
	boolean expected=true;
	Assert.assertEquals(actual, expected);
}

@Test(priority = 22)
public void selectPaymentMethod() {
	retailUpSkillAdmin_054.paymentMethod("Cash on Delivery");
}

@Test(priority = 23)
public void clickSave() {
	retailUpSkillAdmin_054.paymentSave();
}

}
