/**
 * @작성자  : hataeho
 */
package service.search;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class SearchModel {

	public ArrayList<Politician> getResult(String searchQuery)  {
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "SELECT * FROM politician WHERE name LIKE ?";
		
		queryValues.add("%" + searchQuery +"%");
		
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		
		ResultSet rs;
		DAOFactory DAO = new DAOFactory();
		ArrayList<Politician> searchResultList = new ArrayList<Politician>();
		try {
			rs = DAO.selectQuery(querySet);
			while(rs.next()) {
				searchResultList.add(new Politician(rs.getInt("id"), rs.getString("name"), rs.getString("local"), rs.getInt("party_id"), rs.getString("img_url")));
			}
			return searchResultList;
		}  catch (SQLException e) {
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
