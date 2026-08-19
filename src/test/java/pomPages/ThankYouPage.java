package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.AbstractComponents;

public class ThankYouPage extends AbstractComponents {

WebDriver driver ;
	
	public ThankYouPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='checkout_complete_container']/h2")
	WebElement thankMsg;
	
	public String getSucessMessage()
	{
		return thankMsg.getText();
	}
}
