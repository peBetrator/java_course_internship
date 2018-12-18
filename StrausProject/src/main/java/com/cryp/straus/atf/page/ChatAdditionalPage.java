package com.endava.straus.atf.page;

import com.endava.straus.atf.common.action.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ChatAdditionalPage extends BasePage {
    private WebDriver driver;

    public ChatAdditionalPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public boolean isElementDisplayed() {
        return true;
    }

    public By helpButton = By.xpath("//span[@id='short-message']");
    public By greetingText = By.xpath("//p[@id='greetingsText']");
    public By nameInputHelp = By.xpath("//input[@title='Name']");
    public By phoneInputHelp = By.xpath("//input[@title='Phone']");
    public By nameErrorMsg = By.xpath("//div[@id='prechat0FieldError']");
    public By phoneErrorMsg = By.xpath("//div[@id='prechat1FieldError']");
    public By emailTranscriptText = By.xpath("//div[@class='form-header-text']");
    public By submitHelp = By.xpath("//button[@id='formSubmit']");
    public By navbarDropdown = By.xpath("//span[@class='icon-menu headerBoxIcon']");
    By bodyDOM = By.xpath("//iframe");
    By messageFieldHelp = By.xpath("//textarea[@id='chatTextarea']");
    public By emailTranscript = By.xpath("//li[@id='emailTranscriptOption']");
    public By endThisChat = By.xpath("//li[@id='endChat']");
    By submitButtonHelp = By.xpath("//button[@id='formSubmit']");
    By emailTranscriptInput = By.xpath("//input[@id='transcriptEmailField']");
    public By messageChat = By.xpath("//div[@class='message']");

    public void switchFrameToHelp(By pageObject) {
        driver.switchTo().defaultContent(); // you are now outside both frames
        int size = driver.findElements(bodyDOM).size();
        for (int i = 1; i <= size; i++) {
            driver.switchTo().frame(i);
            int total = driver.findElements(pageObject).size();
            if (total != 0) break;
            driver.switchTo().defaultContent();
        }
    }

    public void clickHelpButton() {
        driver.findElement(helpButton).click();
    }

    public void clickSubmitButtonHelp() {
        driver.findElement(submitButtonHelp).click();
    }

    public void clickNavbarDropdown() {
        driver.findElement(navbarDropdown).click();
    }

    public void clickEmailTranscript() {
        driver.findElement(emailTranscript).click();
    }

    public void clickEndThisChat() {
        driver.findElement(endThisChat).click();
    }

    public String getGreetingText() {
        return driver.findElement(greetingText).getText();
    }

    public void switchBackToMain() {
        driver.switchTo().defaultContent();
    }

    public void typeUserName(String name) {
        driver.findElement(nameInputHelp).sendKeys(name);
    }

    public void typePhoneNumber(String number) {
        driver.findElement(phoneInputHelp).sendKeys(number);
    }

    public void typeEmail(String email) {
        driver.findElement(emailTranscriptInput).sendKeys(email);
    }

    public void enterCredsForChat(String name, String phoneNumber) {
        typeUserName(name);
        typePhoneNumber(phoneNumber);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonHelp).click();
    }

    public void clearField(By pageObject) {
        driver.findElement(pageObject).clear();
    }

    public String getText(By pageObject) {
        return driver.findElement(pageObject).getText();
    }

    public void sendMessages(String msg) {
        driver.findElement(messageFieldHelp).sendKeys(msg);
        driver.findElement(messageFieldHelp).sendKeys(Keys.ENTER);
    }
}