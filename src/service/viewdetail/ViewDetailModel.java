package service.viewdetail;

//import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.article.Article;
import service.search.Politician;
import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class ViewDetailModel {

	public Politician getPolitician(String pid) {

		String sql = "SELECT * FROM politician WHERE id=?";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		queryValues.add(pid);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		ResultSet rs;

		DAOFactory DAO = new DAOFactory();

		try {
			rs = DAO.selectQuery(querySet);
			if (rs.next()) {
				int partyId = rs.getInt("party_id");
				String partyName = getPartyName(partyId);
				return new Politician(rs.getInt("id"), rs.getString("name"),
						rs.getString("local"), partyName,
						rs.getString("img_url"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DAO.closeConnections();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private String getPartyName(int partyId) {

		String sql = "SELECT * FROM party WHERE id=?";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		queryValues.add(partyId);

		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs;

		try {
			rs = DAO.selectQuery(querySet);
			if (rs.next()) {
				String partyName = rs.getString("name");
				return partyName;
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
		return null;
	}

	public ArrayList<Promise> getPromises(String pid) {

		ArrayList<Object> queryValues = new ArrayList<Object>();
		ArrayList<Promise> promises = new ArrayList<Promise>();
		queryValues.add(pid);

		String sql = "SELECT * FROM promise WHERE politician_id=?";
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();

		try {
			ResultSet rs = DAO.selectQuery(querySet);
			while (rs.next()) {
				promises.add(new Promise(rs.getString("title"), rs
						.getString("content"), rs.getInt("vote_score"), rs
						.getInt("vote_count"), rs.getInt("promise_num")));
			}
			return promises;
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

		return null;
	}

	public int getTotalPercent(List<Promise> promises) {

		int totalPercent = 0;
		for (Promise i : promises) {
			totalPercent += i.getPercent();
		}
		return totalPercent / 5;
	}

	public Map<Integer, List> getPromiseRelatePostList(String politicianId) {
		HashMap<Integer, List> relatedPostMap = new HashMap<Integer, List>();
		for (int i = 1; i < 6; i++) {
			relatedPostMap.put(i, getPromiseRelatePost(politicianId, i));
		}
		return relatedPostMap;
	}

	public List<ArticleTitle> getPromiseRelatePost(String politicianId, int promiseId) {

		String sql = "SELECT * FROM article WHERE politician_id=? AND promise_num=? AND deleted=0 ORDER BY date DESC LIMIT 3";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		queryValues.add(politicianId);
		queryValues.add(promiseId);

		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs;
		ArrayList<ArticleTitle> relatedPostListOnSamePromise = new ArrayList<ArticleTitle>();
		
		try {
			rs = DAO.selectQuery(querySet);
			while (rs.next()) {
				relatedPostListOnSamePromise.add(new ArticleTitle(rs.getString("id"), rs.getString("title")));
			}
			return relatedPostListOnSamePromise;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DAO.closeConnections();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
