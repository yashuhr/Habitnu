package Blazedemo.pageobjects;

import org.openqa.selenium.WebDriver;

public class DestinationPage extends Base {

	public DestinationPage(WebDriver driver) {
		super(driver);
	}

	public static void validateCurrentURL(String expectedURL) {
		CommonFunctionalities.currentURL(expectedURL);
	}
}
