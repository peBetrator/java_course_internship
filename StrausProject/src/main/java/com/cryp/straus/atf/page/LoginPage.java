package com.endava.straus.atf.page;

import com.endava.straus.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//legend/span")
    public WebElement header;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;
    @FindBy(xpath = "//input[@id='id_username']")
    public WebElement usernameInput;
    @FindBy(xpath = "//input[@id='id_email']")
    public WebElement mailInput;
    @FindBy(xpath = "//input[@id='id_password']")
    public WebElement passwordInput;
    @FindBy(xpath = "//a[@href='/en/accounts/register/']")
    public WebElement registerButton;

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.header.isDisplayed();
        } catch (Exception e) {
            return false;
        }
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

    public void navigateToRegister() {
        registerButton.click();
    }
}