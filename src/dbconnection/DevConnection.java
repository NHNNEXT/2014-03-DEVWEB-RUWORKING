package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DevConnection implements IDBConnection{
	public Connection getConnection() {
		String url = "jdbc:mysql://10.73.45.132:3306/dev";
		String id = "developer";
		String pw = "pwruworkingpw";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
