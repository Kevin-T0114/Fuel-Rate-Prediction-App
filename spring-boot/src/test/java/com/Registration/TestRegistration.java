package com.Registration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRegistration {

    @Test
    public void testConstructorWithFields() {
        Registration log = new Registration("Adam", "Yes", "Yes", true);
        Assertions.assertEquals("Adam", log.getuserName());
        Assertions.assertEquals("Yes", log.getpassWord());
        Assertions.assertEquals("Yes", log.getvfyPassword());
        Assertions.assertTrue(log.isuserExists());
    }

    @Test
    public void testUsernameShouldBeAdam() {
        Registration reg = new Registration();
        reg.setuserName("Adam");
        Assertions.assertEquals("Adam", reg.getuserName());
    }

    @Test
    public void testUsernameShouldBeNull() {
        Registration reg = new Registration();
        reg.setuserName(null);
        Assertions.assertNull(reg.getuserName());
    }

    @Test
    public void testUsernameShouldBeEmpty() {
        Registration reg = new Registration();
        reg.setuserName("");
        Assertions.assertTrue(reg.getuserName().length() == 0);
    }

    @Test
    public void testPasswordShouldBeYes() {
        Registration reg = new Registration();
        reg.setpassWord("Yes");
        Assertions.assertEquals("Yes", reg.getpassWord());
    }

    @Test
    public void testPasswordShouldBeNull() {
        Registration reg = new Registration();
        reg.setpassWord(null);
        Assertions.assertNull(reg.getpassWord());
    }

    @Test
    public void testPasswordShouldBeEmpty() {
        Registration reg = new Registration();
        reg.setpassWord("");
        Assertions.assertTrue(reg.getpassWord().length() == 0);
    }

    @Test
    public void testVfyPasswordShouldBeEmpty() {
        Registration reg = new Registration();
        reg.setvfyPassword("");
        Assertions.assertTrue(reg.getvfyPassword().length() == 0);
    }

    @Test
    public void testVfyPasswordShouldBeYes() {
        Registration reg = new Registration();
        reg.setvfyPassword("Yes");
        Assertions.assertEquals("Yes", reg.getvfyPassword());
    }

    @Test
    public void testVfyPasswordShouldBeNull() {
        Registration reg = new Registration();
        reg.setvfyPassword(null);
        Assertions.assertNull(reg.getvfyPassword());
    }

    @Test
    public void testUserDoesExist() {
        Registration reg = new Registration();
        reg.setuserExists(true);
        Assertions.assertTrue(reg.isuserExists());
    }

    @Test
    public void testUserDoesNotExist() {
        Registration reg = new Registration();
        reg.setuserExists(false);
        Assertions.assertFalse(reg.isuserExists());
    }
}
