package project.my_f_sal;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import project.MyLogger;
import project.SeleniumTest;

import static org.junit.Assert.fail;
import static project.MyLogger.LogLevel.INFO;

public class LoginTest extends SeleniumTest {
    @Test
    public void firstAction() {
        initDefaults();
        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("userName")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);

        waitForElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[4]/div[1]/button"));
        if (driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[4]/div[1]/button")).isDisplayed()) {
            logger.log(INFO, "didnt get the next page");
        } else {
            logger.log(INFO, "the next page uploaded");
        }
    }
}