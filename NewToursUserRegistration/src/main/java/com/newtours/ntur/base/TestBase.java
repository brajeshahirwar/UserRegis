package com.newtours.ntur.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.newtours.ntur.util.TestUtil;
import com.newtours.ntur.util.WebEventListener;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/newtours"
					+ "/ntur/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void initialization() throws InterruptedException{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			String driverPath  = System.getProperty(("user.dir"))+"\\drivers\\chrome\\win_chromedriver.exe";
        	System.out.println(driverPath);
        	System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("ie")){
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        	capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        	capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        	capabilities.setCapability("allow-blocked-content", true);
        	capabilities.setCapability("allowBlockedContent", true);
        	String driverPath  = System.getProperty(("user.dir"))+"\\drivers\\ie\\win64_IEDriverServer.exe";
        	System.setProperty("webdriver.ie.driver", driverPath);
        	driver = new InternetExplorerDriver(capabilities);
		}
		else if(browserName.equals("FF"))
		{
			String driverPath  = System.getProperty(("user.dir"))+"\\drivers\\gecko\\win64_geckodriver.exe";
        	System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			Thread.sleep(5000);
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	

}
