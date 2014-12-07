package db.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DevConnection implements IDBConnection{
	public Connection getConnection() {
		String url = "jdbc:mysql://172.16.93.153:3306/DEVWEB";
		String id = "popi";
		String pw = "db1004";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
