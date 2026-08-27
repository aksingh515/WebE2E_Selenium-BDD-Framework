package stepDefinitions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pomPages.CartPage;
import pomPages.CheckoutPage;
import pomPages.LoginPage;
import pomPages.ProductsPage;
import utils.BaseTest;
import utils.DriverFactory;
import utils.TestContextSetup;

public class SwagAppTest extends BaseTest {

	// global variables
	WebDriver driver;
	LoginPage loginPage;
	ProductsPage productsPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;

	// constructor helping to initialize the testContextSetup and POM classes
	public SwagAppTest(TestContextSetup testContextSetup) throws IOException {
		this.driver = testContextSetup.driver;
		this.testContextSetup = testContextSetup;
		this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
		this.productsPage = testContextSetup.pageObjectManager.getProductsPage();
		this.cartPage = testContextSetup.pageObjectManager.getCartPage();
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
		this.testContextSetup.data = getTestData(0);
	}

	@Given("user enters {string} and {string} to login the application")
	public void user_enters_and_to_login_the_application(String user, String pass) {
		productsPage = loginPage.loginApp(user, pass);
	}

	@Given("user adds product to cart and clicks on cart icon")
	public void user_adds_product_to_cart_and_clicks_on_cart_icon() throws IOException {
		productsPage.addProductToCart(testContextSetup.data.get("productName"));
		productsPage.clickCartIcon();
	}

	@When("user lands on cart page to checkout")
	public void user_lands_on_cart_page_to_checkout() throws IOException {
		cartPage.verifyProductDisplay(testContextSetup.data.get("productName"));
		cartPage.goToCheckout();
	}

	@When("user enters the checkout details and clicks on continue")
	public void user_enters_the_checkout_details_and_clicks_on_continue() throws InterruptedException, IOException {
		checkoutPage.setCheckoutDetails(testContextSetup.data.get("fname"), testContextSetup.data.get("lname"),
				testContextSetup.data.get("postal"));
		checkoutPage.goToContinue();
		checkoutPage.validateCheckoutSummary();
		checkoutPage.finishOrder();

	}

}
