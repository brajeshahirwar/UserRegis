package com.newtours.ntur.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.newtours.ntur.base.TestBase;

public class FlightDetailsPage extends TestBase{

	@FindBy(xpath=".//form[@name='findflight']/table/tbody/tr[1]/td[1]/font/font/b/font/font")
	WebElement lable_flightDetails;
	
	
	  
	
	//Initializing the Page Objects:
		public FlightDetailsPage(){
			PageFactory.initElements(driver, this);
		}
	
		
		public String validateFlightDetails()
		{
			
			return lable_flightDetails.getText();
		
		}
		
}
