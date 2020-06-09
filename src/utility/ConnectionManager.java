package utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		final String driver = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String username = "SYSTEM";
		final String password = "Varsha080694";
		// System.out.println(username);
		// System.out.println(password);
		Class.forName(driver);
		Connection con = null;
		con = DriverManager.getConnection(url, username, password);
		// if (con != null)
		// System.out.println("Connection established...");
		// else
		// System.out.println("Check your connection please...");
		return con;

	}

}
