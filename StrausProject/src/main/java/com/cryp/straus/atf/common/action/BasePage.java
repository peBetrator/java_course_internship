package com.endava.straus.atf.common.action;

import com.endava.straus.atf.pojo.ClientDetailsPojo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clicks(WebElement elementAttr) {
        elementAttr.click();
    }

    public void completes(WebElement elementAttr, String text) {
        elementAttr.sendKeys(text);
    }

    public String receives(WebElement elementAttr) {
        return elementAttr.getText();
    }

    public String nameToUrl(String name) {
        String url;
        url = name.toLowerCase().replaceAll(" ", "-").replaceAll("'", "");
        return url;
    }

    public abstract boolean isElementDisplayed();
}