package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailUpskillAdmin_052 {

	private WebDriver driver; 
	
	public RetailUpskillAdmin_052(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu-customer")
	private WebElement menuCustomer; 
	
	@FindBy(xpath="//*[@id='menu-report']/a")
	private WebElement reportsIcon;
	
	@FindBy(xpath="/*[@id='menu-customer']/ul/li")
	private WebElement menuCustomerItems;
	
	@FindBy(xpath="//*[@id='menu-customer']/ul/li[1]")
	private WebElement customersLink;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//*[@id='content']/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id='form-customer']/div/table/tbody/tr[1]/td[8]/a/i")
	private WebElement customerEdit;
	
	@FindBy(id="input-firstname")
	private WebElement firstNameTextbox;
	
	@FindBy(xpath="//*[@id='address']/li[2]/a")
	private WebElement address1;
	
	@FindBy(xpath="//*[@id='input-firstname1']")
	private WebElement address1FirstName;

	@FindBy(id="input-postcode1")
	private WebElement postcode;
	
	@FindBy(xpath="//*[@id='form-customer']/ul/li[4]/a")
	private WebElement rewardPointsTab;
	
	@FindBy(id="input-reward-description")
	private WebElement rewardDescription;
	
	@FindBy(id="input-points")
	private WebElement inputPoints;
	
	
	@FindBy(id="button-reward")
	private WebElement addReward;
	
	@FindBy(xpath="//*[@id='content']/div[1]/div/div/button")
	private WebElement save;
	
	@FindBy(xpath="//*[@id='tab-reward']/div[1]")
	private WebElement rewardSuccess;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div[1]")
	private WebElement saveSuccess;
	
	@FindBy(xpath="//*[@id='menu-report']/ul/li[3]/a")
	private WebElement reportCustomerButton;
	
	@FindBy(xpath="//*[@id='menu-report']/ul/li[3]/ul/li[5]/a")
	private WebElement reportsCustomerRewardPoints;
	
	
	public void clickRewardPointsFromReports() {
		this.reportsCustomerRewardPoints.click();
	}
	//@FindBy(xpath="//*[@id='menu-report']/ul/li[3]/ul")
	
	
	public void clickCustomerReport() {
		this.reportCustomerButton.click();
	}
	
	public void clickReportsIcon() {
		this.reportsIcon.click();
	}
	
	
	public String saveSuccessMessage() {
		return this.saveSuccess.getText();
	}
	
	public String rewardSuccessMessage() {
		return this.rewardSuccess.getText();
	}
	
	
	
	public void clickOnSave() {
		this.save.click();
	}
	
	public void addRewardButton() {
		this.addReward.click();
	}
	
	
	
	
	
	
	public void inputPointsSendKeys(String rewardInputPoints) {
		this.inputPoints.sendKeys(rewardInputPoints);
	}
	
	public void enterRewardDescription(String rewardDescription) {
		this.rewardDescription.sendKeys(rewardDescription);
	}
	
	
	public void clickRewardPointsTab(){
		this.rewardPointsTab.click();
	}
	
	
	public void postCodeSendKeys(String postalCode) {
		this.postcode.clear();
		this.postcode.sendKeys(postalCode);
	}
	
	public String address1FirstNameText() {
		return this.address1FirstName.getText();
	}
	
	
	public void addressBarClick() {
		this.address1.click();
	}
	
	public void firstNameTextBoxClear() {
		this.firstNameTextbox.clear();
	}
	
	public void firstNameTextBoxSendKeys(String name) {
		firstNameTextbox.clear();
		this.firstNameTextbox.sendKeys(name);
	}
	
	public void clickCustomerEdit() {
		this.customerEdit.click();
	}
	
	public void clickCustomerLink() {
		this.customersLink.click();
	}
	
	public void clickMenuCustomer() {
		
		this.menuCustomer.click();
	}
	
	public void menuCustomerItemList() {
		
	}
	//*[@id="menu-customer"]/ul
//	public void sendUserName(String userName) {
//		this.userName.clear();
//		this.userName.sendKeys(userName);
//	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

}
