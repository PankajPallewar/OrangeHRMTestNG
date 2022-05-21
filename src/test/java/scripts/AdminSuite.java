package scripts;

import ExtControllers.DataController;
import ExtControllers.ReportController;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;

import static org.testng.Assert.fail;

public class AdminSuite extends TestInitializer {

    @Test
    public void addSystemUser() {
        String testName = new Throwable().getStackTrace()[0].getMethodName();
        WebDriver driver = testBuilder(testName);
        try {
            Assert.assertTrue(LoginPage.verifyLoginPageRedirection(driver));
            ReportController.logStatusToReport(test, "INFO", "Verified login page redirection");
            LoginPage.loginIntoAccount(driver, appData.get("Username"), appData.get("Password"));
            ReportController.logStatusToReport(test, "INFO", "Entered credentials for login");
            Assert.assertTrue(DashboardPage.verifyDashboardPageRedirection(driver));
            ReportController.logStatusToReport(test, "INFO", "Verified dashboard page redirection");

            AdminPage.clickOnAdminTab(driver);
            ReportController.logStatusToReport(test, "INFO", "Clicked on Admin tab");
            AdminPage.clickOnAdd(driver);
            ReportController.logStatusToReport(test, "INFO", "Clicked on ADD button");
            Assert.assertTrue(AdminPage.verifyAddUserPageRedirection(driver));
            ReportController.logStatusToReport(test, "INFO", "Verified add page redirection");
            AdminPage.selectUserRole(driver, testData.get("UserRole"));
            ReportController.logStatusToReport(test, "INFO", "Selected User Role");
            AdminPage.enterEmployeeName(driver, testData.get("EmpName"));
            ReportController.logStatusToReport(test, "INFO", "Entered employee name");
            String username = testData.get("Username")+ DataController.getUniqueNumber();
            AdminPage.enterUsername(driver, username);
            ReportController.logStatusToReport(test, "INFO", "Entered username");
            AdminPage.enterPassword(driver, testData.get("Password"));
            ReportController.logStatusToReport(test, "INFO", "Entered password");
            AdminPage.enterConfirmPassword(driver, testData.get("Password"));
            ReportController.logStatusToReport(test, "INFO", "Entered confirm password");
            AdminPage.clickOnSave(driver);
            ReportController.logStatusToReport(test, "INFO", "Clicked on Save button");
            AdminPage.searchForUser(driver, username);
            ReportController.logStatusToReport(test, "INFO", "Searched for created user");
            AdminPage.deleteSearchedRecord(driver);
            ReportController.logStatusToReport(test, "INFO", "Deleted searched user");

            ReportController.logStatusToReport(test, "PASS", "TEST PASSED");
        } catch (Exception e) {
            ReportController.logTestAsFailed(driver, test, testName, e.getMessage());
            fail();
            e.printStackTrace();
        } finally {
            if (driver != null)
                driver.close();
        }
    }
}
