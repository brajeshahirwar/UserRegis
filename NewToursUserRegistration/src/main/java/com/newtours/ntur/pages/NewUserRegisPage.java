package com.newtours.ntur.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.newtours.ntur.base.TestBase;



public class NewUserRegisPage extends TestBase {

	@FindBy(name = "firstName")
	@CacheLookup
	WebElement inputbox_firstName;

	@FindBy(name = "lastName")
	WebElement inputbox_lastName;
	
	@FindBy(name = "phone")
	WebElement inputbox_phone;
	
	@FindBy(id = "userName")
	WebElement inputbox_email;
	
	@FindBy(name = "address1")
	WebElement inputbox_address1;
	
	@FindBy(name = "address2")
	WebElement inputbox_address2;
	
	@FindBy(name = "city")
	WebElement inputbox_city;
	
	@FindBy(name = "state")
	WebElement inputbox_state;
	
	@FindBy(name = "postalCode")
	WebElement inputbox_postalCode;
	
	@FindBy(name = "country")
	WebElement inputbox_country;
	
	@FindBy(name = "email")
	WebElement inputbox_username;
	
	@FindBy(name = "password")
	WebElement inputbox_password;
	
	@FindBy(name = "confirmPassword")
	WebElement inputbox_confirmpassword;
	
	
	
	@FindBy(name = "register")
	WebElement button_register;
	
	@FindBy(xpath=".//*[contains(text(),'REGISTER')]")
	WebElement link_Register;
	
	String sheetName = "userdetails";
	// Initializing the Page Objects:
	public NewUserRegisPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	 
	
	
	public void newuserRegistration(String firstName, String lastName, String phone, String email,String address1,
			String address2, String city, String state, String postalCode, String country,
			String userName,String password, String confirmPassword) throws InterruptedException
	{
		
		 inputbox_firstName.sendKeys(firstName);

		 inputbox_lastName.sendKeys(lastName);
		
		 inputbox_phone.sendKeys(phone);
		 inputbox_email.sendKeys(email);
		
		 inputbox_address1.sendKeys(address1);
		
	     inputbox_address2.sendKeys(address2);
		
		 inputbox_city.sendKeys(city);
		
		 inputbox_state.sendKeys(state);
		
		 inputbox_postalCode.sendKeys(postalCode);
		 inputbox_country.click();
		 
		 new Select(driver.findElement(By.name("country"))).selectByValue("92"); 
		 Thread.sleep(1000);
	      inputbox_username.sendKeys(userName);
	      inputbox_password.sendKeys(password);
	      inputbox_confirmpassword.sendKeys(confirmPassword);
		
	      button_register.click();
		
	}
	
	
		
	
}
	
	
	
	
	


