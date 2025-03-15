package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class commonMethods {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public commonMethods(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForElementToVisible(WebElement ele){
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitForElementToVisible(String locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementToClikable(WebElement ele){
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public void waitUntillElementBecameStale(WebElement ele){
        wait.until(ExpectedConditions.stalenessOf(ele));
    }

    public void waitForinvisibleofElement(WebElement ele){
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

}
