package com.example.springboot.Login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLogin {

    @Test
    public void testConstructorWithFields() {
        Login log = new Login("Adam", "Yes", true, true);
        Assertions.assertEquals("Adam", log.getuserName());
        Assertions.assertEquals("Yes", log.getpassWord());
        Assertions.assertTrue(log.isuserExists());
        Assertions.assertTrue(log.iscorrectPass());
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

    @Test
    public void testUserDoesExist() {
        Login log = new Login();
        log.setuserExists(true);
        Assertions.assertTrue(log.isuserExists());
    }

    @Test
    public void testUserDoesNotExist() {
        Login log = new Login();
        log.setuserExists(false);
        Assertions.assertFalse(log.isuserExists());
    }

    @Test
    public void testCorrectPassword() {
        Login log = new Login();
        log.setcorrectPass(true);
        Assertions.assertTrue(log.iscorrectPass());
    }

    @Test
    public void testIncorrectPassword() {
        Login log = new Login();
        log.setcorrectPass(false);
        Assertions.assertFalse(log.iscorrectPass());
    }

}
