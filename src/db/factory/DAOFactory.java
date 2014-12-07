/**  : 
 * @FileName : DAOFactory.java
 * @Package : dbconnection
 * @작성자  : hataeho
 */
package db.factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import db.config.SelectDB;
import db.connection.IDBConnection;
import db.query.PstmtQuerySet;

public class DAOFactory extends SelectDB {
	ConnectionFactory factory; 
	IDBConnection iDBconn = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public DAOFactory() {
		factory = new ConnectionFactory();
		iDBconn = factory.makeConnection(targetDB);
	}
	
	public boolean runQuery(PstmtQuerySet querySet) throws SQLException{
		try{
			conn = iDBconn.getConnection();
			pstmt = conn.prepareStatement(querySet.getSql());
			
			for(int i = 0; i < querySet.getQuerySetLength(); i++) {
				if(querySet.getQueryValues(i) instanceof String){
					pstmt.setString(i+1, (String)querySet.getQueryValues(i));
				}else if(querySet.getQueryValues(i) instanceof Integer){
					pstmt.setInt(i+1, Integer.parseInt((String) querySet.getQueryValues(i)));
				} else if (querySet.getQueryValues(i) instanceof Timestamp) {
					pstmt.setTimestamp(i+1, (Timestamp)querySet.getQueryValues(i));
				}
			}
			
			if(querySet.getSql().split(" ")[0].equalsIgnoreCase("SELECT")){
				rs = pstmt.executeQuery();
				if(rs.next())
					return true;
			} else {
				pstmt.executeUpdate();
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnections();
		}
		return false;
	}
	
	public void closeConnections() throws SQLException{
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}
}
