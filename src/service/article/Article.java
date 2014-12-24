package service.article;

public class Article {

	private int id;
	private String title;
	private String content;
	private String imgUrl;
	private String link;
	private String date;
	private String userId;
	private int promiseNum;
	private int politicianId;

	public Article() {

	}

	public Article(String title, String content, String date, String userId,
			int promiseNum, int politicianId) {
		this(null, title, content, null, null, date, userId, promiseNum, politicianId);
	}
	
	public Article(String title, String content, String imgUrl, String link,
			String userId, int promiseNum, int politicianId) {
		this.title = title;
		this.content = content;
		this.imgUrl = imgUrl;
		this.link = link;
		this.userId = userId;
		this.promiseNum = promiseNum;
		this.politicianId = politicianId;
	}

	public Article(Integer id, String title, String content, String imgUrl, String link, String date,
			String userId, int promiseNum, int politicianId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.imgUrl = imgUrl;
		this.link = link;
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
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public String getLink() {
		return link;
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