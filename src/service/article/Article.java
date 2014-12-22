package service.article;

public class Article {

	private int id;
	private String title;
	private String content;
	private String date;
	private String userId;
	private int promiseNum;
	private int politicianId;

	public Article() {

	}

	public Article(String title, String content, String date, String userId, int promiseNum, int politicianId) {
		this(null, title, content, date, userId, promiseNum, politicianId);
	}

	public Article(Integer id, String title, String content, String date, String userId, int promiseNum, int politicianId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.userId = userId;
		this.promiseNum = promiseNum;
		this.politicianId = politicianId;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getDate() {
		return date;
	}

	public String getUserId() {
		return userId;
	}

	public int getPromiseNum() {
		return promiseNum;
	}

	public int getPoliticianId() {
		return politicianId;
	}
}