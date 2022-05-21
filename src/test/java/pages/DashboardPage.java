package pages;

import WebControllers.ElementController;
import WebControllers.WaitControllers;
import org.openqa.selenium.WebDriver;
import pageObjects.DashboardPageObjects;

public class DashboardPage extends DashboardPageObjects {

    public static boolean verifyDashboardPageRedirection(WebDriver driver){
        WaitControllers.waitTillPageTitleLoads(driver, "OrangeHRM");
        WaitControllers.waitTillPageUrlLoads(driver, "/dashboard");
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "XPATH", applyLeaveOpt));
        return true;
    }

    public static void clickOnDashboardTab(WebDriver driver){
        ElementController.click(ElementController.getWebElement(driver, "XPATH", dashboardTab));
    }
}
