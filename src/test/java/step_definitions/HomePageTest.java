package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import utils.ConfigReader;
import utils.CucumberUtils;
import utils.Driver;

import java.util.ArrayList;
import java.util.List;

public class HomePageTest {
    HomePage homePage = new HomePage();

    @Given("User navigates to Hotels webpage")
    public void i_navigate_to_Hotels_webpage() {
        Driver.getDriver().get(ConfigReader.readProperty("url", "src/test/resources/conf/configuration.properties"));
    }

    @Then("User verifies Banner contains the following links:")
    public void i_verify_Banner_contains_the_following_links(List<String> dataTable) {
        List<String> banner_links = new ArrayList<>();
        for(WebElement el : homePage.banner_links) {
            banner_links.add(el.getText());
        }
        for (int i = 0; i < dataTable.size(); i++) {
            Assert.assertTrue(banner_links.contains(dataTable.get(i)));
        }
        CucumberUtils.logInfo("Checking if the Banner contains all links", true);
    }
}
