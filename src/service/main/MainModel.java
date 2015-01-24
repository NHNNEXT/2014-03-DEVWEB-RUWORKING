package service.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import service.search.Politician;
import service.viewdetail.mainArticle;
import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class MainModel {
	public List<Politician> getRankedFulfillment(int numOfPolitician){
		
		String sql = "SELECT FLOOR(SUM(vote_score/vote_count)/5) AS rate, politician.*, party.name AS party_name from promise inner join politician on promise.politician_id = politician.id inner join party on politician.party_id = party.id GROUP BY politician_id ORDER BY SUM(vote_score/vote_count)/5 DESC LIMIT ?";
		PstmtQuerySet querySet = makeQuerySet(numOfPolitician, sql);		
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = null;
		
		try {
			rs = DAO.selectQuery(querySet);
			return makeFulfillmentList(rs);
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

	private PstmtQuerySet makeQuerySet(int numOfPolitician, String sql) {
		ArrayList<Object> queryValues = new ArrayList<Object>();	
		queryValues.add(numOfPolitician);
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		return querySet;
	}
	
	private List<Politician> makeFulfillmentList(ResultSet rs) {
		ArrayList<Politician> Top5List = new ArrayList<Politician>();
		try {
			while(rs.next()){
				int percent = rs.getInt("rate");
				Top5List.add(new Politician.Builder(rs.getInt("id"), rs.getString("name"), rs.getString("local"), rs.getString("party_name"), rs.getString("img_Url")).promiseFulfillment(percent).build());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Top5List;
	}

	public List getLocalInfo() {
		
		ArrayList<LocalInfo> localList = new ArrayList<LocalInfo>();
		Set<String> local = new HashSet<String>(Arrays.asList(
			     new String[] {"서울특별시","경기도","광주광역시", "부산광역시", "대구광역시", "대전광역시", "세종특별자치시", "울산광역시", "인천광역시", "강원도","충청북도","충청남도","전라북도", "전라남도", "경상남도", "경상북도", "제주도"}));
		ResultSet rs = null;

		String sql = "SELECT local, SUM(percent/promise_count) AS local_sum, COUNT(*) AS politician_num FROM (SELECT politician.local, SUM(promise.vote_score/promise.vote_count) AS percent, COUNT(*) AS promise_count FROM promise INNER JOIN politician ON promise.politician_id = politician.id GROUP BY politician.name) SUB GROUP BY local";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
	
		try {
			rs = DAO.selectQuery(querySet);
			while(rs.next()){
			//	System.out.println(rs.getString("local"));
				if(local.contains(rs.getString("local"))){
				//	System.out.println(rs.getString("local"));
					localList.add(new LocalInfo(rs.getString("local"), rs.getInt("local_sum"), rs.getInt("politician_num")));
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
	
	public int getPoliticianTermD_Day(){
		Calendar cal = Calendar.getInstance();
		
		//국회의원 임기 만기일 설정
		//TODO Context Scope에 묶든지 Config로 빼야지 코드에 이런 값이 들어가면 안될것 같은데 ...
		int year = 2016;
		int month = 5;
		int date = 29;

		long now_day = cal.getTimeInMillis(); //현재 시간 가져오기

		cal.set(year, month-1, date);

		long event_day = cal.getTimeInMillis(); //목표일에 대한 시간
		long d_day = (event_day - now_day) / (60*60*24*1000); //(60초 * 60분 * 24시간 * 1000ms)
		return (int)d_day;
	}

	public List<mainArticle> getRecentArticleNotImage() {
		String sql = "select politician.name, party.name as partyName, article.title, article.content, article.img_url, article.date, article.id, article.ancestor_id, article.version, politician.id as politician_id from politician inner join article on politician.id = article.politician_id inner join party on politician.party_id = party.id inner join (select ancestor_id, MAX(version) as version from article group by ancestor_id) as maxVersion on maxVersion.version = article.version and maxVersion.ancestor_id = article.ancestor_id  where article.deleted = 0 order by article.date desc;";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs;
		ArrayList <mainArticle> ret = new ArrayList<mainArticle>();
		int count = 0;
		
		try {
			rs = DAO.selectQuery(querySet);
			while(rs.next()) {
				if(count == 6) break;
				String url = rs.getString("img_url");
				if(url.split("/")[3].equals("null")) {
					ret.add(new mainArticle(rs.getString("name"), rs.getString("partyName"), rs.getString("title"), rs.getString("content"), rs.getString("date").split("\\.")[0], rs.getString("id"), rs.getString("ancestor_id"), rs.getString("politician_id")));					
					count++;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DAO.closeConnections();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	public List<mainArticle> getRecentArticleImage() {
		String sql = "select politician.name, party.name as partyName, article.title, article.content, article.img_url, article.date, article.id, article.ancestor_id, article.version, politician.id as politician_id from politician inner join article on politician.id = article.politician_id inner join party on politician.party_id = party.id inner join (select ancestor_id, MAX(version) as version from article group by ancestor_id) as maxVersion on maxVersion.version = article.version and maxVersion.ancestor_id = article.ancestor_id  where article.deleted = 0 order by article.date desc;";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs;
		ArrayList <mainArticle> ret = new ArrayList<mainArticle>();
		int count = 0;
		
		try {
			rs = DAO.selectQuery(querySet);
			while(rs.next()) {
				if(count == 2) break;
				String url = rs.getString("img_url");
				if(!url.split("/")[3].equals("null")) {
					ret.add(new mainArticle(rs.getString("name"), rs.getString("partyName"), rs.getString("title"), rs.getString("content"), rs.getString("date").split("\\.")[0], rs.getString("id"), rs.getString("ancestor_id"), rs.getString("img_url"), rs.getString("politician_id")));
					count++;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DAO.closeConnections();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	
	
}
