package service.article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class ArticleModel {

	public boolean postArticle(String title, String content, String userId,
			int promiseNum, int politicianId) throws SQLException {

		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "INSERT INTO article VALUES(NULL,?,?,NULL, NULL,?,0,0,?,?,?)";
		Timestamp date = new Timestamp(System.currentTimeMillis());

		queryValues.add(title);
		queryValues.add(content);
		queryValues.add(date);
		queryValues.add(userId);
		queryValues.add(promiseNum);
		queryValues.add(politicianId);

		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();

		if (DAO.nonSelectQuery(querySet)) {
			DAO.closeConnections();
			return true;
		}
		DAO.closeConnections();
		return false;
	}
	
	public boolean postArticle(Article article) throws SQLException {
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "INSERT INTO article VALUES(NULL,?,?,?,?,?,0,0,?,?,?)";
		Timestamp date = new Timestamp(System.currentTimeMillis());

		queryValues.add(article.getTitle());
		queryValues.add(article.getContent());
		queryValues.add(article.getImgUrl());
		queryValues.add(article.getLink());
		queryValues.add(date);
		queryValues.add(article.getUserId());
		queryValues.add(article.getPromiseNum());
		queryValues.add(article.getPoliticianId());

		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();

		if (DAO.nonSelectQuery(querySet)) {
			DAO.closeConnections();
			return true;
		}
		DAO.closeConnections();
		return false;
	}

	public Article getArticle(String id) {

		String sql = "SELECT * FROM article WHERE id=?";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		queryValues.add(id);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;
		Article article = null;

		try {
			rs = DAO.selectQuery(querySet);

			while (rs.next()) {
				article = new Article(rs.getInt("id"), rs.getString("title"),
						rs.getString("content"), rs.getString("img_url"), rs.getString("link"), rs.getString("date"),
						rs.getString("user_id"), rs.getInt("promise_num"),
						rs.getInt("politician_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DAO.closeConnections();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return article;
	}

	public List<String> getPromiseTitle(int pid) throws SQLException {
		// TODO promise table에서 정치인아이디가 pid인 것 search하여 List에 넣기
		String sql = "SELECT * FROM promise WHERE politician_id=?";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		queryValues.add(pid);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;
		rs = DAO.selectQuery(querySet);
		List<String> promiseLists = new ArrayList<String>();

		while (rs.next()) {
			promiseLists.add(rs.getString("title"));
		}

		DAO.closeConnections();
		return promiseLists;
	}
}
