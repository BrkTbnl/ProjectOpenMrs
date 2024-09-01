package TestCase;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage extends Parent {

    public ElementsPage() {
        PageFactory.initElements(GWD.driver, this);
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

    @FindBy(css = "ul#sessionLocation>li")
    private List<WebElement> locationSession;

    @FindBy(css = "#content>div:nth-child(2)")
    private WebElement loginSuccess;

    @FindBy(id = "error-message")
    private WebElement errorMsg;

    @FindBy(css = "li[class='nav-item logout'] a")
    private WebElement logout;

    @FindBy(css = ".w-auto")
    private WebElement logoutSuccess;

    @FindBy(css = "[id= \"apps\"]>a:nth-child(4)")
    public WebElement registerButton;

    @FindBy(xpath = "//input[@name='givenName']")
    public WebElement name;

    @FindBy(xpath = "//input[@name='familyName']")
    private WebElement surname;

    @FindBy(xpath = "//icon[@class='fas fa-chevron-right']")
    private WebElement nextButton1;

    @FindBy(css = "select[id='gender-field']>:nth-child(2)")
    private WebElement gender;

    @FindBy(xpath = "//icon[@class='fas fa-chevron-right']")
    private WebElement nextButton2;

    @FindBy(xpath = "//input[@id='birthdateDay-field']")
    private WebElement day;

    @FindBy(xpath = "//option[text()='February']")
    private WebElement month;

    @FindBy(xpath = "//input[@id='birthdateYear-field']")
    private WebElement year;

    @FindBy(xpath = "//button[@id='next-button']/icon")
    private WebElement nextButton3;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement address;

    @FindBy(xpath = "//input[@id='cityVillage']")
    private WebElement city;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement country;

    @FindBy(xpath = "//button[@id='next-button']/icon")
    private WebElement nextButton4;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phone;

    @FindBy(xpath = "//button[@id='next-button']/icon")
    private WebElement nextButton5;

    @FindBy(xpath = "//button[@id='next-button']/icon")
    private WebElement nextButton6;

    @FindBy(id = "submit")
    private WebElement confirm;

    @FindBy(xpath = "(//p[contains(text(),'Created Patient Record:')])[2]")
    private WebElement accessMessage;

    @FindBy(css = "[class='icon-user small']")
    private WebElement userIcon;

    @FindBy(xpath = "//i[@class='icon-home small']")
    private WebElement homeButton;

    @FindBy(css = "[href='/openmrs/adminui/myaccount/myAccount.page']")
    private WebElement myAccount;

    @FindBy(xpath = "(//a[@href='/openmrs/adminui/myaccount/myAccount.page'])[2]")
    private WebElement myAccount2;

    @FindBy(xpath = "//i[@class=\"icon-lock\"]")
    private WebElement changePassword;

    @FindBy(xpath = "(//*[contains(text(), \"Change\")])[3]")
    private WebElement changePasswordLabel;

    @FindBy(xpath = "//i[@class=\"icon-cog\"]")
    private WebElement myLanguages;

    @FindBy(xpath = "(//*[contains(text(), \"Languages\")])[3]")
    private WebElement myLanguagesL;

    @FindBy(xpath = "//div[@id='apps']//a[1]")
    private WebElement searchPatient;

    @FindBy(xpath = "//input[@id='patient-search']")
    private WebElement searchPatientBox;

    @FindBy(xpath = "((//tbody[@role='alert']/tr)[1]/td)[1]")
    private WebElement patientButton;

    @FindBy(css = ".PersonName-givenName")
    private WebElement nameSuccess;

    @FindBy(css = ".PersonName-familyName")
    private WebElement surnameSuccess;

    @FindBy(xpath = "//td[text()='No matching records found']")
    private WebElement searchPatientNegativeSuccess;

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

    public List<WebElement> getLocationSession() {
        return locationSession;
    }

    public WebElement getLoginSuccess() {
        return loginSuccess;
    }

    public WebElement getErrorMsg() {
        return errorMsg;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getLogoutSuccess() {
        return logoutSuccess;
    }

    public WebElement getRegister() {
        return registerButton;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getSurname() {
        return surname;
    }

    public WebElement getNextButton1() {
        return nextButton1;
    }

    public WebElement getGender() {
        return gender;
    }

    public WebElement getNextButton2() {
        return nextButton2;
    }

    public WebElement getDay() {
        return day;
    }

    public WebElement getMonth() {
        return month;
    }

    public WebElement getYear() {
        return year;
    }

    public WebElement getNextButton3() {
        return nextButton3;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getNextButton4() {
        return nextButton4;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getNextButton5() {
        return nextButton5;
    }

    public WebElement getNextButton6() {
        return nextButton6;
    }

    public WebElement getConfirm() {
        return confirm;
    }

    public WebElement getAccessMessage() {
        return accessMessage;
    }

    public WebElement getUserIcon() {
        return userIcon;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getChangePassword() {
        return changePassword;
    }

    public WebElement getChangePasswordL() {
        return changePasswordLabel;
    }

    public WebElement getMyLanguages() {
        return myLanguages;
    }

    public WebElement getMyLanguagesL() {
        return myLanguagesL;
    }

    public WebElement getMyAccount() {
        return myAccount;
    }

    public WebElement getMyAccount2() {
        return myAccount2;
    }

    public WebElement getSearchPatient() {
        return searchPatient;
    }

    public WebElement getSearchPatientBox() {
        return searchPatientBox;
    }

    public WebElement getSurnameSuccess() {
        return surnameSuccess;
    }

    public WebElement getNameSuccess() {
        return nameSuccess;
    }

    public WebElement getPatientButton() {
        return patientButton;
    }
    public WebElement getSearchPatientNegativeSuccess() {
        return searchPatientNegativeSuccess;
    }

}
