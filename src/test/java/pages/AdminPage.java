package pages;

import WebControllers.ElementController;
import WebControllers.WaitControllers;
import org.openqa.selenium.WebDriver;
import pageObjects.AdminPageObjects;

public class AdminPage extends AdminPageObjects {

    public static boolean verifyAdminPageRedirection(WebDriver driver){
        WaitControllers.waitTillPageTitleLoads(driver, "OrangeHRM");
        WaitControllers.waitTillPageUrlLoads(driver, "/admin");
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "ID", addBtn));
        return true;
    }

    public static boolean verifyAddUserPageRedirection(WebDriver driver){
        WaitControllers.waitTillPageTitleLoads(driver, "OrangeHRM");
        WaitControllers.waitTillPageUrlLoads(driver, "/admin/saveSystemUser");
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "ID", saveBtn));
        return true;
    }

    public static void clickOnAdminTab(WebDriver driver){
        ElementController.click(ElementController.getWebElement(driver, "XPATH", adminTab));
    }

    public static void clickOnAdd(WebDriver driver){
        ElementController.click(ElementController.getWebElement(driver, "ID", addBtn));
    }

    public static void clickOnSave(WebDriver driver) throws InterruptedException {
        ElementController.click(ElementController.getWebElement(driver, "ID", saveBtn));
        Thread.sleep(3000);
    }

    public static void selectUserRole(WebDriver driver, String role){
        ElementController.selectTextFromDropDown(ElementController.getWebElement(driver, "ID", userRoleDropDown), role);
    }

    public static void enterEmployeeName(WebDriver driver, String name){
        ElementController.enterData(ElementController.getWebElement(driver, "ID", empNameTextBox), name, true);
    }

    public static void enterUsername(WebDriver driver, String name){
        ElementController.enterData(ElementController.getWebElement(driver, "ID", usernameTextBox), name, false);
    }

    public static void enterPassword(WebDriver driver, String code){
        ElementController.enterData(ElementController.getWebElement(driver, "ID", passwordTextBox), code, false);
    }

    public static void enterConfirmPassword(WebDriver driver, String code) throws InterruptedException {
        ElementController.enterData(ElementController.getWebElement(driver, "ID", confirmPasswordTextBox), code, false);
        Thread.sleep(3000);
    }

    public static void searchForUser(WebDriver driver, String username){
        ElementController.enterData(ElementController.getWebElement( driver, "ID", searchWithUsername), username, false);
        ElementController.click(ElementController.getWebElement(driver, "ID", searchBtn));
    }

    public static void deleteSearchedRecord(WebDriver driver) throws InterruptedException {
        ElementController.click(ElementController.getWebElement(driver, "XPATH", tableCheckBox));
        ElementController.click(ElementController.getWebElement(driver, "ID", deleteBtn));
        ElementController.click(ElementController.getWebElement(driver, "ID", deleteFromPopUp));
        Thread.sleep(3000);
    }
}
