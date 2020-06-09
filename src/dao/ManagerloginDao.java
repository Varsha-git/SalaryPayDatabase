package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.ManagerSignup;
import utility.ConnectionManager;

public class ManagerloginDao implements ManagerDaointerface {
	Connection con = null;
	PreparedStatement stat;

	// this method is define to convert string date into sql date to store in
	// database
	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	// manager Sign up details inserting into database
	@Override
	public int signUp(ManagerSignup mlogin) {
		// System.out.println("into sign up method");
		String sql = "INSERT INTO MANAGERLOGIN(MID,EMAIL,NAME,PHONENUMBER,PASSWORD,SIGNUPDATE)" + "VALUES(?,?,?,?,?,?)";
		int rs = 0;
		try {
			con = ConnectionManager.getConnection();
			stat = con.prepareStatement(sql);
			stat.setString(1, mlogin.getMid());
			stat.setString(2, mlogin.getEmail());
			stat.setString(3, mlogin.getName());
			stat.setString(4, mlogin.getNumber());
			stat.setString(5, mlogin.getPassword());
			stat.setDate(6, getCurrentDate());
			rs = stat.executeUpdate();
			System.out.println("SIGN UP COMPLETE. GO TO LOGIN PAGE ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public boolean login(ManagerSignup login) {
		boolean status = false;
		String query = "select * from managerlogin where email = ? and password = ?";
		con = null;
		try {
			con = ConnectionManager.getConnection();
			stat = con.prepareStatement(query);
			stat.setString(1, login.getEmail());
			stat.setString(2, login.getPassword());

			// System.out.println(login.getEmail());
			// System.out.println(login.getPassword());

			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(status);
		return status;
	}
}
