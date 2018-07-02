package com.Data.SonuDataDriven.TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Data.SonuDataDriven.exceldata.Excel.Xls_Reader;

public class RegistrationPage{
	WebDriver driver;
	
	@Test
	
	public void regestration() {
		
	
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		
		
		
		Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+"/ExcelData.xlsx");
		
	int rowcount =	excel.getRowCount("Lahari");
	
	for(int row =2;row<=rowcount;row++) {
		
		String first =excel.getCellData("Lahari","username", row);
		System.out.println(first);
		
		String pass = excel.getCellData("Lahari", "password", row);
		System.out.println(pass);
		driver.findElement(By.name("firstname")).sendKeys(first);

	
	}
		
	
	}

}
