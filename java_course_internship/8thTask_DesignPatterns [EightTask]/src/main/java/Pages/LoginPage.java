package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//legend/span")
    public WebElement header;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//input[@id='id_username']")
    public WebElement usernameInput;
    @FindBy(xpath = "//input[@id='id_email']")
    public WebElement mailInput;
    @FindBy(xpath = "//input[@id='id_password']")
    public WebElement passwordInput;
    @FindBy(xpath = "//a[@href=\"/en/accounts/register/\"]")
    public WebElement registerButton;

    public LoginPage() {
    }

    public String getHeadingText() {
        return header.getText();
    }

    public void typeUserName(String name) {
        usernameInput.sendKeys(name);
    }

    public void typePass(String pass) {
        passwordInput.sendKeys(pass);
    }

    public void typeMail(String email) {
        mailInput.sendKeys(email);
    }

    public LoginPage typeCredentials(String username, String password) {
        typeUserName(username);
        typePass(password);
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void checkForErrors() {
        System.out.println(usernameInput.getAttribute("required"));
    }

}