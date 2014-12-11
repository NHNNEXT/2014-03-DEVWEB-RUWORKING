package service.vote;

import java.sql.SQLException;
import java.util.ArrayList;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class VoteModel {

	public boolean addOpinion(String score, String promiseId)
			throws SQLException {
		ArrayList<Object> queryValues = new ArrayList();
		DAOFactory DAO = new DAOFactory();
	

		// 투표수 update
		String countSql = "UPDATE promise SET vote_count=vote_count+1 WHERE id=?";

		queryValues.add(promiseId);
		PstmtQuerySet querySet = new PstmtQuerySet(countSql, queryValues);
		if (!DAO.runQuery(querySet))
			return false;

		// 투표 총점 update
		String scoreSql = "UPDATE promise SET vote_score=vote_score+? WHERE id=?";

		queryValues.clear();
		queryValues.add(score);
		queryValues.add(promiseId);
		PstmtQuerySet newQuerySet = new PstmtQuerySet(scoreSql, queryValues);
		DAO.runQuery(newQuerySet);

		if (!DAO.runQuery(querySet))
			return false;
		return true;
	}
}
