package WebControllers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ElementController {

    public static WebElement getWebElement(WebDriver driver, String locatorType, String locatorValue) {
        By element = null;
        try {
            switch (locatorType.toUpperCase()) {
                case "ID":
                    element = By.id(locatorValue);
                    break;
                case "XPATH":
                    element = By.xpath(locatorValue);
                    break;
                case "CLASSNAME":
                    element = By.className(locatorValue);
                    break;
                case "LINKTEXT":
                    element = By.linkText(locatorValue);
                    break;
                case "PARTIALLINKTEXT":
                    element = By.partialLinkText(locatorType);
                    break;
                case "TAGNAME":
                    element = By.tagName(locatorValue);
                    break;
                case "NAME":
                    element = By.name(locatorValue);
                    break;
                default:
                    throw new Exception("Incorrect locator type provided: " + locatorType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver.findElement(element);
    }

    public static List<WebElement> getWebElements(WebDriver driver, String locatorType, String locatorValue) {
        By element = null;
        try {
            switch (locatorType.toUpperCase()) {
                case "ID":
                    element = By.id(locatorValue);
                    break;
                case "XPATH":
                    element = By.xpath(locatorValue);
                    break;
                case "CLASSNAME":
                    element = By.className(locatorValue);
                    break;
                case "LINKTEXT":
                    element = By.linkText(locatorValue);
                    break;
                case "PARTIALLINKTEXT":
                    element = By.partialLinkText(locatorType);
                    break;
                case "TAGNAME":
                    element = By.tagName(locatorValue);
                    break;
                case "NAME":
                    element = By.name(locatorValue);
                    break;
                default:
                    throw new Exception("Incorrect locator type provided: " + locatorType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver.findElements(element);
    }

    public static void enterData(WebElement element, String data, boolean action) {
        try {
            if (!action)
                element.sendKeys(data);
            else
                element.sendKeys(data, Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectValueFromDropDown(WebElement element, String value) {
        try {
            Select sel = new Select(element);
            sel.selectByValue(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectValueFromDropDown(WebElement element, int index) {
        try {
            Select sel = new Select(element);
            sel.selectByIndex(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectTextFromDropDown(WebElement element, String text) {
        try {
            Select sel = new Select(element);
            sel.selectByVisibleText(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mouseHoverOnElement(WebDriver driver, WebElement element) {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(element).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickOnElementWithMouse(WebDriver driver, WebElement element) {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(element).click().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void contextClickOnElementWithMouse(WebDriver driver, WebElement element) {
        try {
            Actions act = new Actions(driver);
            act.contextClick(element).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doubleClickOnElementWithMouse(WebDriver driver, WebElement element) {
        try {
            Actions act = new Actions(driver);
            act.doubleClick(element).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static void handleAlert(WebDriver driver, boolean accept) {
        if (accept)
            driver.switchTo().alert().accept();
        else
            driver.switchTo().alert().dismiss();
    }
}
