package service.vote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class VoteModel {

	public void vote(String score, String politicianId, String promiseNum)
			throws SQLException {

		updateVoteCount(politicianId, promiseNum);
		updateVoteScore(score, politicianId, promiseNum);

	}

	private void updateVoteScore(String score, String politicianId,
			String promiseNum) throws SQLException {
		ArrayList<Object> queryValues = new ArrayList<Object>();
		DAOFactory DAO = new DAOFactory();
		String scoreSql = "UPDATE promise SET vote_score=vote_score+? WHERE politician_id=? AND promise_num=?";

		queryValues.add(score);
		queryValues.add(politicianId);
		queryValues.add(promiseNum);

		PstmtQuerySet querySet = new PstmtQuerySet(scoreSql, queryValues);

		if (!DAO.nonSelectQuery(querySet)) {
			System.out.println("UPDATE vote_score 실패");//실패시 처리를 해주어야 한다.
		}
		DAO.closeConnections();
	}

	private void updateVoteCount(String politicianId, String promiseNum)
			throws SQLException {
		ArrayList<Object> queryValues = new ArrayList<Object>();
		DAOFactory DAO = new DAOFactory();
		String countSql = "UPDATE promise SET vote_count=vote_count+1 WHERE politician_id=? AND promise_num=?";

		queryValues.add(politicianId);
		queryValues.add(promiseNum);
		PstmtQuerySet querySet = new PstmtQuerySet(countSql, queryValues);

		if (!DAO.nonSelectQuery(querySet)) {
			System.out.println("UPDATE vote_count 실패");//실패시 처리를 해주어야 한다.
		}
		DAO.closeConnections();
	}

	public boolean isAlredyVotedCase(String userId, String politicianId,
			String promiseNum) throws SQLException {

		String sql = "SELECT * FROM vote_check WHERE user_id=? AND politician_id=? AND promise_num=?";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		DAOFactory DAO = new DAOFactory();
		queryValues.add(userId);
		queryValues.add(politicianId);
		queryValues.add(promiseNum);

		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		ResultSet rs = DAO.selectQuery(querySet);

		while(rs.next()) {
			DAO.closeConnections();
			return true;
		}
		DAO.closeConnections();
		return false;
	}

	public void checkVoteList(String userId, String politicianId,
			String promiseNum) throws SQLException {

		String sql = "INSERT INTO vote_check VALUES(?,?,?)";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		DAOFactory DAO = new DAOFactory();
		queryValues.add(promiseNum);
		queryValues.add(politicianId);
		queryValues.add(userId);

		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);

		if (!DAO.nonSelectQuery(querySet)) {
			System.out.println("Insert vote_check 실패");//실패시 처리를 해주어야 한다.
		}
		DAO.closeConnections();

	}


}
