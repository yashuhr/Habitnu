package Blazedemo.tests;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Blazedemo.pageobjects.Base;
import Blazedemo.pageobjects.CommonFunctionalities;
import Blazedemo.pageobjects.ConfirmationPage;
import Blazedemo.pageobjects.DestinationPage;
import Blazedemo.pageobjects.FlightInfoPage;
import Blazedemo.pageobjects.HomePage;
import Blazedemo.pageobjects.PaymentPage;

public class FlightBookingConfirmationTest extends Base {

	public FlightBookingConfirmationTest() {
		super(driver);
	}

	@BeforeMethod
	public void setup() throws IOException {
		intialization();
		HomePage hp = new HomePage(driver);
		FlightInfoPage fdp = new FlightInfoPage(driver);
		PaymentPage pp = new PaymentPage(driver);
		ConfirmationPage cp = new ConfirmationPage(driver);
	}

	@Test
	public static void TC1_ValidateFlightBookingConfirmationBySelectingLowestPriceFlight() throws IOException {

		HomePage.validateTitleDisplay();
		HomePage.click("destinationlink");
		DestinationPage.validateCurrentURL("https://blazedemo.com/vacation.html");
		CommonFunctionalities.navigate("navigateback");
		HomePage.selectCity("departure", "Mexico City");
		HomePage.selectCity("destination", "London");
		HomePage.click("findflightsbutton");
		FlightInfoPage.selectFlightWithLowestPrice();
		PaymentPage.validateTotalCostValueFormat(true);
		PaymentPage.clickPurchaseFlight();
		ConfirmationPage.validateTitleOfThePage("BlazeDemo Confirmation");
		ConfirmationPage.storeConfirmationId();

	}

}
