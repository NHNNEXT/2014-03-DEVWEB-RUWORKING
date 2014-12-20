package service.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class BoardModel {

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

		DAO.closeConnections();
		return articleTitles;
	}

}
