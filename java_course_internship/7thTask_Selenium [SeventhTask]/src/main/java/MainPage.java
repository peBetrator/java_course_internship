import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By laterButton = By.xpath("//a[@ng-click=\"cancel()\"]");
    By loginDropdown = By.xpath("//ul[@id='login-popup']//a[@class='dropdown-toggle']");
    By loginButton = By.xpath("//a[@href=\"/accounts/login/\"]");
    By signOutButton = By.xpath("//a[@class='btn btn-default btn-sm pull-right']");

    public void clickLater() {
        driver.findElement(laterButton).click();
    }

    public void clickLoginDropdown() {
        driver.findElement(loginDropdown).click();
    }

    public LoginPage clickLoginButton() {
        clickLoginDropdown();
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public void clickLogOutButton() {
        driver.findElement(signOutButton).click();
    }

    public boolean checkIfUserIsLogedIn() {
        if (driver.findElements(signOutButton).size() != 0) return true;
        else return false;
    }
}
