package application.pdfparser.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;
import application.pdfparser.context.Header;
import application.pdfparser.context.Promise;

public class PdfModel {
	private int getPartyId(String partyName) throws SQLException {
		int id = -1;
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "SELECT id FROM party WHERE name = ?";
		
		queryValues.add(partyName);		
		
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = DAO.selectQuery(querySet);
		while(rs.next()) {
			id = rs.getInt("id");			
		}
		DAO.closeConnections();
		return id;
	}
	
	public boolean addPromise(Promise promise, int poliId) throws SQLException {
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "INSERT INTO promise VALUES(?, ?, ?, ?, ?, ?)";
		
		queryValues.add(Integer.parseInt(promise.getPromiseNum()));
		queryValues.add(poliId);
		queryValues.add(promise.getPromiseTitle());
		queryValues.add(promise.getPromise());
		queryValues.add(10000);
		queryValues.add(10000);
		
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		
		if(DAO.nonSelectQuery(querySet)) {
			DAO.closeConnections();
			return true;
		}
		DAO.closeConnections();
		return false;
	}
	
	public int addPolitition(Header header) throws SQLException {
		int id = getPartyId(header.getParty());
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "INSERT INTO politician VALUES(NULL, ?, ?, ?, ?, ?)";
		
		queryValues.add(header.getName());
		queryValues.add(header.getLocation());
		queryValues.add("http://www.naver.com");
		queryValues.add(10);
		queryValues.add(id);
		
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		
		if(DAO.nonSelectQuery(querySet)) {
			int poliId = getPolititicanId(header, DAO);
			DAO.closeConnections();
			return poliId;
		}
		DAO.closeConnections();
		return -1;
	}
	
	public int getPolititicanId(Header header, DAOFactory DAO) throws SQLException {
		String sql = "SELECT id FROM politician where name = ?";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		queryValues.add(header.getName());
		
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		ResultSet rs = DAO.selectQuery(querySet);
		if(rs.next()) {
			int poliId = rs.getInt("id");
			return poliId;
		}
		
		return -1;
	}
}
