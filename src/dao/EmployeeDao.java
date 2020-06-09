package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import businesslogic.CalculateNetSalary;
import model.EmployeeDetail;
import utility.ConnectionManager;

public class EmployeeDao implements EmployeeDaoInterface {
	Connection con = null;
	PreparedStatement stat = null;
	int rs;

	SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY");

	private static java.sql.Date getDate() {
		java.util.Date date = new java.util.Date();
		return new java.sql.Date(date.getTime());
	}

	public int addEmp(EmployeeDetail emp) throws ParseException {
		String sql = "Insert into employee(eid,name,email,pan,password,doteofjoining,jobtitle,department"
				+ ",address,annualctc,accountnumber) " + "values(?,?,?,?,?,?,?,?,?,?,?)";

		java.util.Date myDate = format.parse(emp.getDateofjoining());

		try {
			con = ConnectionManager.getConnection();
			stat = con.prepareStatement(sql);
			stat.setString(1, emp.getEmployeeid());
			stat.setString(2, emp.getName());
			stat.setString(3, emp.getEmail());
			stat.setString(4, emp.getPan());
			stat.setString(5, emp.getPassword());
			java.sql.Date sqldat = new java.sql.Date(myDate.getTime());
			stat.setDate(6, sqldat);
			stat.setString(7, emp.getJobtitle());
			stat.setString(8, emp.getDepartment());
			stat.setString(9, emp.getCurrentaddress());
			stat.setDouble(10, emp.getAnnualctc());
			stat.setLong(11, emp.getAccountdetail());
			rs = stat.executeUpdate();
			System.out.println("Employee details added");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("please enter valid details");
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		return rs;
	}

	@Override
	public void deleteEmp(String id) {

		String sql = "Delete from employee where eid=?";

		try {
			con = ConnectionManager.getConnection();
			stat = con.prepareStatement(sql);
			stat.setString(1, id);
			// System.out.println(stat);
			stat.executeUpdate();
			if (rs > 0)
				System.out.println("Deleted");
//			else
//				System.out.println("not deleted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}

	@Override
	public boolean checkLogin(EmployeeDetail emp) {
		String sql = "select * from employee where email=? and password=?";
		try {
			con = ConnectionManager.getConnection();
			stat = con.prepareStatement(sql);
			stat.setString(1, emp.getEmail());
			stat.setString(2, emp.getPassword());
			ResultSet rs = stat.executeQuery();
			boolean status = rs.next();
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("ERROR !");
		} catch (SQLException e) {
			System.out.println("ERROR !");
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR !");
			// e.printStackTrace();
		}
		return false;
	}

	@Override
	public HashSet<EmployeeDetail> readEmp() {
		String sql = "select * from employee";
		try {
			con = ConnectionManager.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			HashSet<EmployeeDetail> employee = new HashSet<>();
			DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyy");
			// get current date time with Date()
			Date date = new Date();
			System.out.print("EID \t" + "\t" + "NAME \t" + "\t" + "  EMAIL \t" + "\t" + "PAN NO. \t" + "\t" + "JOB  \t"
					+ "\t" + "  DEPARTMENT \t" + "\t" + " ADDRESS \t" + "\t" + " ANNUAL CTC \t ACCOUNT");
			System.out.println();
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------");
			while (rs.next()) {
				String eid = (rs.getString("eid"));
				String mail = (rs.getString("email"));
				String name = (rs.getString("name"));
				String pan = (rs.getString("pan"));
				// System.out.print(rs.getString()) + "\t");
				String job = (rs.getString("jobtitle"));
				String dept = (rs.getString("department"));
				String add = (rs.getString("address"));
				double ctc = (rs.getDouble("annualctc"));
				long num = (rs.getLong("accountnumber"));
				System.out.println(eid + "\t" + name + "\t" + mail + "\t" + pan + "\t" + job + "\t" + dept + "\t" + add
						+ "\t" + ctc + "\t" + num);
				System.out.println(
						"------------------------------------------------------------------------------------------------------------------------------------------------------------");

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return null;

	}

	@Override
	public void updateEmp(String id, double ctc) {

		String sql = "Update employee set annualctc=?  where eid=?";

		try {
			con = ConnectionManager.getConnection();
			stat = con.prepareStatement(sql);
			stat.setDouble(1, ctc);
			stat.setString(2, id);

			int rs = stat.executeUpdate();
			if (rs > 0)
				System.out.println("Updated");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}

	@Override
	public double calculateSalary(String id) {
		double annual = 0;
		String sql1 = "Select annualctc  from employee where eid=?";

		// System.out.println(id);
		try {
			con = ConnectionManager.getConnection();
			stat = con.prepareStatement(sql1);
			stat.setString(1, id);

			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				// String eid = rs.getString("eid");
				annual = rs.getDouble("annualctc");
				// System.out.println(annual);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		CalculateNetSalary cs = new CalculateNetSalary();
		double salary = cs.calculate(annual);
		System.out.println("Monthly salary of this employee= " + salary);
		return salary;
	}

	@Override
	public void generatePaySlip(String empid) {

	}

	public void storeSalary(String id, double salary) {
		String sql = "Update salarycalculation set salary=? where sid=?";
		try {
			con = ConnectionManager.getConnection();
			stat = con.prepareStatement(sql);
			stat.setDouble(1, salary);
			// stat.setDate(2, getDate());
			stat.setString(2, id);
			System.out.println("Salary Updated !");
			// System.out.println(stat);
			rs = stat.executeUpdate();

			// System.out.println("rs value=" + rs);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}

	@Override
	public String search(String id) {
		String query = "Select * from employee where eid=?";
		String eid = "";
		try {
			con = ConnectionManager.getConnection();
			stat = con.prepareStatement(query);
			stat.setString(1, id);
			ResultSet rs = stat.executeQuery();
			// System.out.println(rs);
			while (rs.next()) {
				// System.out.println("into rs while loop");
				eid = rs.getString("eid");
				// System.out.println("Getting EID" + eid);
			}
		} catch (ClassNotFoundException e) {

			// e.printStackTrace();
		} catch (SQLException e) {

			// e.printStackTrace();
		} catch (IOException e) {

			// e.printStackTrace();
		}

		return eid;
	}

	@Override
	public String searchSal(String id) {

		String query = "Select * from salarycalculation where sid='" + id + "'";
		String eid = "";
		try {
			con = ConnectionManager.getConnection();
			Statement stat = con.createStatement();
			// stat.setString(1, id);
			// System.out.println(query);
			ResultSet rs = stat.executeQuery(query);
			while (rs.next()) {
				// System.out.println("in while");
				eid = rs.getString(1);
				// System.out.println("Value of eid in while loop=" + eid);
			}

		} catch (ClassNotFoundException e) {

			// e.printStackTrace();
		} catch (SQLException e) {

			// e.printStackTrace();
		} catch (IOException e) {

			// e.printStackTrace();
		}

		return eid;
	}

	@Override
	public void markAttendence(String id) {
		// Date d = getDate();
		try {
			con = ConnectionManager.getConnection();
			Statement statement = con.createStatement();
			String sql2 = "UPDATE attendence SET STATUS = 'PRESENT' WHERE EID = " + "'" + id.trim() + "'";
			rs = statement.executeUpdate(sql2);
			if (rs > 0)
				System.out.println("Attendence Sheet Updated");
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		} catch (SQLException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	@Override
	public void readAttendence() {
		String sql = "Select * from attendence";

		try {
			System.out.println("Read attendenace");
			con = ConnectionManager.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("ID \t EID \t STATUS");
			System.out.println("----------------------------");
			while (rs.next()) {
				String id = rs.getString(1);
				String eid = rs.getString(2);
				String stat = rs.getString(3);

				System.out.println(id + "\t" + eid + "\t" + stat);
				System.out.println("---------------------------------");

			}

		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		} catch (SQLException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	public String searchAttendence(String ee) {

		String query = "Select * from employee where eid=?";
		String eid = "";
		try {
			con = ConnectionManager.getConnection();
			stat = con.prepareStatement(query);
			stat.setString(1, ee);
			ResultSet rs = stat.executeQuery();
			// System.out.println(rs);
			while (rs.next()) {
				// System.out.println("into rs while loop");
				eid = rs.getString("eid");
				// System.out.println("Getting EID" + eid);
			}
		} catch (ClassNotFoundException e) {

			// e.printStackTrace();
		} catch (SQLException e) {

			// e.printStackTrace();
		} catch (IOException e) {

			// e.printStackTrace();
		}

		return eid;

	}

}