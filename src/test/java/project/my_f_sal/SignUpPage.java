package project.my_f_sal;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import project.SeleniumTest;

public class SignUpPage extends SeleniumTest {

    @Test
    public void validSignUpPage() {
        initDefaults();
        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("newUser")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("firstname")).sendKeys("Gandalf");
        driver.findElement(By.id("lastname")).sendKeys("The King");
        driver.findElement(By.id("userName")).sendKeys("Gandalf2K");
        driver.findElement(By.id("password")).sendKeys("Maor12354");
        // driver.findElement(By.id("recaptcha-anchor")).sendKeys(Keys.ENTER);
        sleep(5000);

        driver.findElement(By.id("register")).sendKeys(Keys.ENTER);
        sleep(5000);
        //driver.findElement(By.xpath(); //

    }

    public void invalidSignUpPage() {
        initDefaults();
        driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
    }

}
