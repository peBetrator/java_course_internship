package com.endava.straus.atf.manager;

import com.endava.straus.atf.enums.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private static Browser browser;
    private static final String DRIVER_PATH = FileReaderManager.getInstance().getConfigFileReader().getDriverPath();

    public WebDriverManager() {
        browser = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createLocalDriver();
        return driver;
    }

    private WebDriver createLocalDriver() {
        switch (browser) {
            case FIREFOX:
                System.setProperty(Browser.FIREFOX.getDriverProperty(), DRIVER_PATH + "geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty(Browser.CHROME.getDriverProperty(), DRIVER_PATH + "chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case INTERNETEXPLORER:
                DesiredCapabilities defaultZoom = DesiredCapabilities.internetExplorer();
                defaultZoom.setCapability("ignoreZoomSetting", true);
                System.setProperty(Browser.INTERNETEXPLORER.getDriverProperty(), DRIVER_PATH + "IEDriverServer.exe");
                driver = new InternetExplorerDriver(defaultZoom);
                break;
        }
        goToHomePage();
        maximizeWindow();
        setImplicitWait();
        return driver;
    }

    public void goToHomePage() {
        String homeURL = FileReaderManager.getInstance().getConfigFileReader().getApplicationHomeURL();
        String language = FileReaderManager.getInstance().getConfigFileReader().getURLLanguage();
        this.driver.navigate().to(homeURL + language);
    }

    private void maximizeWindow() {
        if (FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize())
            this.driver.manage().window().maximize();
    }

    private void setImplicitWait() {
        long implicityWait = FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait();
        this.driver.manage().timeouts().implicitlyWait(implicityWait, TimeUnit.SECONDS);
    }

    public void closeDriver() throws IOException {
        driver.close();
        try {
            driver.quit();
        } catch (Exception e) {
            Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
            Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
            Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");

        }
    }

}