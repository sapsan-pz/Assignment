package step_impl;

import org.openqa.selenium.WebElement;
import pages.SearchResultsPage;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class SearchPageImpl {
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    public List<String> hotelDistance() {
        double distance = 0;
        List<Double> distances = new ArrayList<>();
        List<String> hotels = new ArrayList<>();

        for (int i = 0; i < numberPages(); i++) {
            for (int j = 0; j < 50; j++) {
                distance = Double.parseDouble(searchResultsPage.distanceList.get(j).getText().trim().substring(0, 4));
                if (distance <= 2) {
                    distances.add(distance);
                    hotels.add(searchResultsPage.hotelList.get(j).getText());
                } else {
                    break;
                }
            }
            if (distance > 3.2) break;

            SeleniumUtils.click(searchResultsPage.nextPage);
        }
        return hotels;
    }

    public int numberPages() {
        String results = searchResultsPage.totalResults.getText().trim();
        int total = Integer.parseInt(results.substring(results.lastIndexOf(" ") + 1));
        return total / 50;
    }

    public WebElement propertyClass(String stars) {
        switch (stars) {
            case "4 stars":
                return searchResultsPage.star4;
            case "3 stars":
                return searchResultsPage.star3;
            default:
                return searchResultsPage.star5;
        }
    }

    public String propertyClassResults(String stars) {
        switch (stars) {
            case "4 stars":
                return "4.0";
            case "3 stars":
                return "3.0";
            default:
                return "5.0";
        }
    }

    public List<WebElement> propertyClassIcon(String stars) {
        switch(stars) {
            case "4 stars":
                return searchResultsPage.propertyClassIcon4;
            case "3 stars":
                return searchResultsPage.propertyClassIcon3;
            default:
                return searchResultsPage.propertyClassIcon5;
        }
    }

    public double ratingFilter(String guestRatingInput) {
        switch (guestRatingInput.trim()) {
            case "Very good":
                return 4.0;
            case "Good":
                return 3.5;
            default:
                return 4.5;
        }
    }

    public WebElement ratingElement(String guestRating) {
        switch (guestRating) {
            case "Very good":
                return searchResultsPage.veryGoodRating;
            case "Good":
                return searchResultsPage.goodRating;
            default:
                return searchResultsPage.excepRating;
        }
    }

    public WebElement neighborhhodElement(String neighborhood) {
        switch (neighborhood) {
            case "Stare Mesto":
                return searchResultsPage.neighborhoodPrague;
            case "Opfikon":
                return searchResultsPage.neighborhoodZurich;
            case "Kensington":
                return searchResultsPage.neighborhoodLondon;
            case "Asker":
                return searchResultsPage.neighborhoodOslo;
            case "Paris":
                return searchResultsPage.neighborhoodParis;
            default:
                return searchResultsPage.neighborhoodPrague;
        }
    }
}
