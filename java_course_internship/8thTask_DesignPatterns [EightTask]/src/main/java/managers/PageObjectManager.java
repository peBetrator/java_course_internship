package managers;


import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;


public class PageObjectManager {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage getMainPage() {
        return (mainPage == null) ? mainPage = new MainPage(driver) : mainPage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public RegisterPage getRegisterPage() {
        return (registerPage == null) ? registerPage = new RegisterPage(driver) : registerPage;
    }
}