package TestCase;

import Utilities.GWD;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class OpenMrsTestCase extends GWD {

    @Test(priority = 2)
    public void TC_01() { //Login test
        ElementsPage ep = new ElementsPage();
        driver.get("https://openmrs.org/");

        ep.myClick(ep.getDemo());
        ep.myClick(ep.getDemo2());
        ep.myClick(ep.getEnterMRS2());
        ep.mySendKeys(ep.getUserName(), "Admin");
        ep.mySendKeys(ep.getPassword(), "Admin123");
        ep.randomClick(ep.getLocationSession());
        ep.myClick(ep.getLoginBtn());
        ep.verifyContainsText(ep.getLoginSuccess(), "Logged in as");

    }

    @DataProvider
    public Object[][] userData() {
        Object[][] data =
                {
                        {"admin", "Admin12"},
                        {"Admin", ""},
                        {"", ""},
                        {"", "Admin123"},
                        {"admin", "admin123"},
                        {"xyz", "1234"}
                };
        return data;
    }

    @Test(dataProvider = "userData", priority = 1)
    public void TC_02(String username, String password) { //Login test negative

        ElementsPage ep = new ElementsPage();
        driver.get("https://openmrs.org/en");

        ep.myClick(ep.getDemo());
        ep.myClick(ep.getDemo2());
        ep.myClick(ep.getEnterMRS2());
        ep.mySendKeys(ep.getUserName(), username);
        ep.mySendKeys(ep.getPassword(), password);
        ep.randomClick(ep.getLocationSession());
        ep.myClick(ep.getLoginBtn());

        if (username.equals("Admin") && password.equals("Admin123")) {
            ep.verifyContainsText(ep.getLoginSuccess(), "Logged in as");
        } else {
            ep.verifyContainsText(ep.getErrorMsg(), "Invalid");
        }
    }

    @Test(priority = 99)
    public void TC_03() {//Logout test it will be last case so last priority
        ElementsPage ep = new ElementsPage();

        if (driver.getCurrentUrl().equals("data:,")) {
            TC_01();
        }
        ep.myClick(ep.getLogout());
        ep.verifyContainsText(ep.getLogoutSuccess(), "LOGIN");
    }

    // add new patient
    @Test(dataProvider = "patientData", priority = 4)
    public void TC_04(String name, String firstName, String day, String year, String address, String city, String country, String phoneNumber) {

        ElementsPage ep = new ElementsPage();
        if (driver.getCurrentUrl().equals("data:,")) {
            TC_01();
        }
        ep.myClick(ep.getRegister());
        ep.mySendKeys(ep.getName(), name);
        ep.mySendKeys(ep.getSurname(), firstName);
        ep.myClick(ep.getNextButton1());
        ep.myClick(ep.getGender());
        ep.myClick(ep.getNextButton2());
        ep.mySendKeys(ep.getDay(), day);
        ep.myClick(ep.getMonth());
        ep.mySendKeys(ep.getYear(), year);
        ep.myClick(ep.getNextButton3());
        ep.mySendKeys(ep.getAddress(), address);
        ep.mySendKeys(ep.getCity(), city);
        ep.mySendKeys(ep.getCountry(), country);
        ep.myClick(ep.getNextButton4());
        ep.mySendKeys(ep.getPhone(), phoneNumber);
        ep.myClick(ep.getNextButton5());
        ep.myClick(ep.getNextButton6());
        ep.myClick(ep.getConfirm());
        ep.verifyContainsText(ep.getAccessMessage(), "Created Patient Record:");
        ep.myClick(ep.getHomeButton());

    }

    @DataProvider
    public static Object[][] patientData() {
        return new Object[][]{
                {"James", "Hetfield", "03", "1963", "Address 1", "Downey", "USA", "+1-555-0101"},
                {"Lars", "Ulrich", "26", "1963", "Address 2", "Los Angeles", "USA", "+1-555-0202"},
                {"Kirk", "Hammett", "18", "1962", "Address 3", "San Francisco", "USA", "+1-555-0303"}

        };
    }


    @Test(dependsOnMethods = "TC_01", priority = 5)
    public void TC_05() {  //to reach my acc.

        ElementsPage ep = new ElementsPage();
        if (driver.getCurrentUrl().equals("data:,")) {
            TC_01();
        }

        System.out.println(driver.getCurrentUrl());

        ep.myHoverOver(ep.getUserIcon());
        ep.myClick(ep.getUserIcon());
        ep.myClick(ep.getMyAccount());
        ep.myClick(ep.getChangePassword());
        ep.verifyContainsText(ep.getChangePasswordL(), "Change Password");
        ep.myClick(ep.getMyAccount2());
        ep.myClick(ep.getMyLanguages());
        ep.verifyContainsText(ep.getMyLanguagesL(), "My Languages");
        ep.myClick(ep.getHomeButton());
    }


    @Test(priority = 6, dependsOnMethods = "TC_01")
    public void TC_06() { //search patient function
        ElementsPage ep = new ElementsPage();

        ep.myClick(ep.getSearchPatient());
        ep.mySendKeys(ep.getSearchPatientBox(), "Kirk Hammett");
        ep.myClick(ep.getPatientButton());
        Assert.assertTrue(ep.getNameSuccess().getText().toLowerCase().contains("kirk"));
        Assert.assertTrue(ep.getSurnameSuccess().getText().toLowerCase().contains("hammett"));
        ep.myClick(ep.getHomeButton());

    }

    @Test(priority = 7, dependsOnMethods = "TC_01")
    public void TC_07() { //negative test search patient
        ElementsPage ep = new ElementsPage();

        ep.myClick(ep.getSearchPatient());
        ep.mySendKeys(ep.getSearchPatientBox(), "no name");
        Assert.assertTrue(ep.getSearchPatientNegativeSuccess().getText().contains("No matching records found"));
        ep.myClick(ep.getHomeButton());
    }

    @Test(dependsOnMethods = "TC_01", priority = 8)
    public void TC_08() { //delete patient

        ElementsPage ep = new ElementsPage();
        ep.myClick(ep.getSearchPatient());
        ep.mySendKeys(ep.getSearchPatientBox(), "Kirk Hammett");
        ep.myClick(ep.getPatientButton());

        String id = ep.getPatientId().getText();
        ep.myClick(ep.getDeletePatient());
        ep.mySendKeys(ep.getDeleteReason(),"no reason");
        ep.myClick(ep.getConfirmButton());

        wait.until(ExpectedConditions.visibilityOf(ep.getSearchPatientBox()));

        ep.mySendKeys(ep.getSearchPatientBox(),id);
        Assert.assertTrue(ep.getSearchPatientNegativeSuccess().getText().contains("No matching records found"));
        ep.myClick(ep.getHomeButton());
    }

    @Test(dependsOnMethods = "TC_01", priority = 9)
    public void TC_09(){ //listing patients
        ElementsPage ep = new ElementsPage();
        ep.myClick(ep.getSearchPatient());
        String fullText = ep.getShowingEntries().getText();
        String[] words = fullText.split(" ");
        int totalEntries = Integer.parseInt(words[words.length-2]);
        System.out.println("total entries: " + totalEntries);

        int pageNumber = ep.getPageNumber().size();
        int rowNumber = 0;

        for (int i = 0; i < pageNumber; i++) {
            ep.getPageNumber().get(i).click();
            rowNumber += ep.getPageRows().size();
        }

        System.out.println("total rows: " + rowNumber);
        ep.myClick(ep.getHomeButton());
    }

    @Test(dependsOnMethods = "TC_01", priority = 10)
    public void TC_10() { //merging patients
        ElementsPage ep = new ElementsPage();

        ep.myClick(ep.getSearchPatient());
        ep.mySendKeys(ep.getSearchPatientBox(), "Lars Ulrich");

        ep.myClick(ep.getPatientButton());
        String id1 = ep.getPatientId().getText();
        ep.myClick(ep.getHomeButton());

        ep.myClick(ep.getSearchPatient());
        ep.mySendKeys(ep.getSearchPatientBox(), "James Hetfield");

        ep.myClick(ep.getPatientButton());
        String id2 = ep.getPatientId().getText();
        ep.myClick(ep.getHomeButton());

        ep.myClick(ep.getDataManagement());
        ep.myClick(ep.getMergePatient());
        ep.mySendKeys(ep.getPatient1(), id1);
        ep.mySendKeys(ep.getPatient2(), id2);
        ep.myClick(ep.getPatientSearchClick());

        ep.myClick(ep.getContinueButton());
        ep.verifyContainsText(ep.getMergindSuccess(), "Merging cannot be undone");
        ep.myClick(ep.getClickPatient());
        ep.myClick(ep.getContinueButton());
        ep.verifyContainsText(ep.getMergePatientId1(), id1);
        ep.verifyContainsText(ep.getMergePatientId2(), id2);
        ep.myClick(ep.getHomeButton());

    }

    @Test(priority = 11, dependsOnMethods = "TC_01")
    public void TC_11() { //appointment with invalid time

        ElementsPage ep = new ElementsPage();
        ep.myClick(ep.getAppointmentScheduling());
        ep.myClick(ep.getManageAppointments());
        ep.mySendKeys(ep.getSearchPatientBox(), "lars ulrich");
        ep.myClick(ep.getPatientButton());
        ep.verifyContainsText(ep.getAlertText(), "Your computer is not set to the right time zone.");
        ep.myClick(ep.getHomeButton());

    }
}
