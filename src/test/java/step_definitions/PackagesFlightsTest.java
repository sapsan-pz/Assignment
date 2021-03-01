package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.PackagesFlightsPage;
import step_impl.PackagesFlightsImpl;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import java.util.Set;

public class PackagesFlightsTest {
    PackagesFlightsPage packagesFlightsPage = new PackagesFlightsPage();
    HomePage homePage = new HomePage();
    PackagesFlightsImpl packagesFlightsImpl = new PackagesFlightsImpl();
    String homePageHandle;

    @Given("User navigates to Packages & Flights page")
    public void i_navigate_to_Packages_Flights_page() {
        Driver.getDriver().get(ConfigReader.readProperty("url", "src/test/resources/conf/configuration.properties"));
        SeleniumUtils.click(homePage.packages_flights);
    }

    @Given("User selects {string} option")
    public void i_select_option(String string) {
        homePageHandle = Driver.getDriver().getWindowHandle();
        //Switching a window
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String str : windowHandles) {
            if (!str.equals(homePageHandle)) {
                Driver.getDriver().switchTo().window(str);
            }
        }
        //Checking if "Flight + Hotel" button is selected and pressing if it's not
        if(!packagesFlightsPage.flightHotel.getAttribute("class").equals("on")) {
            SeleniumUtils.click(packagesFlightsPage.flightHotel);
        }
    }

    @And("User inputs {string}, {string}, {string}, {string}, {string}, and {string}")
    public void iInputAndAnd(String origin, String destination, String depart, String returning, String numTrav, String airClass) {
        //Filling out packages search form
        if (packagesFlightsPage.clearButton.isEnabled()) {
            SeleniumUtils.clickShort(packagesFlightsPage.clearButton);
        }
        SeleniumUtils.sendKeys(packagesFlightsPage.origin, origin);
        packagesFlightsPage.destination.clear();
        SeleniumUtils.sendKeys(packagesFlightsPage.destination, destination);

        packagesFlightsPage.departing_date.clear();
        SeleniumUtils.sendKeys(packagesFlightsPage.departing_date, depart);

        packagesFlightsPage.returning.clear();
        SeleniumUtils.sendKeys(packagesFlightsPage.returning, returning);

        SeleniumUtils.clickShort(packagesFlightsPage.travelers);
        packagesFlightsImpl.addTraveler(numTrav);
        SeleniumUtils.clickShort(packagesFlightsPage.travelers);

        packagesFlightsImpl.switchClass(airClass);
    }

    @Given("User clicks {string} button")
    public void i_click_button(String string) {
        SeleniumUtils.clickShort(packagesFlightsPage.searchBtn);
    }
}
