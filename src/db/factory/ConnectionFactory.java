package db.factory;

import db.connection.DevConnection;
import db.connection.IDBConnection;

public class ConnectionFactory {
	public IDBConnection makeConnection(String targetDB) {
		if (targetDB.equals("dev")) {
			return new DevConnection();
		} else {
			return null;
		}
	}
}