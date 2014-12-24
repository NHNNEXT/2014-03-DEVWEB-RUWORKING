package service.comment;

public class Comment {

	private String comment;
	private String time;
	private String userId;

	Comment(String comment, String time, String userId){
		this.comment = comment;
		this.time = time;
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public String getTime() {
		return time;
	}

	public String getUserId() {
		return userId;
	}	
}
