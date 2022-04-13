package project;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static project.MyLogger.LogLevel.*;

public abstract class SeleniumTest {
    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;
    protected WebDriverWait driverWait;

    protected MyLogger logger;

    public static final String DRIVER_LOCATION = "D:\\studies\\year3\\semester2\\QA\\chromedriver.exe";
    public static final int IMPLICIT_WAIT_TIME_MS = 1100;

    @Rule(order = Integer.MIN_VALUE)
    public TestWatcher watcher = new TestWatcher() {

        @Override
        protected void failed(Throwable e, Description description) {
            logger.log(DEBUG, "FAILED - " + description.getMethodName() + " | Reason: " + e.getMessage());
        }

        @Override
        protected void succeeded(Description description) {
            logger.log(INFO, "PASSED - " + description.getMethodName());
        }
    };

    protected void getSite() {
        driver.get("https://demoqa.com/books");
    }

    protected void setDefaultSize() {
        driver.manage().window().setSize(new Dimension(1280, 720));
    }

    protected void initDefaults() {
        getSite();
        setDefaultSize();
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        logger = new MyLogger(
                "logs/" + this.getClass().getPackage().getName() + ".log",
                this.getClass().getSimpleName()
        );
    }

    @After
    public void tearDown() {
//        sleep(5000);
        driver.quit();
    }

    protected void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            logger.log(FATAL, e.toString());
            e.printStackTrace();
            System.exit(1);
        }
    }

    protected void waitForElement(By locator) {
        sleep(IMPLICIT_WAIT_TIME_MS); // just to be sure
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}