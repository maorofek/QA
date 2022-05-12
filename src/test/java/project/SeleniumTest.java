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

import static org.junit.Assert.assertFalse;
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
        driver.manage().window().setSize(new Dimension(1920, 1080));
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
        sleep(1000);
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

    protected boolean isAlertPresent() {
        try {
            sleep(IMPLICIT_WAIT_TIME_MS); // give time for alert to pop
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public void login() {
        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("userName")).sendKeys("mao"); // user: mao
        driver.findElement(By.id("password")).sendKeys("Ntur123123!"); // pass: Ntur123123!
        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
        sleep(2000);
        try {
            assertFalse("didnt get the next page", driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[4]/div[1]/button")).isDisplayed());
        } catch (NoSuchElementException e) {
            logger.log(INFO, "the next page uploaded");
        }
    }

    protected void clickElementSafely(By locator) {
        waitForElement(locator); // just to be sure
        driverWait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
}