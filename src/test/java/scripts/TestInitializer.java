package scripts;

import ExtControllers.DataController;
import ExtControllers.ReportController;
import WebControllers.BrowserController;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class TestInitializer {

    ExtentReports reports;
    ExtentTest test;
    HashMap<String, String> appData = new HashMap<String, String>();
    HashMap<String, String> testData = new HashMap<String, String>();

    protected WebDriver testBuilder(String testName){
        test = ReportController.initializeTest(reports, testName);
        testData = DataController.getTestData(testName);
        return new BrowserController().openWebsite(appData.get("Site"));
    }

    @AfterSuite
    public void suiteTearDown(){
        ReportController.terminateReport(reports);
    }

    @BeforeMethod
    public void methodSetUp(){
        appData = DataController.getAppConfigurations();
        reports = ReportController.initializeReport();
    }
}
