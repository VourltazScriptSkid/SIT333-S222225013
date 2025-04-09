package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "S222225013";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Andrei";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
    }
	
	/*
	 * Write more test functions below.
	 */
	
	@Test
	public void testEmptyUsernameWrongPassword() {
	    LoginStatus status = LoginForm.login(null, "wrong");
	    Assert.assertFalse(status.isLoginSuccess());
	    Assert.assertEquals("Empty Username", status.getErrorMsg());
	}

	@Test
	public void testWrongUsernameWrongPassword() {
	    LoginStatus status = LoginForm.login("wrong", "wrong");
	    Assert.assertFalse(status.isLoginSuccess());
	    Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}

	@Test
	public void testCorrectUsernameEmptyPassword() {
	    LoginStatus status = LoginForm.login("andrei", null);
	    Assert.assertFalse(status.isLoginSuccess());
	    Assert.assertEquals("Empty Password", status.getErrorMsg());
	}

	@Test
	public void testCorrectUsernameWrongPassword() {
	    LoginStatus status = LoginForm.login("andrei", "wrong");
	    Assert.assertFalse(status.isLoginSuccess());
	    Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}

	@Test
	public void testEmptyUsernameCorrectPassword() {
	    LoginStatus status = LoginForm.login(null, "andrei_pass");
	    Assert.assertFalse(status.isLoginSuccess());
	    Assert.assertEquals("Empty Username", status.getErrorMsg());
	}

	@Test
	public void testWrongUsernameCorrectPassword() {
	    LoginStatus status = LoginForm.login("wrong", "andrei_pass");
	    Assert.assertFalse(status.isLoginSuccess());
	    Assert.assertEquals("Credential mismatch", status.getErrorMsg());
	}

	@Test
	public void testCorrectCredentialsWrongValidationCode() {
	    LoginStatus status = LoginForm.login("andrei", "andrei_pass");
	    Assert.assertTrue(status.isLoginSuccess());

	    boolean codeValid = LoginForm.validateCode("wrongcode");
	    Assert.assertFalse(codeValid);
	}

	@Test
	public void testCorrectCredentialsCorrectValidationCode() {
	    LoginStatus status = LoginForm.login("andrei", "andrei_pass");
	    Assert.assertTrue(status.isLoginSuccess());

	    boolean codeValid = LoginForm.validateCode("123456");
	    Assert.assertTrue(codeValid);
	}

	
}
