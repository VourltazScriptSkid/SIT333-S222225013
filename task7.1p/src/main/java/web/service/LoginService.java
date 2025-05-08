package web.service;

/**
 * Business logic to handle login functions.
 */
public class LoginService {

    /**
     * Static method returns true for successful login, false otherwise.
     *
     * @param username the username
     * @param password the password
     * @param dob      date of birth in yyyy-mm-dd format
     * @return true if credentials match, false otherwise
     */
    public static boolean login(String username, String password, String dob) {
        // Simple input validation (null or empty check)
        if (username == null || password == null || dob == null) return false;
        if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) return false;

        // Hardcoded correct credentials
        String validUsername = "andrei";
        String validPassword = "andrei_pass";
        String validDob = "01-03-2003";

        return username.equals(validUsername) &&
               password.equals(validPassword) &&
               dob.equals(validDob);
    }
}
