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
				int percent = rs.getInt("rate");
				Top5List.add(new Politician(rs.getInt("id"), rs.getString("name"), rs.getString("local"), rs.getString("party_name"), rs.getString("img_Url"), percent));
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
		return Top5List;
	}

	private ResultSet getFulfillment(int numOfPolitician){
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "SELECT FLOOR(SUM(vote_score/vote_count)/5) AS rate, politician.*, party.name AS party_name from promise inner join politician on promise.politician_id = politician.id inner join party on politician.party_id = party.id GROUP BY politician_id ORDER BY SUM(vote_score/vote_count)/5 DESC LIMIT ?";
		
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
}
