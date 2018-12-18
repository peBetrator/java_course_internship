package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@ng-click=\"cancel()\"]")
    public WebElement laterButton;
    @FindBy(xpath = "//ul[@id='login-popup']//a[@class='dropdown-toggle']")
    public WebElement loginDropdown;
    @FindBy(xpath = "//a[@href=\"/accounts/login/\"]")
    public WebElement loginButton;
    @FindBy(xpath = "//a[@class='btn btn-default btn-sm pull-right']")
    public WebElement signOutButton;

    public void clickLater() {
        laterButton.click();
    }

    public void clickLoginDropdown() {
        loginDropdown.click();
    }

    public void clickLoginButton() {
        clickLoginDropdown();
        loginButton.click();
        //return new LoginPage(driver);
    }

    public void clickSignOutButton() {
        signOutButton.click();
    }

    public boolean checkIfUserIsLogedIn() {
        try {
            if (signOutButton.getText() != null) return true;
            else return false;
        } catch (Exception e) {
            return false;
        }
    }
}
