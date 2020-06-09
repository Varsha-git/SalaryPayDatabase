package dao;

import java.text.ParseException;
import java.util.HashSet;

import model.EmployeeDetail;

public interface EmployeeDaoInterface {

	public String searchSal(String id);

	public int addEmp(EmployeeDetail emp) throws ParseException;

	public String search(String id);

	public void deleteEmp(String id);

	public boolean checkLogin(EmployeeDetail emp);

	public HashSet<EmployeeDetail> readEmp();

	public void readAttendence();

	public void updateEmp(String id, double ctc);

	public double calculateSalary(String id);

	public void generatePaySlip(String empid);

	public void storeSalary(String ide, double salary);

	void markAttendence(String id);
}
