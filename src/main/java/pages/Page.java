package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.logging.Logger;


public class Page {

    protected static WebDriver driver;
    public WebDriverWait wait;
    static Logger logger = Logger.getLogger(Page.class.getName());


    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3000);
    }

    public Page typeText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public HashMap<String, String> getDatesFromString(String date) {
        HashMap<String, String> dates = new HashMap<String, String>();
        String[] parsedDate = date.split("/");
        dates.put("day", parsedDate[0]);
        dates.put("month", parsedDate[1]);
        dates.put("year", parsedDate[2]);
        return dates;
    }


}
