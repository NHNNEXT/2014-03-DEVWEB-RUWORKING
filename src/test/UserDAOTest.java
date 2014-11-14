package test;

import register.UserDAO;
import junit.framework.TestCase;

public class UserDAOTest extends TestCase {
	public void testCheckUser() throws Exception {
		UserDAO userDAO = new UserDAO();
		assertTrue(userDAO.checkUser("test", "1234"));
		assertFalse(userDAO.checkUser("test", "3456"));
		assertFalse(userDAO.checkUser("dahye", "$$"));
	}
}