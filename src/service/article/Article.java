package service.article;

public class Article {

	private int id;
	private String title;
	private String content;
	private String imgUrl;
	private String link;
	private String date;
	private int version;
	private String userId;
	private int promiseNum;
	private int politicianId;
	private int ancestorId;

	public Article(String title, String content, String imgUrl, String link, int version,
			String userId, int promiseNum, int politicianId) {
		this(-1, title, content, imgUrl, link, null, version, userId, promiseNum, politicianId, -1);
	}

	public Article(Integer id, String title, String content, String imgUrl, String link, String date,
			int version, String userId, int promiseNum, int politicianId, int ancestorId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.imgUrl = imgUrl;
		this.link = link;
		this.date = date;
		this.version = version;
		this.userId = userId;
		this.promiseNum = promiseNum;
		this.politicianId = politicianId;
		this.ancestorId = ancestorId;
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
	
	public int getVersion() {
		return version;
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
	
	public int getAncestorId() {
		return ancestorId;
	}
}