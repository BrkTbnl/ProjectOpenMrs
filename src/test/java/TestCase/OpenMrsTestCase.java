package TestCase;

import Utilities.GWD;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class OpenMrsTestCase extends GWD {

    @Test
    public void TC_01(){ //Login test
        ElementsPage ep = new ElementsPage();
        driver.get("https://openmrs.org/");

        ep.myClick(ep.langBar());
        ep.myClick(ep.English());
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

    @Test(dataProvider = "userData" )
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

}
