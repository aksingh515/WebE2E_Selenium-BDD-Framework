package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	
WebDriver driver ;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueBtn;
    
    @FindBy(className = "summary_info_label")
    WebElement summaryInfo;

    @FindBy(className = "summary_subtotal_label")
    WebElement itemTotal;

    @FindBy(className = "summary_tax_label")
    WebElement tax;

    @FindBy(className = "summary_total_label")
    WebElement grandTotal;

    @FindBy(id = "finish")
    WebElement finishBtn;
	
	
	
	public void setCheckoutDetails(String fname, String lname, String postal)
	{
		
		System.out.println("Current URL = " + driver.getCurrentUrl());
	    waitForElementToVisible(firstName);
	    firstName.clear();
	    firstName.sendKeys(fname);

	    waitForElementToVisible(lastName);
	    lastName.clear();
	    lastName.sendKeys(lname);

	    waitForElementToVisible(postalCode);
	    postalCode.clear();
	    postalCode.sendKeys(postal);

	    System.out.println(firstName.getAttribute("value"));
        System.out.println(lastName.getAttribute("value"));
        System.out.println(postalCode.getAttribute("value"));
	}
		
	public void goToContinue()
	{
		 waitForElementToBeClickable(continueBtn);
	     System.out.println("Before Click : " + driver.getCurrentUrl());
	     continueBtn.click();
	     waitForUrlContains("checkout-step-two");
	     System.out.println("After Click : " + driver.getCurrentUrl());
	}
	
	public void validateCheckoutSummary()
	{
		waitForElementToVisible(itemTotal);
		System.out.println("Current URL = " + driver.getCurrentUrl());
		
		 Assert.assertTrue(itemTotal.isDisplayed());
		 Assert.assertTrue(tax.isDisplayed());
		 Assert.assertTrue(grandTotal.isDisplayed());

		 System.out.println(itemTotal.getText());
		 System.out.println(tax.getText());
		 System.out.println(grandTotal.getText());
		
	}
	
	public void finishOrder()
	{
		waitForElementToBeClickable(finishBtn);
		finishBtn.click();
	}
	
}
