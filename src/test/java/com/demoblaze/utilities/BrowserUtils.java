package com.demoblaze.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class BrowserUtils {
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void clickWithWait(By by, int attempts) {
        int counter = 0;
        while (counter < attempts) {
            try {
                clickWithJS(Driver.get().findElement(by));
                break;
            } catch (WebDriverException e) {
                e.printStackTrace();
                ++counter;
                waitFor(1);
            }
        }
    }

    public static void waitAndSendKeys(WebElement element, String text, int timeout) {
        new WebDriverWait(Driver.get(), Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

}


