package service.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import service.search.Politician;
import service.viewdetail.Promise;
import service.viewdetail.ViewDetailModel;
import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class MainModel {
	public List<Politician> getRankedFulfillment(int numOfPolitician){
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "SELECT FLOOR(SUM(vote_score/vote_count)/5) AS rate, politician.*, party.name AS party_name from promise inner join politician on promise.politician_id = politician.id inner join party on politician.party_id = party.id GROUP BY politician_id ORDER BY SUM(vote_score/vote_count)/5 DESC LIMIT ?";
		
		queryValues.add(numOfPolitician);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;
		try {
			rs = DAO.selectQuery(querySet);
			return makeFulfillmentList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private List<Politician> makeFulfillmentList(ResultSet rs) {
		ArrayList<Politician> Top5List = new ArrayList<Politician>();
		try {
			while(rs.next()){
				int percent = rs.getInt("rate");
				Top5List.add(new Politician(rs.getInt("id"), rs.getString("name"), rs.getString("local"), rs.getString("party_name"), rs.getString("img_Url"), percent));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Top5List;
	}

	public List getLocalInfo() {
		
		ArrayList<LocalInfo> localList = new ArrayList<LocalInfo>();
		Set<String> local = new HashSet<String>(Arrays.asList(
			     new String[] {"서울특별시","광주광역시", "부산광역시", "대구광역시", "대전광역시", "세종특별자치시", "울산광역시", "인천광역시", "강원도","충청북도","충청남도","전라북도", "전라남도", "경상남도", "경상북도", "제주도"}));
		ResultSet rs = null;

		String sql ="SELECT local, AVG(percent) AS percent FROM (SELECT politician.local, politician.name, AVG(promise.vote_score/promise.vote_count) AS percent FROM promise INNER JOIN politician ON promise.politician_id = politician.id GROUP BY politician.name) TMP GROUP BY local";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
	
		try {
			rs = DAO.selectQuery(querySet);
			while(rs.next()){
			//	System.out.println(rs.getString("local"));
				if(local.contains(rs.getString("local"))){
				//	System.out.println(rs.getString("local"));
					localList.add(new LocalInfo(rs.getString("local"), rs.getInt("percent")));
				}
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
		
		return localList;
	}

	public int getTotalPercent() {

		String sql ="SELECT SUM(percent)/(SELECT count(*) FROM politician) as totalPercent FROM (SELECT AVG(promise.vote_score/promise.vote_count) AS percent FROM promise INNER JOIN politician ON promise.politician_id = politician.id GROUP BY politician.name) TMP";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs;
		int totalPercent=0;

		try {
			rs = DAO.selectQuery(querySet);
			while(rs.next()){
				totalPercent = rs.getInt("totalPercent");
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
		
		return totalPercent;
	}
		
}
