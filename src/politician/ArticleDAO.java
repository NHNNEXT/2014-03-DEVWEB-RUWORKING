package politician;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import register.User;

public class ArticleDAO {

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
	
	public void addArticle(Article article) throws SQLException{
	String sql = "INSERT INTO article VALUES(NULL,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setInt(3, article.getPoliticianId());
			//공약 넘버도 넣어야할듯!
			pstmt.setInt(4, article.getMemberNumber());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		}
	}
}
