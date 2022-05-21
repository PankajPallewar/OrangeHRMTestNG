package scripts;

import ExtControllers.ReportController;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RecruitmentPage;

import static org.testng.Assert.fail;

public class RecruitmentSuite extends TestInitializer{

    @Test
    public void addCandidateInRecruitment(){
        String testName = new Throwable().getStackTrace()[0].getMethodName();
        WebDriver driver = testBuilder(testName);
        try {
            Assert.assertTrue(LoginPage.verifyLoginPageRedirection(driver));
            ReportController.logStatusToReport(test, "INFO", "Verified login page redirection");
            LoginPage.loginIntoAccount(driver, appData.get("Username"), appData.get("Password"));
            ReportController.logStatusToReport(test, "INFO", "Entered credentials for login");
            Assert.assertTrue(DashboardPage.verifyDashboardPageRedirection(driver));
            ReportController.logStatusToReport(test, "INFO", "Verified dashboard page redirection");

            RecruitmentPage.clickOnRecruitmentTab(driver);
            ReportController.logStatusToReport(test, "INFO", "Clicked on recruitment tab");
            Assert.assertTrue(RecruitmentPage.verifyRecruitmentPageRedirection(driver));
            ReportController.logStatusToReport(test, "INFO", "Verified recruitment page redirection");
            RecruitmentPage.clickOnCandidatesSection(driver);
            ReportController.logStatusToReport(test, "INFO", "Clicked on candidates section");
            RecruitmentPage.clickOnAdd(driver);
            ReportController.logStatusToReport(test, "INFO", "Clicked on add button");

            Assert.assertTrue(RecruitmentPage.verifyCandidateAddPageRedirection(driver));
            ReportController.logStatusToReport(test, "INFO", "Verified add candidate page redirection");
            RecruitmentPage.enterFirstName(driver, testData.get("FirstName"));
            RecruitmentPage.enterMiddleName(driver, testData.get("MiddleName"));
            RecruitmentPage.enterLastName(driver, testData.get("LastName"));
            RecruitmentPage.enterEmailID(driver, testData.get("EmailID"));
            RecruitmentPage.enterContactNumber(driver, testData.get("ContactNo"));
            RecruitmentPage.selectJobVacancy(driver, testData.get("JobVacancy"));
            RecruitmentPage.enterKeywords(driver, testData.get("Keywords"));
            RecruitmentPage.enterComments(driver, testData.get("Comments"));
            RecruitmentPage.clickOnSave(driver);
            ReportController.logStatusToReport(test, "INFO", "Filled up the form and clicked save");

            RecruitmentPage.selectApplicationAction(driver, testData.get("AppAction"));
            RecruitmentPage.clickOnShortlistBtn(driver);
            RecruitmentPage.clickOnBackBtn(driver);
            RecruitmentPage.clickOnBackBtn(driver);
            ReportController.logStatusToReport(test, "INFO", "Updated status of application as shortlisted");

            RecruitmentPage.clickOnResetBtn(driver);
            RecruitmentPage.searchWithCandidateName(driver, testData.get("FirstName"), testData.get("MiddleName"), testData.get("LastName"));
            RecruitmentPage.clickOnSearchBtn(driver);
            ReportController.logStatusToReport(test, "INFO", "Searched for added candidate");
            Assert.assertTrue(RecruitmentPage.verifySearchedResult(driver, testData.get("JobVacancy"), testData.get("FirstName"), testData.get("Status")));
            ReportController.logStatusToReport(test, "INFO", "Verified the record addition of candidate");

            RecruitmentPage.selectSearchedRecord(driver);
            RecruitmentPage.clickOnDeleteBtn(driver, true);
            ReportController.logStatusToReport(test, "INFO", "Deleted the searched record");

            ReportController.logStatusToReport(test, "PASS", "TEST PASSED");
        } catch (Exception e){
            ReportController.logTestAsFailed(driver, test, testName, e.getMessage());
            fail();
            e.printStackTrace();
        }
        finally {
            if (driver!=null)
                driver.close();
        }
    }
}
