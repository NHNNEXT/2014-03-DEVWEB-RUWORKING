package service.article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class ArticleModel {

	public boolean postArticle(String title, String content, int memberNumber,
			int promiseId) throws SQLException {

		Article article = new Article(title, content, memberNumber, promiseId);
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "INSERT INTO article VALUES(NULL,?,?,?,?)";

		queryValues.add(article.getTitle());
		queryValues.add(article.getContent());
		queryValues.add(article.getPromiseId());
		queryValues.add(article.getMemberNumber());

		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		
		if(DAO.nonSelectQuery(querySet)){
			DAO.closeConnections();
			return true;
			}
		DAO.closeConnections();
		return false;
	}
	
	public Article getArticle(int id) throws SQLException{
		
		String sql = "SELECT * FROM article WHERE id=?"; 
		ArrayList<Object> queryValues = new ArrayList<Object>();
		queryValues.add(id);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;
		Article article = null;
		rs = DAO.selectQuery(querySet);

		while (rs.next()) {
			article = new Article(rs.getString("title"),
					rs.getString("content"), rs.getInt("member_number"),
					rs.getInt("promise_id"));
		}

		DAO.closeConnections();
		return article;
	}

	public ArrayList<String> getArticleBoard(int promiseId) throws SQLException {
		String sql = "SELECT * FROM article WHERE promise_id=?";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		ArrayList<String> articleTitles = new ArrayList<String>();

		queryValues.add(promiseId);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;

		while (rs.next()) {
			articleTitles.add(rs.getString("title"));
		}

		return articleTitles;
	}

	public List<String> getPromiseContent(int pid, int round) throws SQLException {
		// TODO promise table에서 정치인아이디가 pid, 대수가 round인 공약 id 5개 search하여 List에 넣기
		String sql = "SELECT * FROM promise WHERE politician_id=? and round=?";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		queryValues.add(pid);
		queryValues.add(round);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;
		rs = DAO.selectQuery(querySet);
		List <String> promiseContents = new ArrayList<String>();
		
		while (rs.next()) {
			promiseContents.add(rs.getString("content"));
		}

		DAO.closeConnections();
		return promiseContents;
	}
}
