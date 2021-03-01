package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class PackagesFlightsPage {
    public PackagesFlightsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(), \"Flight + Hotel\")]")
    public WebElement package_options;

    @FindBy(id = "tab-package-tab-hp")
    public WebElement flightHotel;

    @FindBy(xpath = "//*[@for=\"package-origin-hp-package\"]")
    public WebElement origin;

    @FindBy(xpath = "//*[@for=\"package-destination-hp-package\"]//input")
    public WebElement destination;

    @FindBy(xpath = "//*[@for=\"package-departing-hp-package\"]//input")
    public WebElement departing_date;

    @FindBy(xpath = "//*[@for=\"package-returning-hp-package\"]//input")
    public WebElement returning;

    @FindBy(css = "button[alt='Travelers']")
    public WebElement travelers;

    @FindBy(xpath = "(//span[@class=\"uitk-icon\"][ @data-control=\"uitk-icon\"])[14]")
    public WebElement addAdult;

    @FindBy(xpath = "(//span[@class=\"uitk-icon\"][ @data-control=\"uitk-icon\"])[13]")
    public WebElement removeAdult;

    @FindBy(css = "select#package-advanced-preferred-class-hp-package")
    public WebElement classSelect;

    @FindBy(xpath = "(//*[@class=\"col search-btn-col\"])[2]")
    public WebElement searchBtn;

    @FindBy(xpath = "(//button[@class=\"btn btn-clear\"])[5]")
    public WebElement clearButton;

}
