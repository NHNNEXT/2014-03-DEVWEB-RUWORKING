package service.register;

import java.sql.SQLException;
import java.util.ArrayList;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class RegisterModel {

	public boolean addUser(String id, String password, String email, String gender) throws SQLException {
		User user = new User(id, password, email, gender);
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "INSERT INTO member VALUES(NULL,?,?,?,?)";
		
		queryValues.add(user.getId());
		queryValues.add(user.getPassword());
		queryValues.add(user.getEmail());
		queryValues.add(user.getGender());
		
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		DAOFactory DAO = new DAOFactory();
		
		if(DAO.runQuery(querySet))
			return true;
		return false;
	}
}

