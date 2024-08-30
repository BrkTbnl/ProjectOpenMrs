package Utilities;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {

    public static final org.apache.logging.log4j.Logger logger4j = LogManager.getLogger();

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void setUpProcess() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterClass
    public void tearDownProcess() throws InterruptedException {
        forceWait(3);
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {

        logger4j.info("test method started ");
        logger4j.warn("Warning: Test Started...");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        logger4j.info(result.getName() + " test method finished " + (result.getStatus() == 1 ? " passed " : "fail"));
        logger4j.warn("Warning: Test Finished...");
    }

    public static void forceWait(int seconds) {
        try {
            Thread.sleep(seconds*1000l);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
