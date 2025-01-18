package Blazedemo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends Base {

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static @FindBy(xpath = "//h1[contains(text(),'Welcome')]") WebElement TitleDisplay;

	public static @FindBy(xpath = "//a[contains(text(),'destination')]") WebElement DestinationLink;

	public static @FindBy(xpath = "//select[@name='fromPort']") WebElement DepartureCity;

	public static @FindBy(xpath = "//select[@name='toPort']") WebElement DestinationCity;

	public static @FindBy(xpath = "//input[@type='submit']") WebElement FindFlights;

	public static void validateTitleDisplay() {
		String actualTitle = TitleDisplay.getText();
		String expectedTitle = "Welcome to the Simple Travel Agency!";
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	public static void selectCity(String options, String cityName) {
		switch (options) {
		case "departure":
			CommonFunctionalities.selectClassMethod(DepartureCity, cityName);
			break;
		case "destination":
			CommonFunctionalities.selectClassMethod(DestinationCity, cityName);
			break;

		}
	}

	public static void click(String options) {
		switch (options) {
		case "destinationlink":
			DestinationLink.click();
			;
			break;
		case "findflightsbutton":
			FindFlights.click();
			break;

		}

	}

}
