package step_impl;

import org.openqa.selenium.support.ui.Select;
import pages.PackagesFlightsPage;
import pages.SearchResultsPage;
import utils.SeleniumUtils;

public class PackagesFlightsImpl {
    PackagesFlightsPage packagesFlightsPage = new PackagesFlightsPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    public void switchClass(String airClass) {
        Select select = new Select(packagesFlightsPage.classSelect);
        switch(airClass) {
            case "Economy":
                select.selectByVisibleText("Economy/Coach");
                break;
            case "Business":
                select.selectByValue("b");
                break;
            case "First class":
                select.selectByValue("f");
                break;
            case "Premium economy":
                select.selectByValue("p");
                break;
            default:
                System.out.println("Wrong class");
        }
    }

    public void addTraveler(String travelers) {
        int trNum = Integer.parseInt(travelers);
        if (trNum > 1) {
            int n = trNum;
            for(int i = 0; i < n-2; i++) {
                SeleniumUtils.click(packagesFlightsPage.addAdult);
            }
            } else {
            SeleniumUtils.click(packagesFlightsPage.removeAdult);
        }
    }

    public void nextPage() {
        SeleniumUtils.click(searchResultsPage.nextPage);
    }
}
