package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;


public class ResultsPage extends Page{


    @FindBy(xpath = "//a[@data-id='class-5']")
    private WebElement fiveStarFilter;

    @FindBy(xpath = "//div[@class='address']")
    private List<WebElement> hotelAddresses;

    @FindBy(xpath = "//i[@class='b-sprite stars ratings_stars_5  star_track']")
    private List<WebElement> fivestarsList;



    public ResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public List<String> getResultsAddress() {
        ArrayList<String> resultsAddress = new ArrayList<String>();
        for (WebElement webElement : hotelAddresses) {
            resultsAddress.add(webElement.getText());
        }
        return resultsAddress;
    }


    public ResultsPage setFiveStarFilter(){
        logger.info("Set 5-star hotel filter");
        fiveStarFilter.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='sr-usp-overlay__container is_stuck']")));
        wait.until(ExpectedConditions.elementToBeClickable(hotelAddresses.get(1)));
        return this;
    }

    public int getListQuantity(){
        return hotelAddresses.size();
    }

    public int getListFiveStarsQuantity(){
        return fivestarsList.size();
    }


}
