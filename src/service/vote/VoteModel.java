package service.vote;

import java.sql.SQLException;
import java.util.ArrayList;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class VoteModel {

	public boolean addOpinion(String score, String promiseId)
			throws SQLException {
		
		if(!(updateVoteCount(promiseId) && updateVoteScore(score, promiseId))) return false;		
		
		return true;
	}

	private boolean updateVoteScore(String score, String promiseId) throws SQLException {
		ArrayList<Object> queryValues = new ArrayList();
		DAOFactory DAO = new DAOFactory();
		String scoreSql = "UPDATE promise SET vote_score=vote_score+? WHERE id=?";

		queryValues.add(score);
		queryValues.add(promiseId);
		PstmtQuerySet querySet = new PstmtQuerySet(scoreSql, queryValues);

		if (!DAO.nonSelectQuery(querySet)) return false;
		return true;
	}

	private boolean updateVoteCount(String promiseId) throws SQLException {
		ArrayList<Object> queryValues = new ArrayList();
		DAOFactory DAO = new DAOFactory();
		String countSql = "UPDATE promise SET vote_count=vote_count+1 WHERE id=?";

		queryValues.add(promiseId);
		PstmtQuerySet querySet = new PstmtQuerySet(countSql, queryValues);
		
		if (!DAO.nonSelectQuery(querySet)) return false;	
		return true;
	}
}
