import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import utils.DriverType;

public class TestTemplate {

    static WebDriver driver;

    @BeforeClass
    public static void onceExecutedBeforeAll() throws Exception {
        driver = DriverType.CHROME.getDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void executeAfterAllTests() {
        driver.quit();
    }


}