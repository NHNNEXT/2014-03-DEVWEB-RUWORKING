package service.article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class ArticleModel {

	public boolean postArticle(String title, String content, int memberNumber, int promiseId) throws SQLException {

		Article article = new Article(title, content, memberNumber, promiseId);
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "INSERT INTO article VALUES(NULL,?,?,?,?)";

		queryValues.add(article.getTitle());
		queryValues.add(article.getContent());
		queryValues.add(article.getPromiseId());
		queryValues.add(article.getMemberNumber());
		
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		
		if(DAO.runQuery(querySet))
			return true;
		return false;
	}
	
	public Article getArticle(int id){
		
		String sql = "SELECT * FROM article WHERE id=?"; 
		ArrayList<Object> queryValues = new ArrayList<Object>();
		queryValues.add(id);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;

		rs = DAO.excuteQuery(querySet);		

		while(rs.next()){
			Article article = new Article(rs.getString("title"), rs.getString("content"), rs.getInt("member_number"), rs.getInt("promise_id"));
		}
		
		return article;
	}
	
	public ArrayList<String> getArticleBoard(int promiseId) throws SQLException{
		String sql = "SELECT * FROM article WHERE promise_id=?";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		ArrayList<String> articleTitles = new ArrayList<String>();
		
		queryValues.add(promiseId);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;

		while(rs.next()){
			articleTitles.add(rs.getString("title"));
		}
		
		return articleTitles;
	}
}
