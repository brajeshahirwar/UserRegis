package com.newtours.NewToursUserRegistration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newtours.ntur.base.TestBase;
import com.newtours.ntur.pages.FlightDetailsPage;
import com.newtours.ntur.pages.HomePage;
import com.newtours.ntur.pages.NewUserRegisPage;
import com.newtours.ntur.pages.SignInPage;
import com.newtours.ntur.pages.SignOnPage;
import com.newtours.ntur.util.TestUtil;


public class NewUserRegistrationTest extends TestBase{
	HomePage homepage;
	NewUserRegisPage regisPage;
	SignInPage signIn;
	SignOnPage signOn;
	FlightDetailsPage flightDetails;
	public static final String homepagetitle= "Welcome: Mercury Tours";
	String singleuser = "singleuser";
	String multipleuser = "multipleuser";
	
	public NewUserRegistrationTest(){
		super();
	}
	
   @BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		homepage = new HomePage();	
		regisPage = new NewUserRegisPage();
		signIn = new SignInPage();
		signOn = new SignOnPage();
		flightDetails = new FlightDetailsPage(); 
		String homePageTitle = homepage.verifyUserRegistrationPageTitle();
		Assert.assertEquals(homePageTitle, homepagetitle,"Expected title ["+homepagetitle+"] but found ["+homePageTitle+"]");
		regisPage=homepage.clickonRegister();
			
	}
	
	@DataProvider
	public Object[][] singleuserregistration(){
		Object data[][] = TestUtil.getTestData(singleuser);
		return data;
	}
	@DataProvider
	public Object[][] multipleuserregistration(){
		Object data[][] = TestUtil.getTestData(multipleuser);
		return data;
	}
	
	@Test(priority=1, dataProvider="singleuserregistration", description = "Test script validate new user registration, login and fligh details section")
	public void singleuserregistration(String firstName, String lastName, String phone, String email,String address1,
			String address2, String city, String state, String postalCode, String country,
			String userName,String password, String confirmPassword
			) throws InterruptedException{
		   regisPage.newuserRegistration(firstName, lastName, phone, email, address1, address2, city, state, postalCode, country, userName, password, confirmPassword);
		   String actualUserName = signIn.validateUser().trim();
		   Assert.assertEquals(actualUserName, userName,"Expected user ["+userName+"] but found ["+actualUserName+"]");
		   signIn.clickonSignIn();
		   signOn.userlogin(userName, password);
		   signOn.clickonSubmit();
		   String exp_flightDetails= "Flight Details";
		   Assert.assertEquals(flightDetails.validateFlightDetails(), exp_flightDetails,"Flight Details Section is not displayed]");
		  
		   
	  
	}
	
	@Test(priority=2, dataProvider="multipleuserregistration", description = "Test script validate new user registration, login and fligh details section")
	public void multipleuserregistration(String firstName, String lastName, String phone, String email,String address1,
			String address2, String city, String state, String postalCode, String country,
			String userName,String password, String confirmPassword
			) throws InterruptedException{
		   regisPage.newuserRegistration(firstName, lastName, phone, email, address1, address2, city, state, postalCode, country, userName, password, confirmPassword);
		   String actualUserName = signIn.validateUser().trim();
		   Assert.assertEquals(actualUserName, userName,"Expected user ["+userName+"] but found ["+actualUserName+"]");
		   signIn.clickonSignIn();
		   signOn.userlogin(userName, password);
		   signOn.clickonSubmit();
		   String exp_flightDetails= "Flight Details";
		   Assert.assertEquals(flightDetails.validateFlightDetails(), exp_flightDetails,"Flight Details Section is not displayed]");
		  
		   
	  
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
