package project.my_f_sal;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import project.SeleniumTest;

import static org.junit.Assert.*;
import static project.MyLogger.LogLevel.INFO;

public class LoginTest extends SeleniumTest {
    @Test
    public void validLogin() {
        initDefaults();
        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("userName")).sendKeys("mao"); // user: mao
        driver.findElement(By.id("password")).sendKeys("Ntur123123!"); // pass: Ntur123123!
        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
        sleep(1000);
        try {
            assertFalse("didnt get the next page", driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[4]/div[1]/button")).isDisplayed());
        } catch (NoSuchElementException e) {
            logger.log(INFO, "the next page uploaded");
        }
    }

    @Test
    public void invalidLogin() {
        initDefaults();
        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("userName")).sendKeys("omer");
        driver.findElement(By.id("password")).sendKeys("Ssad13%$");
        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
        sleep(1000);
        try {
            assertTrue("did get the next page", driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[4]/div[1]/button")).isDisplayed());
        } catch (NoSuchElementException e) {
            fail("did get the next page");
        }
    }
}