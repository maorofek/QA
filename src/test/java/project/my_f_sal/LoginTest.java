package project.my_f_sal;

import org.junit.Test;

public class LoginTest extends LoginPage {

    @Test
    public void validLoginTest() {
        validLogin();
    }

    @Test
    public void invalidLoginTest() {
        invalidLogin();
    }
}