package com.Login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLogin {

    @Test
    public void testConstructorWithFields() {
        Login log = new Login("Adam", "Yes");
        Assertions.assertEquals("Adam", log.getuserName());
        Assertions.assertEquals("Yes", log.getpassWord());
    }

    @Test
    public void testUsernameShouldBeAdam() {
        Login log = new Login();
        log.setuserName("Adam");
        Assertions.assertEquals("Adam", log.getuserName());
    }

    @Test
    public void testUsernameShouldBeNull() {
        Login log = new Login();
        log.setuserName(null);
        Assertions.assertNull(log.getuserName());
    }

    @Test
    public void testUsernameShouldBeEmpty() {
        Login log = new Login();
        log.setuserName("");
        Assertions.assertTrue(log.getuserName().length() == 0);
    }

    @Test
    public void testPasswordShouldBeYes() {
        Login log = new Login();
        log.setpassWord("Yes");
        Assertions.assertEquals("Yes", log.getpassWord());
    }

    @Test
    public void testPasswordShouldBeNull() {
        Login log = new Login();
        log.setpassWord(null);
        Assertions.assertNull(log.getpassWord());
    }

    @Test
    public void testPasswordShouldBeEmpty() {
        Login log = new Login();
        log.setpassWord("");
        Assertions.assertTrue(log.getpassWord().length() == 0);
    }

}
