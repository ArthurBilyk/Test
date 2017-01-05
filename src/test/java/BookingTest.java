import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.ResultsPage;


public class BookingTest extends TestTemplate {


	//Test verifies that in search results are only hotels from New York
    @Test
    public void verifySearchResult() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        ResultsPage resultsPage = homePage.searchForHotels("New York City", "20/12/2016", "25/12/2016");
        for (String address : resultsPage.getResultsAddress()) {
            Assert.assertEquals("The following addres is not located in  -> " + address, true, address.contains("New York"));
        }
    }


	//Test verifies that all hotels are 5-stars after the filter was applied
    @Test
    public void verifyStarFilter() throws InterruptedException {
        ResultsPage resultsPage = new HomePage(driver).
                searchForHotels("New York City", "20/12/2016", "25/12/2016").
                setFiveStarFilter();
        Assert.assertEquals("The list is not fully with 5-stars hotels -> " + resultsPage.getListQuantity(), resultsPage.getListQuantity(), resultsPage.getListFiveStarsQuantity());
    }

}