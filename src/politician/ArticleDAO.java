package politician;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	String sql = "INSERT INTO article VALUES(NULL,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setInt(3, article.getPoliticianId());
			pstmt.setInt(4, article.getMemberNumber());
			pstmt.setInt(5, article.getPromiseId());
			
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
	
	
	public void getArticle(int id) throws SQLException {
		String sql = "SELECT * FROM article WHERE id="+id; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
	 		rs = pstmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		while(rs.next()){
			Article article = new Article(rs.getString("title"), rs.getString("content"), rs.getInt("politician_id"), rs.getInt("member_number"), rs.getInt("promise_id"));
		}
			
		
	}
}
