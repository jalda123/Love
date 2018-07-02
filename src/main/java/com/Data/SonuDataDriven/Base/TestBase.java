package com.Data.SonuDataDriven.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("broeser")
	public void login(String browser) {
		
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers.geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("https://www.facebook.com/");
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers.chromedriver.exe.exe");
			driver=new ChromeDriver();

		}
		
	}

}
