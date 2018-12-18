package com.endava.straus.atf.common.action;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    private static int count = 1;

    public static void takeScreenshot(WebDriver driver, WebElement element, boolean flag) {
        if (flag) {
            changeElementStyle(driver, element);
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("target/test-output/screenshot/screen" + count + ".png"));
                count++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void changeElementStyle(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: green solid 4px;')", element);
    }
}