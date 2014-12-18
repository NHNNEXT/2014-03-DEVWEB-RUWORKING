package service.vote;

import java.sql.SQLException;
import java.util.ArrayList;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class VoteModel {

	public boolean addOpinion(String score, String politicianId,
			String promiseNum) throws SQLException {

		if (!(updateVoteCount(politicianId, promiseNum) && updateVoteScore(
				score, politicianId, promiseNum)))
			return false;

		return true;
	}

	private boolean updateVoteScore(String score, String politicianId,
			String promiseNum) throws SQLException {
		ArrayList<Object> queryValues = new ArrayList<Object>();
		DAOFactory DAO = new DAOFactory();
		String scoreSql = "UPDATE promise SET vote_score=vote_score+? WHERE politician_id=? AND promise_num=?";

		queryValues.add(score);
		queryValues.add(politicianId);
		queryValues.add(promiseNum);

		PstmtQuerySet querySet = new PstmtQuerySet(scoreSql, queryValues);

		if (!DAO.nonSelectQuery(querySet)){
			DAO.closeConnections();
			return false;
		}
		DAO.closeConnections();
		return true;
	}

	private boolean updateVoteCount(String politicianId, String promiseNum)
			throws SQLException {
		ArrayList<Object> queryValues = new ArrayList<Object>();
		DAOFactory DAO = new DAOFactory();
		String countSql = "UPDATE promise SET vote_count=vote_count+1 WHERE politician_id=? AND promise_num=?";

		queryValues.add(politicianId);
		queryValues.add(promiseNum);
		PstmtQuerySet querySet = new PstmtQuerySet(countSql, queryValues);

		if (!DAO.nonSelectQuery(querySet)) {
			DAO.closeConnections();
			return false;
		}
		DAO.closeConnections();
		return true;
	}

	public boolean checkVote(String userId, String politicianId,
			String promiseNum) throws SQLException {
		String sql = "INSERT INTO vote_check VALUES(?,?,?)";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		DAOFactory DAO = new DAOFactory();

		queryValues.add(promiseNum);
		queryValues.add(politicianId);
		queryValues.add(userId);

		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);

		if (!DAO.nonSelectQuery(querySet)) {
			DAO.closeConnections();
			return false;
		}
		DAO.closeConnections();
		return true;

	}
}
