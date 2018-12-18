package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends LoginPage {
    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='id_password1']")
    public WebElement password1Input;
    @FindBy(xpath = "//input[@id='id_password2']")
    public WebElement password2Input;
    @FindBy(xpath = "//span[@class='text-danger']")
    public WebElement errorMsg;
    @FindBy(xpath = "//div[@class='container ng-scope']/p")
    public WebElement confirmationMsg;

    public String getErrorMessage() {
        return errorMsg.getText();
    }

    public String getConfirmation() {
        return confirmationMsg.getText();
    }

    public void typePass1(String pass) {
        password1Input.sendKeys(pass);
    }

    public void typeConfirmPass(String pass) {
        password2Input.sendKeys(pass);
    }

    public RegisterPage createAccount(String username, String email, String password) {
        typeUserName(username);
        typeMail(email);
        typePass1(password);
        typeConfirmPass(password);
        return this;
    }

    public boolean checkErrorMsg() {
        try {
            if (errorMsg.getText() != null) return true;
            else return false;
        } catch (Exception e) {
            return false;
        }
    }
}
