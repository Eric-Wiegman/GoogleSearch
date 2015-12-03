package testNG;

import com.google.testing.utils.Utilities;
import com.google.testing.webtestsbase.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.ResultsPage;


/**
 * Search Google for "12345" and verify, in order:
 * 1 The results page appears
 * 2 There is an image (map) link
 * 4 The link's url starts with "http://www.google.com/maps/place"
 * NOTE: Bad specification... the URL substring should end with /vt, not /place
 * AND it is (on my browser) an HTTPS secure connection. Perhaps some preference
 * 5 The search box contains the text "12345"
 */
public class GoogleSearchTests {

    private static final String S_12345 = "12345";
    private static final String URL_START = "https://www.google.com/maps/vt";

    // ******************** INITIALISATION *********************** //

    /**
     * The Utils.
     */
    // initializing the utility methods
    Utilities utils = new Utilities();

    public LandingPage landingPage;
    public ResultsPage resultsPage;

    /**
     * Before test routine -- launches the browser.
     */
    @BeforeTest
    public final void beforeTest() {
        WebDriverFactory.startBrowser();

        initializeLandingPage();

        landingPage.search(S_12345);
    }

    public final void initializeLandingPage() {
       landingPage = new LandingPage();

    }

    public final void initializeResultsPage() {
        resultsPage = new ResultsPage();
    }




    /**
     * After test, where we quit the browser.
     */
    @AfterTest
    public final void afterTest() {
        WebDriverFactory.finishBrowser();
    }

    // ******************** TESTCASE SCENARIOS *********************** //

    /**
     * Verify results page is seen
     */
    @Test(priority = 1)
    public void verifyResultsPageSeen() {
       initializeResultsPage();
       Assert.assertEquals(
                WebDriverFactory.getDriver().getTitle(),
                S_12345 + " - Google Search");
    }

    /**
     * Verify image map is seen
     */
    @Test(priority = 10)
    public void verifyImageMapSeen() {
        initializeResultsPage();
        Assert.assertTrue(
        resultsPage.doesImageMapExist());
}

    /**
     * Verify image map URL is starting off with expected substring
     */
    @Test(priority = 20)
    public void verifyImageMapLink() {
        initializeResultsPage();
       String imageMapUrl =  resultsPage.getImageMapUrl();
       int index = imageMapUrl.indexOf(URL_START);


        Assert.assertEquals(0,index);

    }

    /**
     * Verify the search box contains the text "12345"
     */
    @Test(priority = 30)
    public void verifySearchBoxContents() {
        initializeResultsPage();
        String searchBoxContents =  resultsPage.getSearchBoxText();
        Assert.assertEquals(S_12345, searchBoxContents);

    }
}
