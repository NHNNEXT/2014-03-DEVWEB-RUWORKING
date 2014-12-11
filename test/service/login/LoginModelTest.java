package service.login;

import service.login.LoginModel;
import junit.framework.TestCase;

public class LoginModelTest extends TestCase {
	public void testCheckUser() throws Exception {
		LoginModel loginModel = new LoginModel();
		assertTrue(loginModel.isUserExist("test", "1234"));
		assertFalse(loginModel.isUserExist("test", "3456"));
		assertFalse(loginModel.isUserExist("dahye", "$$"));
	}
}
