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
			if(querySet.getQueryValues(i) instanceof String){
				pstmt.setObject(i+1, querySet.getQueryValues(i));
			}else if(querySet.getQueryValues(i) instanceof Integer){
				pstmt.setObject(i+1, querySet.getQueryValues(i));
			} else if (querySet.getQueryValues(i) instanceof Timestamp) {
				pstmt.setObject(i+1, querySet.getQueryValues(i));
			}
		}
	}
	
	 private ResultSet selectQuery(PreparedStatement pstmt) throws SQLException {
		 rs = pstmt.executeQuery();
		 return rs;
	 }
	
	 private void setQuery(PstmtQuerySet querySet) throws SQLException{
		 conn = iDBconn.getConnection();
		 pstmt = conn.prepareStatement(querySet.getSql());
		 
		 setParameter(querySet);		 
	
		 if(querySet.getSql().split(" ")[0].equalsIgnoreCase("SELECT")){
			 if(rs.next())
				 return true;
		 } else {
			 pstmt.executeUpdate();
			 return true;
		 }
	 }
	 
	 private void selectQuery(PstmtQuerySet querySet) {
		 
	 }
	 
	public boolean runQuery(PstmtQuerySet querySet) throws SQLException{
		try{
			
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
