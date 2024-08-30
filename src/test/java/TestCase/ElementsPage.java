package TestCase;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends Parent{

    public ElementsPage(){
        PageFactory.initElements(GWD.driver,this);
    }

    @FindBy(xpath = "//div[@class=\"gt-current-lang\"]")
    private WebElement language;

    @FindBy(xpath = "(//a[@class=\"nturl\"])[1]")
    private WebElement language2;

    @FindBy(linkText = "Demo")
    private WebElement demo;
    @FindBy(xpath = "//a[@href=\"#openmrs2\"]")
    private WebElement demo2;
    @FindBy(xpath = "//*[text()='Enter the OpenMRS 2 Demo']")
    private WebElement enterMRS2;
    @FindBy(id = "username")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "loginButton")
    private WebElement loginBtn;



    public WebElement langBar(){return language;}

    public WebElement English(){return language2;}

    public WebElement getDemo() {
        return demo;
    }

    public WebElement getDemo2() {
        return demo2;
    }

    public WebElement getEnterMRS2() {
        return enterMRS2;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

}
