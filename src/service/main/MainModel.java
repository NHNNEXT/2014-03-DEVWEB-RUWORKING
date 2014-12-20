package service.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import service.search.Politician;
import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class MainModel {
	public ArrayList<Politician> getTop5fulfillment(){
		ResultSet rs = getFulfillment(5);
		ArrayList<Politician> Top5List = new ArrayList<Politician>();
		try {
			while(rs.next()){
				int politicianId = rs.getInt("politician_id");
				int percent = rs.getInt("rate");
				Top5List.add(new Politician(rs.getInt("politician_id"), getPolitician(politicianId).getString("name"), getPolitician(politicianId).getString("local"), getParty(getPolitician(politicianId).getInt("party_id")), getPolitician(politicianId).getString("img_Url"), percent));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Top5List;
	}
	
	private String getParty(int partyId) {
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "SELECT * from party where id = ?";
		
		queryValues.add(partyId);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;
		try {
			rs = DAO.selectQuery(querySet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs.next())
				return rs.getString("name");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ResultSet getFulfillment(int numOfPolitician){
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "SELECT FLOOR(SUM(vote_score/vote_count)/5) AS rate, politician_id from promise GROUP BY politician_id ORDER BY SUM(vote_score/vote_count)/5 DESC LIMIT ?";
		
		queryValues.add(numOfPolitician);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;
		try {
			rs = DAO.selectQuery(querySet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	private ResultSet getPolitician(int politicianId){
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "SELECT * from politician where id=?";
		
		queryValues.add(politicianId);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
				
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;
		try {
			rs = DAO.selectQuery(querySet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs.next())
				return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
