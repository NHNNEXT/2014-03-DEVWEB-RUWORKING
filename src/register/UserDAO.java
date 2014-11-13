package register;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

	public Connection getConnection() {
		String url = "jdbc:mysql://10.73.45.132:3306/dev?useUnicode=true&characterEncoding=UTF-8";
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

	public void addUser(User user) throws SQLException {
		
		String sql = "insert into member values(NULL,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		try {
			conn = getConnection();

			if(conn==null){
				System.out.println("안");
			}
			
			pstmt = conn.prepareStatement(sql); 
			System.out.println(user.getGender());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getGender());
			pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
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

