package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class SearchResultsPage {
    public SearchResultsPage() { PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".sort-options.nobullet > li:nth-child(4)")
    public WebElement distance;

    @FindBy(css = ".pagination-next")
    public WebElement nextPage;

    @FindBy(xpath = "//h3[@class='visuallyhidden']")
    public List<WebElement> hotelList;

    @FindBy(xpath = "//*[contains(@class, 'distance')]")
    public List<WebElement> distanceList;

    @FindBy(xpath = "//*[contains(text(), \"Showing Results\")]")
    public WebElement totalResults;

    @FindBy(id = "star5")
    public WebElement star5;

    @FindBy(id = "star4")
    public WebElement star4;

    @FindBy(id = "star3")
    public WebElement star3;

    @FindBy(xpath = "//span[contains(text(), \"Stare Mesto\")]")
    public WebElement neighborhoodPrague;

    @FindBy(xpath = "//span[contains(text(), \"Opfikon\")]")
    public WebElement neighborhoodZurich;

    @FindBy(xpath = "//span[contains(text(), \"Kensington\")]")
    public WebElement neighborhoodLondon;

    @FindBy(xpath = "//span[contains(text(), \"Asker\")]")
    public WebElement neighborhoodOslo;

    @FindBy(xpath = "//span[contains(text(), \"Paris\")]")
    public WebElement neighborhoodParis;

    @FindBy(id = "guestRating45")
    public WebElement excepRating;

    @FindBy(id = "guestRating40")
    public WebElement veryGoodRating;

    @FindBy(id = "guestRating35")
    public WebElement goodRating;

    @FindBy(xpath = "//*[contains(text(), \"Guest Rating\")]")
    public WebElement guestRatingField;

    @FindBy(xpath = "//*[@class=\"reviewOverall\"]/span/span//parent::span")
    public List<WebElement> hotelRanking;

    @FindBy(css = ".neighborhood.secondary ")
    public List<WebElement> neighborhoodList;

    @FindBy(css = ".icon.icon-stars5-0.stars-grey.value-title")
    public List<WebElement> propertyClassIcon5;

    @FindBy(css = ".icon.icon-stars4-0.stars-grey.value-title")
    public List<WebElement> propertyClassIcon4;

    @FindBy(css = ".icon.icon-stars3-0.stars-grey.value-title")
    public List<WebElement> propertyClassIcon3;

    @FindBy(xpath = "//li[contains(@class, \"actualPrice\")]")
    public List<WebElement> actualPriceList;

    @FindBy(xpath = "//a[contains(@class, \"over-link\")]")
    public List<WebElement> oldPriceList;

    @FindBy(xpath = "(//*[@class=\"flex-content info-and-price CITY \"]//a[contains(@class, \"strikePrice\")])[1]")
    public List<WebElement> oldPriceWNewPriceFirst;


}
