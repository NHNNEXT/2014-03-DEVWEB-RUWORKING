package service.comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class CommentModel {

	public Comment addComment(String comment, String articleId, String userId) {
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "INSERT INTO comment VALUES(NULL, ?, ?, ?, ?)";

		Timestamp date = new Timestamp(System.currentTimeMillis()); 		
		queryValues.add(comment);
		queryValues.add(date);
		queryValues.add(articleId);
		queryValues.add(userId);
		
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);

		DAOFactory DAO = new DAOFactory();
		try {
			DAO.nonSelectQuery(querySet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DAO.closeConnections();
				return new Comment(comment, date.toString().substring(0,19)+".0", userId);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<Comment> getCommentList(String articleId) {

		ArrayList<Object> queryValues = new ArrayList<Object>();
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		
		String sql = "SELECT * FROM comment WHERE article_id=?";
		queryValues.add(articleId);
		
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs; 
		
		try {
			rs= DAO.selectQuery(querySet);
			while(rs.next()){
				commentList.add(new Comment(rs.getString("comment"), rs.getString("time"), rs.getString("user_id")));
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
		return commentList;
	}


	
}
