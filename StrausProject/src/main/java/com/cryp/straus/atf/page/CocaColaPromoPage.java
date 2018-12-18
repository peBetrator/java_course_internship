package com.endava.straus.atf.page;

import com.endava.straus.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CocaColaPromoPage extends BasePage {
    @FindBy(id = "name")
    private WebElement nameField;
    @FindBy(id = "phone")
    private WebElement phoneField;
    @FindBy(id = "conditions_agree")
    private WebElement terms_and_conditions;
    @FindBy(className = "btn-success")
    private WebElement play;
    @FindBy(className = "spinButton")
    private WebElement spin;
    @FindBy(xpath = "//img[contains(@class, 'img-responsive') and contains(@class, 'center-block')]")
    private WebElement resultImage;
    @FindBy(className = "coins-remaining-text")
    private WebElement attempts;
    @FindBy(className = "x-close")
    private WebElement close;

    public CocaColaPromoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed(){
        try {
            return this.nameField.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
}
