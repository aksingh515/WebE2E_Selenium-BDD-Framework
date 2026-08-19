package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver ;
	WebDriverWait wait ;

	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver ;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Explicit Wait
		public void waiForElementToAppear(By findBy)
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		}
		
		public void waitForElementToVisible(WebElement ele)
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
		
		public void waitForElementToBeClickable(WebElement ele)
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
		
		public void waitForUrlContains(String url) {
	        wait.until(ExpectedConditions.urlContains(url));
	    }
		
}
