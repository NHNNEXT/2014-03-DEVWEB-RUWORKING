package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconnection.IDBConnection;

public class UserDAO {
	DAOFactory factory; 
	IDBConnection con;
	public UserDAO(String targetDB) {
		factory = new DAOFactory();
		con = factory.makeConnection(targetDB);
	}
	
	public void addUser(User user) throws SQLException {
		String sql = "INSERT INTO member VALUES(NULL,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			conn = con.getConnection();
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getGender());
			pstmt.executeUpdate();
			
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public boolean checkUser(String userId, String userPw) throws SQLException {
		String sql = "SELECT * FROM member WHERE id=? AND password=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean result = false;
		
		try {
			conn = con.getConnection();
			pstmt = conn.prepareStatement(sql); 			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			System.out.println("아이디 : " + userId + "pw :" + userPw);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("here 1");
				result = true;
			}
			
		}catch(Exception e){
			System.out.println("here" + e.getClass() + e.getMessage());
		} finally {
			if(rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return result;
	}
}
