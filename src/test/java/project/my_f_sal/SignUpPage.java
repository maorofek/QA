package project.my_f_sal;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.SeleniumTest;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static project.MyLogger.LogLevel.INFO;

public class SignUpPage extends SeleniumTest {

//    @Test
//    public void validSignUpPage() {
//        initDefaults();
//        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
//        driver.findElement(By.id("newUser")).sendKeys(Keys.ENTER);
//        driver.findElement(By.id("firstname")).sendKeys("Gandalf12s123123asd");
//        driver.findElement(By.id("lastname")).sendKeys("The King");
//        driver.findElement(By.id("userName")).sendKeys("Gandalf2K1231");
//        driver.findElement(By.id("password")).sendKeys("Maor12354!");
//
////        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
////        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"recaptcha-anchor\"]"))).click();
//
//        sleep(5000); // solve manual recaptcha
//
//        driver.findElement(By.id("register")).sendKeys(Keys.ENTER);
//        sleep(3000);
//
//        assertTrue("didnt get the next page", isAlertPresent());
//        driver.switchTo().alert().accept();
//
//    }
//
//    public void invalidSignUpPage() {
//        initDefaults();
//        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
//    }

}
