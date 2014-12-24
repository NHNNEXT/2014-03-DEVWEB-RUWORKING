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

	public void setImageURL(ArrayList<String> list) {
		String sql = "UPDATE politician set img_url = ? where ";
	}

}
