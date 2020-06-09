package model;

import java.util.Date;

public class ManagerSignup {
	private String mid;
	private String name;
	private String email;
	private String number;
	private String password;
	private String confirmpassword;
	private Date signupDate;

	// constructor with all signup parameter
	public ManagerSignup(String mid, String email, String name, String number, String password,
			String confirmpassword) {
		super();
		this.mid = mid;
		this.email = email;
		this.name = name;
		this.number = number;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}

	// constructor for login
	public ManagerSignup(String email, String number) {
		super();
		this.email = email;
		this.password = number;
	}

	// getter and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}
}
