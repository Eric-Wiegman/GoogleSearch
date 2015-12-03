package pages;

import com.google.testing.utils.Utilities;
import com.google.testing.webtestsbase.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

/**
 * The Class representing the Landing page.
 */
public class LandingPage extends BasePage {

    /**
     * The constant PAGE_URL.
     */
    private static final String PAGE_URL =
            new Utilities().getBaseUrlValueFromPropertyFile();

    /**
     * The Search Text Field.
     */
    @FindBy(name = "q")
    private WebElement searchField;

    /**
     * Instantiates a new Google Landing page.
     */
    public LandingPage() {
        super(true);
    }

    /**
     * Open page.
     */
    @Override
    protected final void openPage() {
        getDriver().get(PAGE_URL);
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
            bReturn =  searchField.isDisplayed();
        } catch (NoSuchElementException e) {
            bReturn = false;
        }

        return bReturn;
    }

    /**
     * Do search.
     */
    public final void search(String query) {
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);
    }

}

