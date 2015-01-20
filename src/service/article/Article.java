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

	public static class Builder {
		private int id = -1;
		private String title;
		private String content;
		private String imgUrl;
		private String link = null;
		private String date = null;
		private int version;
		private String userId;
		private int promiseNum;
		private int politicianId;
		private int ancestorId = -1;

		public Builder(String title, String content, String imgUrl,
				int version, String userId, int promiseNum, int politicianId) {
			this.title = title;
			this.content = content;
			this.imgUrl = imgUrl;
			this.version = version;
			this.userId = userId;
			this.promiseNum = promiseNum;
			this.politicianId = politicianId;
		}

		public Builder link(String val){
			link = val;
			return this;
		}
		
		public Builder id(int val) {
			id = val;
			return this;
		}
		
		public Builder date(String val){
			date = val;
			return this;
		}
		
		public Builder ancestorId(int val) {
			ancestorId = val;
			return this;
		}
		
		public Article build(){
			return new Article(this);
		}
	}

	public Article (Builder builder){
		this.id = builder.id;
		this.title = builder.title;
		this.content = builder.content;
		this.imgUrl = builder.imgUrl;
		this.link = builder.link;
		this.date = builder.date;
		this.version = builder.version;
		this.userId = builder.userId;
		this.promiseNum = builder.promiseNum;
		this.politicianId = builder.politicianId;
		this.ancestorId = builder.ancestorId;
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