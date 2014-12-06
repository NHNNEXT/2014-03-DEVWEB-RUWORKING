package register;

public class RegisterUser {

	public boolean addUser(String id, String password, String email,
			String gender, String targetDB) {
		User user = new User(id, password, email, gender);
		
		try {
			UserDAO userDAO = new UserDAO(targetDB);
			userDAO.addUser(user);
			return true;
		} catch (Exception e) {
			System.out.println("없는 DB입니다");
			e.printStackTrace();
		}
		return false;
	}

}
