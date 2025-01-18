package Blazedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends Base {

	public PaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static @FindBy(xpath = "//*[contains(text(),'Total Cost')]") WebElement TotalCost;

	public static @FindBy(xpath = "//*[contains(text(),'Total Cost')]/em") WebElement TotalCostValue;

	public static @FindBy(xpath = "//input[@value='Purchase Flight']") WebElement ButtonPurchaseFlight;

	public static boolean validateTotalCostIsDisplayed(boolean displayed) {
		displayed = TotalCost.isDisplayed();
		return displayed;
	}

	public static boolean validateTotalCostValueFormat(boolean value) {
		String text = TotalCostValue.getText();
		String regex = "\\d{3}\\.\\d{2}";
		value = text.matches(regex);
		return value;
	}

	public static void clickPurchaseFlight() {

		ButtonPurchaseFlight.click();
	}
}
