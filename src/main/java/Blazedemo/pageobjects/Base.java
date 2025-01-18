package Blazedemo.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public static WebDriver intialization() throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:/Users/yashaswi.ramappa/eclipse-workspace/Habitnu/src/main/java/Blazedemo/pageobjects/Inputs.properties");
		Properties prop = new Properties();
		prop.load(fis);

		if (prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(options);

		}

		else {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.setAcceptInsecureCerts(true);
			driver = new EdgeDriver(options);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;

	}

	@AfterMethod
	public static void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

}
