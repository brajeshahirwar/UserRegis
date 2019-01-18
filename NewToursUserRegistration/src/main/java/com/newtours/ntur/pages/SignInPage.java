package com.newtours.ntur.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.newtours.ntur.base.TestBase;

public class SignInPage extends TestBase{

	@FindBy(xpath = ".//table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[1]/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[1]/p[3]/a/font/b")
	WebElement lable_user;

	@FindBy(xpath = ".//*[contains(text(),'sign-in')]")
	WebElement link_signin;

	// Initializing the Page Objects:
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public void clickonSignIn() {
		link_signin.click();
	}

	public String validateUser() {

		String getLable = lable_user.getText();
		String split[] = getLable.split(" ");
		int size = split.length - 1;
		String userName = split[size].replace(".", "").trim();

		return userName;

	}

}
