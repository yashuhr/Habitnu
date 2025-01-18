package Blazedemo.pageobjects;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends Base {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public static @FindBy(xpath = "//table[@class='table']/tbody/tr[1]/td[last()]") WebElement ConfirmationId;

	public static void validateTitleOfThePage(String expectedText) {
		String title = driver.getTitle();
		assertEquals(title, expectedText);

	}

	public static void storeConfirmationId() throws IOException {
		String filePath = "C:/Users/yashaswi.ramappa/eclipse-workspace/Habitnu/src/main/java/Blazedemo/pageobjects/Inputs.properties";
		String id = ConfirmationId.getText();
		FileInputStream fis = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(fis);
		prop.setProperty("confirmationId", id);
		FileOutputStream fos = new FileOutputStream(filePath);
		prop.store(fos, id);

	}

}
