package businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerLoginValidation {

	private static final String PASSWORD_PATTERN = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})$";
	String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	String regexnumber = "(0/91)?[6-9][0-9]{9}";
	private Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
	private Pattern pattern2 = Pattern.compile(regex);
	private Pattern pattern3 = Pattern.compile(regexnumber);
	private Matcher matcher1, matcher2;

	public boolean checkManagerSignup(String email, String number, String password, String confirmPassword) {
		if (validEmail(email) && validConfPassword(password, confirmPassword) && validMobile(number))
			return true;
		else
			return false;
	}

	public boolean checkEmployeeLogin(String email, String password) {
		if ((validPassword(password)) && (validEmail(email))) {
			// System.out.println("Correct detail");
			return true;
		} else {
			System.out.println("InCorrect detail");
			return false;
		}
	}

	public boolean checkManagerLogin(String email, String password) {
		if ((validPassword(password)) && (validEmail(email)))
			return true;
		else
			return false;
	}

	public boolean validPassword(String password) {
		if (pattern.matcher(password).matches()) {
			// System.out.println("Password pattern matched");
			return true;
		} else {
			System.out.println("Incorrect pattern.. enter atleast 1 Uppercase and 1 digit");
			return false;
		}
	}

	public boolean validConfPassword(String password, String confirmPassword) {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		if (password.equals(confirmPassword)) {
			matcher1 = pattern.matcher(password);
			matcher2 = pattern.matcher(confirmPassword);
			// System.out.println(matcher1);
			// System.out.println(matcher2);
			if (matcher1.matches() && matcher2.matches()) {
				// System.out.println("password pattern matches");
			} else
				System.out.println("Minimum 6 character required.");
			return true;
		} else {
			System.out.println("both password do not match");
			return false;
		}
	}

	public boolean validEmail(String email) {

		if (pattern2.matcher(email).matches()) {
			// System.out.println("correct pattern");
			return true;
		} else {
			System.out.println("Incorrect pattern of e-mail");
			return false;
		}
	}

	public boolean validMobile(String number) {

		if (pattern3.matcher(number).matches()) {
			// System.out.println("correct number pattern");
			return true;
		} else {
			System.out.println("Enter 10digit number starting with 6/7/8/9");
			return false;
		}
	}
}
