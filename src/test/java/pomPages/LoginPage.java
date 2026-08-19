package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.AbstractComponents;

public class LoginPage extends AbstractComponents {
	
	WebDriver driver ;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginBtn;
	
	@FindBy(css = "div[class*='error-message-container error'] h3")
	WebElement errorMessage;
	
	public ProductsPage loginApp(String user, String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
		
		return new ProductsPage(driver);
	}
	
	public String getErrorMessage() {
	    return errorMessage.getText();
	}
}
