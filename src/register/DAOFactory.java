package register;

import dbconnection.DevConnection;
import dbconnection.IDBConnection;

public class DAOFactory {
	public IDBConnection makeConnection(String targetDB) {
		if (targetDB.equals("dev")) {
			return new DevConnection();
		} else {
			return null;
		}
	}
}
