package project.my_f_sal;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import project.MyLogger;
import project.SeleniumTest;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.fail;

public class AddToCartPageTest extends SeleniumTest {

    @Test
    public void invalidAdded() {
        initDefaults();
        login();
        sleep(1000);
        clickElementSafely(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/div"));
        sleep(2000);

        clickElementSafely(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]"));
        sleep(2000);
        driver.switchTo().alert().accept();
        sleep(2000);

        driver.get("https://demoqa.com/profile");
        try {
            assertFalse(driver.findElement(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a")).isDisplayed());
        } catch (NoSuchElementException e) {
            logger.log(MyLogger.LogLevel.DEBUG, "even its shouldn't be, its on list");
        }
        sleep(1000);

    }

    @Test
    public void validAdded() {
        initDefaults();
        login();
        sleep(1000);
        clickElementSafely(By.cssSelector("#see-book-Git\\ Pocket\\ Guide > a"));
        sleep(2000);

        clickElementSafely(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]"));
        sleep(2000);
        driver.switchTo().alert().accept();
        sleep(2000);

        driver.get("https://demoqa.com/profile");
        try {
            assertTrue(driver.findElement(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a")).isDisplayed());
        } catch (NoSuchElementException e) {
            fail("didn't show in list");
        }
        sleep(1000);
    }


}
