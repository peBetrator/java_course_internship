package com.endava.straus.atf.page;

import com.endava.straus.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='id_password1']")
    public WebElement password1Input;
    @FindBy(xpath = "//input[@id='id_password2']")
    public WebElement password2Input;
    @FindBy(xpath = "//span[@class='text-danger']")
    public WebElement errorMsg;
    @FindBy(xpath = "//div[@class='container ng-scope']/p")
    public WebElement confirmationMsg;
    @FindBy(xpath = "//legend/span")
    protected WebElement header;
    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement submit;
    @FindBy(xpath = "//input[@id='id_email']")
    protected WebElement mailInput;
    @FindBy(id = "id_username")
    protected WebElement usernameInput;

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.header.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void typePass1(String pass) {
        password1Input.sendKeys(pass);
    }

    public void typeConfirmPass(String pass) {
        password2Input.sendKeys(pass);
    }

    public void typeUserName(String name) {
        usernameInput.sendKeys(name);
    }

    public void typeMail(String email) {
        mailInput.sendKeys(email);
    }

    public void clickSubmitButton() {
        submit.click();
    }

    public void createAccount(String username, String email, String password) {
        typeUserName(username);
        typeMail(email);
        typePass1(password);
        typeConfirmPass(password);
    }
}
