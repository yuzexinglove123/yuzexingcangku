package dengluzhuce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Register {

	String drv = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/yuzexing";
	String usr = "root";
	String pwd = "root";

	public boolean userregister(String id, String password, String email) {

		boolean b = false;

		String sql = "select * from login where uname='" + id + "'";

		try {
			Class.forName(drv).newInstance();
			Connection conn = DriverManager.getConnection(url, usr, pwd);
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			if (!rs.next()) {

				sql = "insert into login(uname,password,email) values('" + id + "','" + password + "','" + email
						+ "')";
				stm.execute(sql);
				b = true;
			}

			rs.close();
			stm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

		if (b) {
			return true;
		} else
			return false;
	}
}
