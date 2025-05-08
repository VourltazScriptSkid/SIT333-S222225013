package web.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for LoginService.java
 */
public class LoginUnitTest {

    @Test
    public void testValidLogin() {
        boolean result = LoginService.login("andrei", "andrei_pass", "01-03-2003");
        Assert.assertTrue("Valid login should return true", result);
    }

    @Test
    public void testInvalidUsername() {
        boolean result = LoginService.login("wronguser", "andrei_pass", "01-03-2003");
        Assert.assertFalse("Invalid username should return false", result);
    }

    @Test
    public void testInvalidPassword() {
        boolean result = LoginService.login("andrei", "wrongpass", "01-03-2003");
        Assert.assertFalse("Invalid password should return false", result);
    }

    @Test
    public void testInvalidDob() {
        boolean result = LoginService.login("andrei", "andrei_pass", "2003-03-02");
        Assert.assertFalse("Invalid dob should return false", result);
    }

    @Test
    public void testAllInvalid() {
        boolean result = LoginService.login("user", "pass", "15-12-1990");
        Assert.assertFalse("All fields invalid should return false", result);
    }

    @Test
    public void testEmptyUsername() {
        boolean result = LoginService.login("", "andrei_pass", "01-03-2003");
        Assert.assertFalse("Empty username should return false", result);
    }

    @Test
    public void testEmptyPassword() {
        boolean result = LoginService.login("andrei", "", "2003-03-01");
        Assert.assertFalse("Empty password should return false", result);
    }

    @Test
    public void testEmptyDob() {
        boolean result = LoginService.login("andrei", "andrei_pass", "");
        Assert.assertFalse("Empty dob should return false", result);
    }

    @Test
    public void testNullValues() {
        boolean result = LoginService.login(null, null, null);
        Assert.assertFalse("Null values should return false", result);
    }

    @Test
    public void testWhitespaceInput() {
        boolean result = LoginService.login("  ", "  ", "  ");
        Assert.assertFalse("Whitespace-only inputs should return false", result);
    }
    


}
