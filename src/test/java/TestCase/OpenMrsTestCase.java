package TestCase;

import Utilities.GWD;
import org.testng.annotations.Test;


public class OpenMrsTestCase extends GWD {

    @Test
    public void TC_01(){
        ElementsPage ep = new ElementsPage();
        driver.get("https://openmrs.org/");

        ep.myClick(ep.langBar());
        ep.myClick(ep.English());
        ep.myClick(ep.getDemo());
        ep.myClick(ep.getDemo2());

        ep.myClick(ep.getEnterMRS2());
    }
}
