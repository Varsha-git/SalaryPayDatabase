package model;

public class EmployeeDetail {
	private String employeeid;
	private String name;
	private String email;
	private String pan;
	private String password;
	private String dateofjoining;
	private String jobtitle;
	private String department;
	private String currentaddress;
	private double annualctc;
	private long accountdetail;

	public EmployeeDetail(String employeeid, String name, String email, String pan, String jobtitle, String department,
			double annualctc, long accountdetail) {
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.email = email;
		this.pan = pan;
		this.jobtitle = jobtitle;
		this.department = department;
		this.annualctc = annualctc;
		this.accountdetail = accountdetail;
	}

	// constructor for adding details into table of database
	public EmployeeDetail(String employeeid, String name, String emai, String pan, String password,
			String dateofjoining, String jobtitle, String depart, String currentadd, double ctc, long acc) {
		super();
		this.employeeid = employeeid;
		this.name = name;
		this.email = emai;
		this.pan = pan;
		this.password = password;
		this.dateofjoining = dateofjoining;
		this.jobtitle = jobtitle;
		this.department = depart;
		this.currentaddress = currentadd;
		this.annualctc = ctc;
		this.accountdetail = acc;
	}

	// constructor for login
	public EmployeeDetail(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	// getter and setter
	public String getCurrentaddress() {
		return currentaddress;
	}

	public void setCurrentaddress(String currentaddress) {
		this.currentaddress = currentaddress;
	}

	public double getAnnualctc() {
		return annualctc;
	}

	public void setAnnualctc(double annualctc) {
		this.annualctc = annualctc;
	}

	public long getAccountdetail() {
		return accountdetail;
	}

	public void setAccountdetail(long accountdetail) {
		this.accountdetail = accountdetail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getDateofjoining() {
		return dateofjoining;
	}

	public void setDateofjoining(String dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
