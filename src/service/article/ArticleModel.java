package service.article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class ArticleModel {

	public void postArticle(ArrayList<Object> queryValues) throws SQLException {
		
		String sql = "INSERT INTO article VALUES(NULL,?,?,?,?,?,?,0,?,?,?,?)";
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();

		if (DAO.nonSelectQuery(querySet)) {
			DAO.closeConnections();
			return;
		}
		DAO.closeConnections();
	}
	
	int getMaxArticleId(){
		
		String sql = "SELECT MAX(id)+1 FROM article";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		
		ResultSet rs = null;
		int articleId = 0;
		
		try {
			rs = DAO.selectQuery(querySet);
			rs.next();
			articleId = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articleId;
	}
	
	public Article getArticle(ArrayList<Object> queryValues) {

		String sql = "SELECT * FROM article WHERE id=?";
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
	
		ResultSet rs = null;
		Article article = null;

		try {
			rs = DAO.selectQuery(querySet);

			while (rs.next()) {
				article = new Article.Builder(rs.getString("title"),
						rs.getString("content"), rs.getString("img_url"),
						 rs.getInt("version"), rs.getString("user_id"),
						rs.getInt("promise_num"), rs.getInt("politician_id")).id(rs.getInt("id")).date(rs.getString("date")).ancestorId(rs.getInt("ancestor_id")).link(rs.getString("link")).build();
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DAO.closeConnections();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return article;
	}

	public List<String> getPromiseTitle(ArrayList<Object> queryValues) throws SQLException {
		// TODO promise table에서 정치인아이디가 pid인 것 search하여 List에 넣기
		String sql = "SELECT * FROM promise WHERE politician_id=?";
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		
		ResultSet rs = null;
		List<String> promiseLists = new ArrayList<String>();
		
		rs = DAO.selectQuery(querySet);
		while (rs.next()) {
			promiseLists.add(rs.getString("title"));
		}

		DAO.closeConnections();
		return promiseLists;
	}
	
	public String getPromiseTitle(int pid, int promiseNum) throws SQLException {
		
		String sql = "SELECT * FROM promise WHERE politician_id=? AND promise_num=?";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		queryValues.add(pid);
		queryValues.add(promiseNum);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;
		rs = DAO.selectQuery(querySet);
		String promiseTitle = null;
		
		while (rs.next()) {
			promiseTitle = rs.getString("title");
		}
		DAO.closeConnections();
		return promiseTitle;
	}

	public boolean deleteArticleById(ArrayList<Object> queryValues) throws SQLException {
		String sql = "UPDATE article SET deleted=1 WHERE id=?";
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();

		if (DAO.nonSelectQuery(querySet)) {
			DAO.closeConnections();
			return true;
		}
		DAO.closeConnections();
		return false;
	}
}
