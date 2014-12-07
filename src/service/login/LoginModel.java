/**  : 
 * @FileName : LoginModel.java
 * @Package : login
 * @작성자  : hataeho
 */
package service.login;

import java.sql.SQLException;
import java.util.ArrayList;

import db.factory.DAOFactory;
import db.query.PstmtQuerySet;

public class LoginModel {
	
	public boolean isUserExist(String userId, String userPw) throws SQLException {
		ArrayList<Object> queryValues = new ArrayList<Object>();
		String sql = "SELECT * FROM member WHERE id=? AND password=?";
		
		queryValues.add(userId);
		queryValues.add(userPw);
		
		PstmtQuerySet querySet = new PstmtQuerySet(sql, queryValues);
		
		DAOFactory DAO = new DAOFactory();
		if(DAO.runQuery(querySet))
			return true;
		return false;
	}
}
