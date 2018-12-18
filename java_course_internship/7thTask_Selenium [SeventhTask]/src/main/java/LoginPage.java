import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By loginHeader = By.xpath("//span[contains(text(),'Log in')]");
    By usernameInput = By.xpath("//input[@id='id_username']");
    By passwordInput = By.xpath("//input[@id='id_password']");
    By submitButton = By.xpath("//button[@type='submit']");

    public String getHeadingText() {
        return driver.findElement(loginHeader).getText();
    }

    public void typeUserName(String name) {
        driver.findElement(usernameInput).sendKeys(name);
    }

    public void typePass(String pass) {
        driver.findElement(passwordInput).sendKeys(pass);
    }

    public LoginPage typeCredentials(String username, String password){
        typeUserName(username);
        typePass(password);
        return this;
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}
