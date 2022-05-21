package ExtControllers;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

public class ReportController {

    public static ExtentReports initializeReport(){
        ExtentReports reports;
        return  reports = new ExtentReports(System.getProperty("user.dir")+"/report/AutomationReport.html");
    }

    public static void terminateReport(ExtentReports reports){
        reports.flush();
        reports.close();
    }

    public static ExtentTest initializeTest(ExtentReports reports, String testName){
        ExtentTest test = reports.startTest(testName);
        return test;
    }

    public static void terminateTest(ExtentReports reports, ExtentTest test){ reports.endTest(test); }

    public static void logTestAsFailed(WebDriver driver, ExtentTest test, String fileName, String message){
        test.log(LogStatus.FAIL, test.addScreenCapture(UtilityController.takeScreenshot(driver, fileName)) + message);
    }

    public static void logStatusToReport(ExtentTest test, String statusType, String message){
        try {
            switch (statusType.toUpperCase()){
                case "PASS":
                    test.log(LogStatus.PASS, message);
                    break;
                case "SKIP":
                    test.log(LogStatus.SKIP, message);
                    break;
                case "INFO":
                    test.log(LogStatus.INFO, message);
                    break;
                case "ERROR":
                    test.log(LogStatus.ERROR, message);
                    break;
                case "WARNING":
                    test.log(LogStatus.WARNING, message);
                    break;
                default:
                    throw new Exception("Incorrect status type provided: "+statusType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
