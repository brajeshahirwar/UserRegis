package com.newtours.ntur.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtours.ntur.base.TestBase;

public class SignOnPage extends TestBase{

	@FindBy(name = "userName")
	WebElement input_userName;

	@FindBy(name = "password")
	WebElement input_password;

	@FindBy(name = "login")
	WebElement button_submit;

	// Initializing the Page Objects:
	public SignOnPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public void clickonSubmit() {
		button_submit.click();
	}

	public void userlogin(String username, String password) {
		
		input_userName.sendKeys(username);
		input_password.sendKeys(password);
		/*input_userName.click();        	
		input_userName.sendKeys(Keys.CONTROL + "a");
		input_userName.sendKeys(username);
		input_userName.sendKeys(Keys.TAB);
		
		input_password.click();        	
		input_password.sendKeys(Keys.CONTROL + "a");
		input_password.sendKeys(password);
		input_password.sendKeys(Keys.TAB);*/
		
		

	}

}
