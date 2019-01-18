package com.newtours.ntur.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtours.ntur.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = ".//*[contains(text(),'REGISTER')]")
	WebElement link_Register;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String verifyUserRegistrationPageTitle() {

		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows.size());

		driver.switchTo().defaultContent();
		return driver.getTitle();
	}

	public NewUserRegisPage clickonRegister() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", link_Register);
		// link_Register.click();
		return new NewUserRegisPage();

	}

}
