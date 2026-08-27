package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void setup()
	{
		DriverFactory.initDriver();
		DriverFactory.getDriver().get("https://www.saucedemo.com/");
	}

	@After
	public void tearDown()
	{
		DriverFactory.quitDriver();
	}
	
	
	// add Screenshot on failure
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException
	{	
		if(scenario.isFailed())
		{
			File sourcePath = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "testImage");
		}
		
	}
	
	
}
