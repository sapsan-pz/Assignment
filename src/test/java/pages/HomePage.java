package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".secondary-section > li")
    public List<WebElement> banner_links;

    @FindBy(xpath = "//*[text()=\"Packages & Flights\"]")
    public WebElement packages_flights;



}
