package pomPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.AbstractComponents;

public class CartPage extends AbstractComponents {
	
WebDriver driver ;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@data-test='inventory-item-name']")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkoutBtn;
	
	By cartProductsBy = By.xpath("//div[@data-test='inventory-item-name']");
	
	public List<WebElement> getProductCartList()
	{
		waiForElementToAppear(cartProductsBy);
		return cartProducts;
	}
	
	public boolean verifyProductDisplay(String productName)
	{
		boolean cartMatch = getProductCartList().stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
		return cartMatch;
	}
	
	public void goToCheckout()
	{
		waitForElementToVisible(checkoutBtn);
		System.out.println("Current URL = " + driver.getCurrentUrl());
		System.out.println("Page Title = " + driver.getTitle());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkoutBtn);
		//checkoutBtn.click();
	}
}
