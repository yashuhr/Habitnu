package Blazedemo.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CommonFunctionalities extends Base {

	public CommonFunctionalities(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static void currentURL(String expectedUrl) {

		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		assertEquals(actualUrl, expectedUrl);

	}

	public static void navigate(String options) {

		switch (options) {
		case "navigateback":
			driver.navigate().back();
			break;
		case "navigateforward":
			driver.navigate().forward();
			break;
		case "navigaterefresh":
			driver.navigate().refresh();
			break;
		}
	}

	public static void selectClassMethod(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

}
