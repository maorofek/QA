package project.my_f_sal;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import project.MyLogger;
import project.SeleniumTest;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

public class NextPageTest extends SeleniumTest {

    @Test
    public void getTheCorrectPage() {
        String bookName = "Git Pocket Guide";
        initDefaults();
        clickElementSafely(By.cssSelector("#see-book-Git\\ Pocket\\ Guide > a"));
        sleep(2000);

        System.out.println(driver.findElement(By.xpath("//*[@id=\"title-wrapper\"]/div[2]")).getText());
        try {
            assertEquals(driver.findElement(By.xpath("//*[@id=\"title-wrapper\"]/div[2]")).getText(), bookName);
        } catch (NoSuchElementException e) {
            logger.log(MyLogger.LogLevel.DEBUG, "Wrong page !");
        }
    }

    @Test
    public void getTheWrongPage() {
        String bookName = "xxXX";
        initDefaults();
        clickElementSafely(By.cssSelector("#see-book-Git\\ Pocket\\ Guide > a"));
        sleep(2000);

        System.out.println(driver.findElement(By.xpath("//*[@id=\"title-wrapper\"]/div[2]")).getText());
        try {
            assertNotEquals(driver.findElement(By.xpath("//*[@id=\"title-wrapper\"]/div[2]")).getText(), bookName);
        } catch (NoSuchElementException e) {
            logger.log(MyLogger.LogLevel.DEBUG, "Wrong page !");
        }
    }
}
