package model;

public class EmployeeLogin {

	private String email;
	private String password;
	private String employeeid;
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmployeeLogin(String employeeid,String email, String password) {
		super();
		this.employeeid=employeeid;
		this.email = email;
		this.password = password;
	}
	
}
