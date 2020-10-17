package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RetailUpSkillAdmin_053 {


	private WebDriver driver; 
	
	public RetailUpSkillAdmin_053(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='fa fa-shopping-cart fw']")
	private WebElement ordersTab; 
	
	@FindBy(xpath = "//*[@id='menu-sale']/ul/li[1]/a")
	private WebElement ordersUnderOrdersTab;
	
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr[1]/td[8]/a[1]")
	private WebElement orderAction;
	
	@FindBy(xpath="//*[@id='button-invoice']")
	private WebElement generateButton;
	
	@FindBy(xpath = "//*[@id='invoice']")
	private WebElement invoiceMessageId;
	
	@FindBy(xpath = "//*[@id='input-order-status']")
	private WebElement orderStatusDropdown;
	
	@FindBy(xpath = "//*[@id='button-history']")
	private WebElement addHistoryButton;
	
	@FindBy(xpath = "//*[@id='tab-history']/div[1]")
	private WebElement addHistorySuccessMessage;
	
	public String addHistorySuccessmessage() {
		return this.addHistorySuccessMessage.getAttribute("innerText");
	}
	
	
	public void clickAddHistoryButton() {
		this.addHistoryButton.click();
	}
	
	public void orderStatusDropdown(String select) {
		
		Select dropdown= new Select(this.orderStatusDropdown);
		//dropdown.selectByValue(select);
		dropdown.selectByVisibleText(select);
		
	}
	
	public String invoiceMessage() {
		return this.invoiceMessageId.getText();
	}
	
	public void clickGenerateButton() {
		this.generateButton.click();
	}
	
	public void clickOrderAction() {
		this.orderAction.click();
	}
	
	public void clickOrdersUnderOrdersTab() {
		this.ordersUnderOrdersTab.click();
	}

	public void clickOrders() {
		this.ordersTab.click();
	}
	
	

}
