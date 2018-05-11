package dengluzhuce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLogin {
	String drv = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/yuzexing";
	String usr = "root";
	String pwd = "root";

	public boolean isuserLogin(String id, String password) throws SQLException {
		boolean isValid = false;
		String sql = "select * from login where uname='" + id + "' and password='" + password + "'";

		try {
			Class.forName(drv).newInstance();
			// Connection conn = DriverManager.getConnection(url);
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				isValid = true;
			}

			rs.close();
			stm.close();
			conn.close();

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * finally { if(rs!=null) { rs.close(); } }
			 */

		return isValid;
	}

}
