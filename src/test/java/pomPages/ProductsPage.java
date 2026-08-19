package pomPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.AbstractComponents;

public class ProductsPage extends AbstractComponents {

	WebDriver driver ;
	
	public ProductsPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='inventory_list']/child::div")
	List<WebElement> products ;
	
	//@FindBy(xpath="//button[contains(text(),'Add to cart')]")
	//List<WebElement> addToCarts ;
	
	@FindBy(css=".shopping_cart_link")
	WebElement cartIcon;
	
	By productsBy = By.xpath("//div[@class='inventory_list']/child::div");
	By addToCart = By.xpath(".//button[contains(text(),'Add to cart')]");
	
	// Action Method
	
	public List<WebElement> getProductList()
	{
		waiForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductName(String productName)
	{
		WebElement productItem = getProductList().stream().filter(product-> product.findElement(By.xpath(".//div[@data-test='inventory-item-name']")).getText()
				.equals(productName)).findFirst().orElse(null);
		return productItem ;
	}
	
	public void addProductToCart(String productName)
	{
		WebElement productItem = getProductName(productName);
		productItem.findElement(addToCart).click();
		System.out.println(productItem+" Added sucessfully..");
	}
	
	public void clickCartIcon()
	{
		waitForElementToVisible(cartIcon);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cartIcon);
		//cartIcon.click();
	}
			
}
