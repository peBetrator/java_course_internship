import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "../drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.straus.md/en/");
        mainPage = new MainPage(driver);

    }

    @Test
    public void goToLoginPage() {
        mainPage.clickLater();
        loginPage = mainPage.clickLoginButton();
        String res = loginPage.getHeadingText();
        Assert.assertEquals("Log in", res);
    }

    @Test
    public void authenticate() {
        mainPage.clickLater();
        loginPage = mainPage.clickLoginButton();
        loginPage.typeCredentials("gotcha_bitch","test1!");
        loginPage.clickSubmitButton();
        mainPage.clickLoginDropdown();
        Assert.assertTrue(mainPage.checkIfUserIsLogedIn());
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
