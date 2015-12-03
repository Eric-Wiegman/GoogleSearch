package pages;

import com.google.testing.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

/**
 * The Class representing the Landing page.
 */
public class ResultsPage extends BasePage {

    /**
     * The Search Text Field.
     */
    @FindBy(name = "q")
    private WebElement searchField;

    /**
     * The image map field
     */
    @FindBy(id = "lu_map")
    private WebElement imageMap;

    /**
     * Instantiates a new Google Results page.
     */
    public ResultsPage() {
        super(true);
    }


    /**
     * In subclasses  should be used for page opening.
     */
    @Override
    protected void openPage() {
        //do nothing. Clicking button on landing page takes us here
    }

    /**
     * Is page opened.
     *
     * @return the boolean result
     */
    @Override
    public final boolean isPageOpened() {

        boolean bReturn;

        try {
            bReturn = imageMap.isDisplayed();
        } catch (NoSuchElementException e) {
            bReturn = false;
        }

        return bReturn;
    }

    public final boolean doesImageMapExist() {
        //we used image map to determine isPageOpened, so ...
        return isPageOpened();
    }

    public final String getImageMapUrl () {
        return imageMap.getAttribute("src");
    }

    public final String getSearchBoxText() {
        String searchBoxTest = searchField.getAttribute("value");
        return searchBoxTest;
    }
}


