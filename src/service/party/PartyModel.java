package service.party;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class PartyModel {
	public List<Party> getPartyList() {
		List<Party> partyList = getPartyNameAndIdList();
		setPartyPoliticianNumber(partyList);
		for(Party party : partyList){
			setAverageRatio(party);
		}
		return partyList;
	}

	private List<Party> getPartyNameAndIdList() {
		ArrayList<Party> partyList = new ArrayList<Party>();
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "SELECT * FROM party";
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();

		ResultSet rs;
		try {
			rs = DAO.selectQuery(querySet);
			while (rs.next()) {
				partyList.add(new Party(rs.getInt("id"), rs.getString("name")));
			}
			DAO.closeConnections();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partyList;
	}
	
	private void setPartyPoliticianNumber(List<Party> partyList) {
		String sql = "select count(*) from politician group by party_id";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs;
		try {
			rs = DAO.selectQuery(querySet);
			Iterator<Party> iterator = partyList.iterator();
			while (rs.next() && iterator.hasNext()) {
				Party party = iterator.next();
				party.setPoliticianNumber(rs.getInt(1));
			}
			DAO.closeConnections();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setAverageRatio(Party party) {
		String sql = "select floor(sum(rate)/count(*)) from (SELECT (SUM(vote_score/vote_count)/5) AS rate from promise as pr join politician as po on pr.politician_id = po.id join party as pa on po.party_id = pa.id  where party_id=? group by po.id) temp";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		queryValues.add(party.getId());
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs;
		try {
			rs = DAO.selectQuery(querySet);
			while (rs.next()) {
				party.setAverageRatio(rs.getInt(1));
			}
			DAO.closeConnections();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
