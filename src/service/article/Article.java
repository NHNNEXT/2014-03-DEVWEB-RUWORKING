package service.article;

public class Article {

	private int id;
	private String title;
	private String content;
	private int promiseId;
	private int memberNumber;

	public Article() {

	}

	public Article(String title, String content, int promiseId, int memberNumber) {
		this(null, title, content, promiseId, memberNumber);
	}

	public Article(Integer id, String title, String content, int promiseId, int memberNumber) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.promiseId = promiseId;
		this.memberNumber = memberNumber;
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

	public int getPromiseId() {
		return promiseId;
	}

	public int getMemberNumber() {
		return memberNumber;
	}
}