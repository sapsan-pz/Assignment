package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.SearchResultsPage;
import step_impl.SearchPageImpl;
import utils.CucumberUtils;
import utils.SeleniumUtils;

public class SearchResultsTest extends SearchPageImpl {
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    SearchPageImpl searchImpl = new SearchPageImpl();

    @Then("User sees a list of hotels within 2 miles distance from downtown")
    public void i_see_a_list_of_hotels_within_miles_distance_from_downtown() {
        SeleniumUtils.click(searchResultsPage.distance);
        //Presenting a list of hotels within 3.2 km (2 miles)
        for (String str : hotelDistance()) {
            System.out.println(str);
        }
    }

    @And("User applies filters for {string}, {string}, and {string}")
    public void userAppliesFiltersForAnd(String propertyClassInput, String neighborhood, String guestRating) {
        //Applying filter for Property class
        SeleniumUtils.click(searchImpl.propertyClass(propertyClassInput));

        //Applying filter for Neighborhood
        SeleniumUtils.click(searchImpl.neighborhhodElement(neighborhood));

        //Applying filter for Guest Rating
        SeleniumUtils.click(searchResultsPage.guestRatingField);
        SeleniumUtils.click(searchImpl.ratingElement(guestRating));

    }

    @And("User verifies the {string}, {string}, {string} filters have been applied appropriately")
    public void userVerifiesTheFiltersHaveBeenAppliedAppropriately(String propertyClassInput, String neighborhood, String guestRating) {
        SoftAssert softAssert = new SoftAssert();

        // Verifying the property class filter has been appropriately applied
        for (int i = 0; i < propertyClassIcon(propertyClassInput).size(); i++) {
            boolean propertyClassBool = propertyClassIcon(propertyClassInput).get(i).getAttribute("title").equals(searchImpl.propertyClassResults(propertyClassInput));
            softAssert.assertTrue(propertyClassBool);
            if (!propertyClassBool) {
                CucumberUtils.logInfo("Wrong property class", true);
            }
        }

        // Verifying the guest ranking filter has been appropriately applied
        for (int j = 0; j < searchResultsPage.hotelRanking.size(); j += 2) {
                double ratingFilter = searchImpl.ratingFilter(guestRating);
                double ranking = Double.parseDouble(searchResultsPage.hotelRanking.get(j).getText().substring(0, 3));
                System.out.println(ranking + " || " + ratingFilter);
                softAssert.assertTrue(ranking >= ratingFilter);
                if (!(ranking >= ratingFilter)) {
                    CucumberUtils.logInfo("Wrong guest rating", true);
                }
        }

        // Verifying the neighborhood filter has been appropriately applied
        for (WebElement el : searchResultsPage.neighborhoodList) {
            SeleniumUtils.moveIntoView(el);
            softAssert.assertTrue(el.getText().equals(neighborhood));
            if (!el.getText().equals((neighborhood))) {
                CucumberUtils.logInfo("Wrong neighborhood", true);
            }
        }
        //Calculating difference between the original price and discounted price
        if (searchResultsPage.oldPriceWNewPriceFirst.size() >0 && searchResultsPage.oldPriceWNewPriceFirst.get(0).isDisplayed()) {
            int discount = Integer.parseInt(searchResultsPage.oldPriceList.get(0).getText().trim().substring(0).replaceAll("[^0-9]", "")) -
                    Integer.parseInt(searchResultsPage.actualPriceList.get(0).getText().trim().substring(0).replaceAll("[^0-9]", ""));
            System.out.println("The discount is $" + discount);
        }
        softAssert.assertAll();
    }
}
