package service.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.search.Politician;
import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class PoliticianRankingModel {
	public List<Politician> getPromiseList(int start, int amount) { 
		ArrayList<Politician> promiseList = new ArrayList<Politician>();
		ResultSet rs = getPromise(start, amount);
		
		try {
			while(rs.next()){
				int percent = rs.getInt("rate");
				promiseList.add(new Politician(rs.getInt("id"), rs.getString("name"), rs.getString("local"), rs.getString("party_name"), rs.getString("img_Url"), percent));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return promiseList;
	}
	
	private ResultSet getPromise(int start, int amount) {
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "SELECT FLOOR(SUM(vote_score/vote_count)/5) AS rate, politician.*, party.name AS party_name from promise inner join politician on promise.politician_id = politician.id inner join party on politician.party_id = party.id GROUP BY politician_id ORDER BY SUM(vote_score/vote_count)/5 DESC LIMIT ?, ?";
		
		queryValues.add(start * amount);
		queryValues.add(amount);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;
		try {
			rs = DAO.selectQuery(querySet);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				DAO.closeConnections();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
		}
		return rs;
	}
}