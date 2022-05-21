package pages;

import WebControllers.ElementController;
import WebControllers.WaitControllers;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPageObjects;

public class LoginPage extends LoginPageObjects {

    public static boolean verifyLoginPageRedirection(WebDriver driver){
        WaitControllers.waitTillPageTitleLoads(driver, "OrangeHRM");
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "ID", usernameField));
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "ID", passwordField));
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "ID", loginBtn));
        return true;
    }

    public static void loginIntoAccount(WebDriver driver, String username, String password){
        ElementController.enterData(ElementController.getWebElement(driver, "ID", usernameField), username, false);
        ElementController.enterData(ElementController.getWebElement(driver, "ID", passwordField), password, false);
        ElementController.click(ElementController.getWebElement(driver, "ID", loginBtn));
    }
}
