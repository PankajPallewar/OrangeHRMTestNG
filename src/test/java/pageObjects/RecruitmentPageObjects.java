package pageObjects;

public class RecruitmentPageObjects {

    protected static String addBtn = "btnAdd";
    protected static String candidateSec = "//a[text()='Candidates']";
    protected static String firstName = "addCandidate[firstName]";
    protected static String middleName = "addCandidate[middleName]";
    protected static String lastName = "addCandidate[lastName]";
    protected static String emailID = "addCandidate[email]";
    protected static String contactNo = "addCandidate[contactNo]";
    protected static String jobVacancy = "addCandidate[vacancy]";
    protected static String keywords = "addCandidate[keyWords]";
    protected static String comments = "addCandidate[comment]";
    protected static String saveBtn = "btnSave";
    protected static String recruitmentTab = "//ul[@id='mainMenuFirstLevelUnorderedList']/li/a/b[text()='Recruitment']";
    protected static String applicationAction = "//div[@id='actionPane']/descendant::select";
    protected static String shortlistBtn = "//input[@value='Shortlist']";
    protected static String backBtn = "//input[@value='Back']";
    protected static String resetBtn = "//input[@value='Reset']";
    protected static String searchBtn = "//input[@value='Search']";
    protected static String deleteBtn = "//input[@value='Delete']";
    protected static String candidateSearch = "candidateSearch[candidateName]";
    protected static String resultTableCells = "//table[@id='resultTable']/descendant::td";
    protected static String okBtnFromDeletePopUp = "dialogDeleteBtn";
}
