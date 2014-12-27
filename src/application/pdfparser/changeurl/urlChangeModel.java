package application.pdfparser.changeurl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class urlChangeModel {

	public ArrayList<String> getImageURL() throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "SELECT img_url FROM politician;";
		
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		
		ResultSet rs = DAO.selectQuery(querySet);

		while(rs.next()) {
			String url = rs.getString("img_url");
			list.add(url);
		}
		
		DAO.closeConnections();
		return list;
	}
	
	public void setImageURL(ArrayList<String> list) throws SQLException {
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "SELECT * FROM politician;";
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		ResultSet rs = DAO.selectQuery(querySet);
		
		updateImageURL(rs);
		DAO.closeConnections();
	}
	
	private void updateImageURL(ResultSet rs) throws SQLException {
		String sql = "UPDATE politician SET img_url = ? WHERE id = ?;";
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String real_url = "/serviceData/image/";
		DAOFactory DAO = new DAOFactory();
		PstmtQuerySet querySet = null;
		int id = -1;
		int name = 0;
		
		while(rs.next()) {
			id = rs.getInt("id");
			queryValues.add(real_url + name + ".jpg");
			queryValues.add(id);
			querySet = new PstmtQuerySet(sql, queryValues);
			DAO.nonSelectQuery(querySet);
			queryValues.clear();
			DAO.closeConnections();
			name++;
		}
		System.out.println("change to real_url process end");
	}

}
