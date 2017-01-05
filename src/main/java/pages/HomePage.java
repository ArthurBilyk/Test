package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class HomePage extends Page {


    @FindBy(xpath = "//form[@data-is-first-visible='1']//input[@id='ss']")
    private WebElement searchField;

    @FindBy(xpath = "//form[@data-is-first-visible='1']//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//form[@data-is-first-visible='1']//div[@data-mode='checkin']//input[@class='sb-date-field__input -year']")
    private WebElement checkInYear;

    @FindBy(xpath = "//form[@data-is-first-visible='1']//div[@data-mode='checkin']//input[@class='sb-date-field__input -month']")
    private WebElement checkInMonth;

    @FindBy(xpath = "//form[@data-is-first-visible='1']//div[@data-mode='checkin']//input[@class='sb-date-field__input -day']")
    private WebElement checkInDay;

    @FindBy(xpath = "//form[@data-is-first-visible='1']//div[@data-mode='checkout']//input[@class='sb-date-field__input -month']")
    private WebElement checkoutMonth;

    @FindBy(xpath = "//form[@data-is-first-visible='1']//div[@data-mode='checkout']//input[@class='sb-date-field__input -year']")
    private WebElement checkoutYear;

    @FindBy(xpath = "//form[@data-is-first-visible='1']//div[@data-mode='checkout']//input[@class='sb-date-field__input -day']")
    private WebElement checkoutDay;

    @FindBy(xpath = "//input[@data-sb-acc-types='2']")
    private WebElement hotelsCheckBox;

    @FindBy(xpath = "//li[@class=' sort_category  selected  sort_popularity  ']")
    private WebElement searchResult;


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        logger.info("Openning main page");
        driver.get("http://www.booking.com/index.en-gb.html");
    }

    public ResultsPage searchForHotels(String location, String checkInDate, String checkOutDate) throws InterruptedException {
        logger.info("Entering dates and start search");
        typeText(searchField, location);
        setCheckInDate(checkInDate);
        setCheckOutDate(checkOutDate);
        hotelsCheckBox.click();
        searchButton.click();
        logger.info("Moving to Results Page");
        return new ResultsPage(driver);
    }

    private HomePage setCheckInDate(String checkInDate) {
        HashMap<String, String> date = getDatesFromString(checkInDate);
        typeText(checkInDay, date.get("day")).
                typeText(checkInMonth, date.get("month")).
                typeText(checkInYear, date.get("year"));
        return this;
    }

    private HomePage setCheckOutDate(String checkOutDate) {
        HashMap<String, String> date = getDatesFromString(checkOutDate);
        typeText(checkoutDay, date.get("day")).
                typeText(checkoutMonth, date.get("month")).
                typeText(checkoutYear, date.get("year"));

        return this;
    }


}
