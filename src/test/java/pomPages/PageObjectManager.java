package pomPages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public LoginPage loginPage;
	public ProductsPage productsPage;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;
	public ThankYouPage thankYouPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public LoginPage getLoginPage()
	{
		loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	public ProductsPage getProductsPage()
	{
		productsPage = new ProductsPage(driver);
		return productsPage;
	}
	
	public CartPage getCartPage()
	{
		cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public CheckoutPage getCheckoutPage()
	{
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	public ThankYouPage getThankYouPage()
	{
		thankYouPage = new ThankYouPage(driver);
		return thankYouPage;
	}
	
}
