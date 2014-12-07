package service.register;

public class User {
	private String id;
	private String password;
	private String gender;
	private String email;
	
	public User(String id, String password, String email, String gender) {
		this.id = id;
		this.password = password;
		this.gender = gender;
		this.email = email;
	}
	
	public String getId(){
		return id;
	}
	
	public String getPassword() {
		return password;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}
}