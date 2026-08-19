package utils;

import java.util.HashMap;

import pomPages.PageObjectManager;

public class TestContextSetup {
	
	public HashMap<String, String> data;
	public PageObjectManager pageObjectManager;
	
	public TestContextSetup() 
	{
		pageObjectManager = new PageObjectManager(DriverFactory.getDriver());
	}

}
