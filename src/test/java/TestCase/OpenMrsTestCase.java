package TestCase;

import Utilities.GWD;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class OpenMrsTestCase extends GWD {

    @Test(priority = 2)
    public void TC_01(){ //Login test
        ElementsPage ep = new ElementsPage();
        driver.get("https://openmrs.org/");

        ep.myClick(ep.getDemo());
        ep.myClick(ep.getDemo2());
        ep.myClick(ep.getEnterMRS2());
        ep.mySendKeys(ep.getUserName(),"Admin");
        ep.mySendKeys(ep.getPassword(),"Admin123");
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

    @Test(dataProvider = "userData" , priority = 1)
    public void TC_02(String username , String password){ //Login test negative

        ElementsPage ep = new ElementsPage();
        driver.get("https://openmrs.org/en");

        ep.myClick(ep.getDemo());
        ep.myClick(ep.getDemo2());
        ep.myClick(ep.getEnterMRS2());
        ep.mySendKeys(ep.getUserName(),username);
        ep.mySendKeys(ep.getPassword(),password);
        ep.randomClick(ep.getLocationSession());
        ep.myClick(ep.getLoginBtn());

        if (username.equals("Admin") && password.equals("Admin123")){
            ep.verifyContainsText(ep.getLoginSuccess(), "Logged in as");
        }else {
            ep.verifyContainsText(ep.getErrorMsg(),"Invalid");
        }
    }

    @Test(priority = 10)
    public void TC_03(){//Logout test it will be last case so last priority
        ElementsPage ep = new ElementsPage();

        if (driver.getCurrentUrl().equals("data:,")){
            TC_01();
        }
        ep.myClick(ep.getLogout());
        ep.verifyContainsText(ep.getLogoutSuccess(),"LOGIN");
    }
    // add new patient
    @Test(dataProvider = "patientData", priority = 4)
    public void TC_04(String name, String firstName, String day, String year, String address, String city, String country, String phoneNumber){

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


}
