package utils;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;

import pomPages.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver ;
	public HashMap<String, String> data;
	public PageObjectManager pageObjectManager;
	
	public TestContextSetup() 
	{
		driver = DriverFactory.getDriver();
		pageObjectManager = new PageObjectManager(driver);
	}

}
