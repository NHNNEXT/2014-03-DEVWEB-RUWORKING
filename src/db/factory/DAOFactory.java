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
	
	private void setParameter(PstmtQuerySet querySet) throws SQLException{
		for(int i = 0; i < querySet.getQuerySetLength(); i++) {
			pstmt.setObject(i+1, querySet.getQueryValues(i));
		}
	}
	
	 public ResultSet selectQuery(PstmtQuerySet querySet) throws SQLException {
		 try {
			 conn = iDBconn.getConnection();
			 pstmt = conn.prepareStatement(querySet.getSql());
			 
			 setParameter(querySet);	
		 }catch(SQLException e) {
			 e.printStackTrace();
		 } 
		 return pstmt.executeQuery();
	 }
	 
	 public boolean nonSelectQuery(PstmtQuerySet querySet) throws SQLException {
		try {
			conn = iDBconn.getConnection();
			pstmt = conn.prepareStatement(querySet.getSql());
			
			setParameter(querySet);	
			pstmt.executeUpdate();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	 }
	
	public void closeConnections() throws SQLException{
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}
}
