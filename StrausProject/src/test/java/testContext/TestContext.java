package testContext;

import com.endava.straus.atf.manager.FileReaderManager;
import com.endava.straus.atf.manager.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.endava.straus.atf.utilities.PageObjectUtilities;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectUtilities pageObjectUtilities;
    private WebDriverWait wait;
    private boolean flag;

    public TestContext() {
        webDriverManager = new WebDriverManager();
        pageObjectUtilities = new PageObjectUtilities(webDriverManager.getDriver());
        wait = new WebDriverWait(webDriverManager.getDriver(), 20);
        flag = FileReaderManager.getInstance().getConfigFileReader().getScreenshootFlag();
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectUtilities getPageObjectUtilities() {
        return pageObjectUtilities;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public boolean getFlag() {
        return flag;
    }
}