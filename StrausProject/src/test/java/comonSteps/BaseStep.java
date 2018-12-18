package comonSteps;

import com.endava.straus.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testContext.TestContext;
import com.endava.straus.atf.utilities.PageObjectUtilities;

public class BaseStep {
    public TestContext context;
    public BasePage page;
    public WebDriver driver;
    public PageObjectUtilities utilities;
    public WebDriverWait wait;
    public boolean flag;

    public BaseStep(TestContext context) {
        this.context = context;
        page = context.getPageObjectUtilities().getPageByName("Home");
        driver = context.getWebDriverManager().getDriver();
        utilities = context.getPageObjectUtilities();
        wait = context.getWait();
        flag = context.getFlag();
    }
}