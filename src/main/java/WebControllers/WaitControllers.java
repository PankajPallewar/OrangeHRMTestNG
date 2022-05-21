package WebControllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitControllers {

    private static int elementWaitPeriod = 30;
    private static int pageLoadWaitPeriod = 60;

    public void waitForSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }

    public static void waitTillPageTitleLoads(WebDriver driver, String title){
        new WebDriverWait(driver, Duration.ofSeconds(pageLoadWaitPeriod)).until(ExpectedConditions.titleContains(title));
    }

    public static void waitTillPageUrlLoads(WebDriver driver, String title){
        new WebDriverWait(driver, Duration.ofSeconds(pageLoadWaitPeriod)).until(ExpectedConditions.urlContains(title));
    }

    public static void waitTillElementIsVisible(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(elementWaitPeriod)).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitTillElementIsClickable(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(elementWaitPeriod)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitTillElementDisappears(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(elementWaitPeriod)).until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitTillConfirmationPopUpDisplayed(WebDriver driver){
        new WebDriverWait(driver, Duration.ofSeconds(elementWaitPeriod)).until(ExpectedConditions.alertIsPresent());
    }
}
