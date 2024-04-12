package com.Registration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRegistration {

    @Test
    public void testConstructorWithFields() {
        Registration log = new Registration("Adam", "Yes");
        Assertions.assertEquals("Adam", log.getuserName());
        Assertions.assertEquals("Yes", log.getpassWord());
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
}