package Blazedemo.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightInfoPage extends Base {

	public FlightInfoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static @FindBy(xpath = "//table[@class='table']/tbody/tr/td[6]") List<WebElement> FlightPriceElements;

	public static @FindBy(xpath = "//input[@value='Choose This Flight']") List<WebElement> ChooseFlightButton;

	public static void selectFlightWithLowestPrice() {

		List<Double> prices = new ArrayList<>();

		for (WebElement FlightPriceElement : FlightPriceElements) {
			String priceText = FlightPriceElement.getText().replace("$", "").trim();
			prices.add(Double.parseDouble(priceText));
		}

		double minPrice = prices.get(0);
		int minPriceIndex = 0;

		for (int i = 0; i < prices.size(); i++) {
			if (prices.get(i) < minPrice) {
				minPrice = prices.get(i);
				minPriceIndex = i;
			}
		}
		WebElement leastPriceButton = ChooseFlightButton.get(minPriceIndex);
		leastPriceButton.click();

	}

}
