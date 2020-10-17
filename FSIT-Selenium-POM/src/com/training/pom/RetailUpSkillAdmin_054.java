package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RetailUpSkillAdmin_054 {



	private WebDriver driver; 
	
	public RetailUpSkillAdmin_054(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='menu-sale']/a")
	private WebElement salesTabClick;
	
	@FindBy(xpath = "//*[@id='menu-sale']/ul/li[1]/a")
	private WebElement ordersLink;
	
	@FindBy(xpath = "//*[@id='content']/div[1]/div/div/a")
	private WebElement addNew;
	
	@FindBy(id = "input-firstname")
	private WebElement firstName;
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="button-customer")
	private WebElement continueButton;
	
	@FindBy(xpath="//*[@id='tab-cart']/div[1]/table/thead/tr/td[1]")
	private WebElement verifyProductsTab;
	
	@FindBy(id="input-product")
	private WebElement chooseProduct;
	
	@FindBy(id="input-quantity")
	private WebElement productQuantity;
	
	@FindBy(id="button-product-add")
	private WebElement addProductButton;
	
	@FindBy(id="button-cart")
	private WebElement continueAddProduct;
	@FindBy(xpath="//*[@id='order']/li[3]/a")
	private WebElement paymentDetailsTab;
	
	@FindBy(id="input-payment-firstname")
	private WebElement paymentFirstName;
	@FindBy(id="input-payment-lastname")
	private WebElement paymentLastName;
	
	@FindBy(id="input-payment-address-1")
	private WebElement paymentAddress1;
	
	@FindBy(id="input-payment-address-2")
	private WebElement paymentAddress2;
	
	@FindBy(id="input-payment-city")
	private WebElement paymentCity;
	
	@FindBy(id="input-payment-postcode")
	private WebElement paymentPostcode;
	
	@FindBy(id="input-payment-country")
	private WebElement paymentCountryDropdown;
	
	@FindBy(id="input-payment-zone")
	private WebElement paymentState;
	
	@FindBy(id="button-payment-address")
	private WebElement paymentContinue;
	
	@FindBy(xpath = "//*[@id='tab-total']/fieldset/legend")
	private WebElement verifyOrders;
	
	@FindBy(id="input-payment-method")
	private WebElement paymentMethod;
	
	@FindBy(id="button-save")
	private WebElement paymentSave;
	
	public void paymentSave() {
		this.paymentSave.click();
	}
	public void paymentMethod(String paymentMethod) {
		Select paymentDropdown= new Select(this.paymentMethod);
		paymentDropdown.selectByVisibleText(paymentMethod);
	}
	
	
	public boolean verifyOrderDetails() {
		return this.verifyOrders.isDisplayed();
	}
	
	
	public void clickPaymentContinue() {
		this.paymentContinue.click();
	}
	
	public void paymentState(String state) {
		Select stateDropdown= new Select(this.paymentState);
		stateDropdown.selectByVisibleText(state);
		
	}
	
	
	public void paymentCountryDropdown(String country) {
		Select countryDropdown = new Select(this.paymentCountryDropdown);
		countryDropdown.selectByVisibleText(country);
	}
	
	public void paymentPostcode(String postcode) {
		this.paymentPostcode.sendKeys(postcode);
	}
	
	
	public void paymentCityTextbox(String city) {
		this.paymentCity.sendKeys(city);
	}
	
	public void paymentAddress2(String address2) {
		this.paymentAddress2.sendKeys(address2);
	}
	
	public void paymentAddress1(String address1) {
		this.paymentAddress1.sendKeys(address1);
	}
	
	public void paymentLastnameTextbox(String lastName) {
		this.paymentLastName.sendKeys(lastName);
	}
	
	public void paymentFirstnameTextbox(String firstName) {
		this.paymentFirstName.sendKeys(firstName);
	}
	public boolean verifyPaymentDetialsTab() {
		return this.paymentDetailsTab.isEnabled();
	}
	
	public void clickContinueAddProduct() {
		this.continueAddProduct.click();
	}
	
	public void clickAddProductButton() {
		this.addProductButton.click();
	}
	
	public void inputProductQunatity(String quantity) {
		this.productQuantity.clear();
		this.productQuantity.sendKeys(quantity);
	}
	
	public void chooseProdcutsTextbox(String chooseProductValue) {
		this.chooseProduct.clear();
		this.chooseProduct.sendKeys(chooseProductValue);
	}
	public String verifyProdcutsTab() {
		return this.verifyProductsTab.getText();
	}
	
	
	public void clickContinueButton() {
		this.continueButton.click();
	}
	
	public void telephoneTextbox(String phoneNumber) {
		
		this.telephone.sendKeys(phoneNumber);
	}
	
	public void emailIdTextBox(String email) {
		this.email.sendKeys(email);
	}
	
	public void firstNameTextBox(String firstName) {
		this.firstName.sendKeys(firstName);
	}
	
	
	public void clickAddNew() {
		this.addNew.click();
	}
	
	public void clickOrdersLink() {
		this.ordersLink.click();
	}
	
	public void clickSalesTab() {
		this.salesTabClick.click();
	}


	public void lastNameTextBox(String lastName) {
		// TODO Auto-generated method stub
		this.lastName.sendKeys(lastName);
	}
}
