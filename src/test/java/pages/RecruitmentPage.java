package pages;

import WebControllers.ElementController;
import WebControllers.WaitControllers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.RecruitmentPageObjects;

import java.util.List;

public class RecruitmentPage extends RecruitmentPageObjects {

    public static boolean verifyRecruitmentPageRedirection(WebDriver driver){
        WaitControllers.waitTillPageTitleLoads(driver, "OrangeHRM");
        WaitControllers.waitTillPageUrlLoads(driver, "/recruitment");
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "ID", addBtn));
        return true;
    }

    public static boolean verifyCandidateAddPageRedirection(WebDriver driver){
        WaitControllers.waitTillPageTitleLoads(driver, "OrangeHRM");
        WaitControllers.waitTillPageUrlLoads(driver, "/recruitment/addCandidate");
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "NAME", firstName));
        return true;
    }

    public static void clickOnRecruitmentTab(WebDriver driver){
        ElementController.click(ElementController.getWebElement(driver, "XPATH", recruitmentTab));
    }

    public static void clickOnCandidatesSection(WebDriver driver){
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "XPATH", candidateSec));
        ElementController.click(ElementController.getWebElement(driver, "XPATH", candidateSec));
    }

    public static void clickOnAdd(WebDriver driver){
        ElementController.click(ElementController.getWebElement(driver, "ID", addBtn));
    }

    public static void enterFirstName(WebDriver driver, String value){
        ElementController.enterData(ElementController.getWebElement(driver, "NAME", firstName), value, false);
    }

    public static void enterMiddleName(WebDriver driver, String value){
        ElementController.enterData(ElementController.getWebElement(driver, "NAME", middleName), value, false);
    }

    public static void enterLastName(WebDriver driver, String value){
        ElementController.enterData(ElementController.getWebElement(driver, "NAME", lastName), value, false);
    }

    public static void enterEmailID(WebDriver driver, String value){
        ElementController.enterData(ElementController.getWebElement(driver, "NAME", emailID), value, false);
    }

    public static void enterContactNumber(WebDriver driver, String value){
        ElementController.enterData(ElementController.getWebElement(driver, "NAME", contactNo), value, false);
    }

    public static void selectJobVacancy(WebDriver driver, String value){
        ElementController.selectTextFromDropDown(ElementController.getWebElement(driver, "NAME", jobVacancy), value);
    }

    public static void enterKeywords(WebDriver driver, String value){
        ElementController.enterData(ElementController.getWebElement(driver, "NAME", keywords), value, false);
    }

    public static void enterComments(WebDriver driver, String value){
        ElementController.enterData(ElementController.getWebElement(driver, "NAME", comments), value, false);
    }

    public static void clickOnSave(WebDriver driver){
        ElementController.click(ElementController.getWebElement(driver, "ID", saveBtn));
    }

    public static void selectApplicationAction(WebDriver driver, String value){
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "XPATH", applicationAction));
        ElementController.selectTextFromDropDown(ElementController.getWebElement(driver, "XPATH", applicationAction), value);
    }

    public static void clickOnShortlistBtn(WebDriver driver){
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "XPATH", shortlistBtn));
        ElementController.click(ElementController.getWebElement(driver, "XPATH", shortlistBtn));
    }

    public static void clickOnBackBtn(WebDriver driver){
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "XPATH", backBtn));
        ElementController.click(ElementController.getWebElement(driver, "XPATH", backBtn));
    }

    public static void clickOnSearchBtn(WebDriver driver){
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "XPATH", searchBtn));
        ElementController.click(ElementController.getWebElement(driver, "XPATH", searchBtn));
    }

    public static void clickOnResetBtn(WebDriver driver){
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "XPATH", resetBtn));
        ElementController.click(ElementController.getWebElement(driver, "XPATH", resetBtn));
    }

    public static void clickOnDeleteBtn(WebDriver driver, boolean accept){
        ElementController.click(ElementController.getWebElement(driver, "XPATH", deleteBtn));
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "ID", okBtnFromDeletePopUp));
        ElementController.click(ElementController.getWebElement(driver, "ID", okBtnFromDeletePopUp));
    }

    public static void searchWithCandidateName(WebDriver driver, String firstName, String middleName, String lastName){
        WaitControllers.waitTillElementIsVisible(driver, ElementController.getWebElement(driver, "NAME", candidateSearch));
        ElementController.enterData(ElementController.getWebElement(driver, "NAME", candidateSearch),
                firstName+" "+middleName+" "+lastName, true);
    }

    public static boolean verifySearchedResult(WebDriver driver, String vacancy, String firstName, String status){
        List<WebElement> elements = ElementController.getWebElements(driver, "XPATH", resultTableCells);
        boolean hasVacancy = false; boolean hasfirstName = false; boolean hasStatus = false;
        for(WebElement element : elements){
            if(element.getText().equalsIgnoreCase(vacancy))
                hasVacancy = true;
            if(element.getText().equalsIgnoreCase(status))
                hasStatus = true;
        }
        if (hasVacancy && hasStatus){
            if(ElementController.getWebElement(driver, "XPATH", resultTableCells+"/a")
                    .getText().contains(firstName))
                hasfirstName = true;
        }
        if (hasfirstName)
            return true;
        else
            return false;
    }

    public static void selectSearchedRecord(WebDriver driver){
        ElementController.click(ElementController.getWebElement(driver, "XPATH", resultTableCells+"/input"));
    }
}
