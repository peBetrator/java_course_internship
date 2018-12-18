package com.endava.straus.atf.page;

import com.endava.straus.atf.common.action.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class RestaurantPage extends BasePage {

    public JavascriptExecutor jse;
    public WebDriver driver;
    private String catXpath;

    public RestaurantPage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.name.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @FindBy(xpath = "//h1[@itemprop='name']")
    public WebElement name;

    @FindBy(xpath = "//span[@itemprop=\"name\"]")
    public List<WebElement> productNames;

    @FindBy(xpath = "//a[@class=\"btn btn-block btn-success\"]")
    public List<WebElement> productsAddToCartButtons;

    @FindBy(xpath = "//span[@itemprop='price']")
    public List<WebElement> prices;

    @FindBy(xpath = "//span[@itemprop=\"description\"]")
    public List<WebElement> descriptions;

    @FindBy(xpath = "//button[@class='btn btn-success btn-wider']")
    public WebElement ok;

    @FindBy(xpath = "//button[@class='btn btn-success ng-binding']")
    public WebElement setAddress;

    @FindBy(xpath = "//button[@ng-if=\"!showClarifyAddress(address)\"]")
    public WebElement clarifyAddress;

    @FindBy(xpath = "//button[contains(text(),'Save address')]")
    public WebElement saveAddress;

    @FindBy(id = "addressInput")
    public WebElement addressInput;

    @FindBy(xpath = "//ymaps[@class='ymaps-2-1-71-zoom__icon ymaps-2-1-71-float-button-icon']")
    public WebElement zoom;

    //@FindBy(xpath = "//button[@go-click=\"/en/cart/\"]")
    //@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right sm-hidden']")
    @FindBy(xpath = "//a[@class='button-wrapper row zero-margins']")
    public WebElement cart;

    @FindBy(xpath = "//a[@class='navbar-brand hidden-lg']")
    public WebElement strausLogo;

    @FindBy(xpath = "//div[@ng-if='clientOutsideStrausDeliveryArea']/b")
    public WebElement deliveryWarning;

    public int selectProductIndex(String name) throws InterruptedException {
        int index;
        for (WebElement product : productNames) {
            if (product.getText().equals(name)) {
                Thread.sleep(500);
                scrollToFind(product);
                Thread.sleep(500);
                index = productNames.indexOf(product);
                return index;
            }
        }
        return -1;
    }

    public void simpleAddProductToCart(int index, boolean isCategory) throws InterruptedException {
        List<WebElement> list;
        if (isCategory) {
            list = getAddCategoryProductButtons();
        } else {
            list = productsAddToCartButtons;
        }
        list.get(index).click();
        Thread.sleep(1000);
        try {
            driver.findElement(By.xpath("//button[@class='btn btn-success btn-wider']"));
            ok.click();
        } catch (NoSuchElementException e) {
            return;
        }
    }

    public void insertAddress() {
        setAddress.click();
        addressInput.sendKeys("Sstr. Sfatul Țării 15"); //There is no typo.. Double S at the beginning due to
        // system bug which does not read the first character when you write the address.
        for (int i = 0; i <= 5; i++) {
            zoom.click();
        }
        clarifyAddress.click();
        //saveAddress.click(); // Might be deprecated, but not sure yet.
    }

    public void scrollToFind(WebElement element) throws InterruptedException {
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void returnToHomePage() {
        String en = "https://www.straus.md/en/";
        String ro = "https://www.straus.md/ro/";
        String ru = "https://www.straus.md/ru/";
        while (!(driver.getCurrentUrl().equals(en) || driver.getCurrentUrl().equals(ro) || driver.getCurrentUrl().equals(ru))) {
            driver.navigate().back();
        }
    }

    public void navigateBackTo(String url) {
        while (!driver.getCurrentUrl().equals(url)) {
            driver.navigate().back();
        }
    }

    public List<Integer> getWeightValues(boolean isCategory) {
        List<Integer> weight = new ArrayList<>();
        String val;
        List<WebElement> list;
        if (isCategory) {
            list = driver.findElements(By.xpath(catXpath.concat("//span[@itemprop='description']")));
        } else {
            list = descriptions;
        }
        for (WebElement description : list) {
            val = description.getText();
            weight.add(Integer.parseInt(val.replaceAll("\\D+", "")));
        }
        return weight;
    }

    public List<Integer> getPriceListValues(boolean isCategory) {
        List<Integer> productPrices = new ArrayList<>();
        List<WebElement> list;
        String str;
        if (isCategory) {
            list = driver.findElements(By.xpath(catXpath.concat("//span[@itemprop='price']")));
        } else {
            list = prices;
        }
        for (WebElement price : list) {
            str = String.valueOf(price.getText());
            str = str.trim();
            productPrices.add(Integer.valueOf(str));
        }
        return productPrices;
    }

    public int getIndex(String minOrMax, List<Integer> list) {
        int minIndex = 0;
        int maxIndex = 0;
        for (int element : list) {
            if (element < list.get(minIndex)) {
                minIndex = list.indexOf(element);
            } else if (element > list.get(maxIndex)) {
                maxIndex = list.indexOf(element);
            }
        }
        if (minOrMax.toLowerCase().equals("min")) {
            return minIndex;
        } else if (minOrMax.toLowerCase().equals("max")) {
            return maxIndex;
        }
        return -1;
    }

    public int selectOptimalProduct(String optimal, boolean isCategory) {
        List<Integer> productPrices = getPriceListValues(isCategory);
        List<Integer> productWeighs = getWeightValues(isCategory);
        switch (optimal.toLowerCase()) {
            case "cheap":
                return getIndex("min", productPrices);
            case "expensive":
                return getIndex("max", productPrices);
            case "light":
                return getIndex("min", productWeighs);
            case "heavy":
                return getIndex("max", productWeighs);
            default:
                return 0;
        }
    }

    public void setCatXpath(String category) {
        this.catXpath = "//div[contains(h2,\"" + category + "\")]";
    }

    public List<WebElement> getAddCategoryProductButtons() {
        return driver.findElements(By.xpath(catXpath.concat("//a[@class=\"btn btn-block btn-success\"]")));
    }
}
