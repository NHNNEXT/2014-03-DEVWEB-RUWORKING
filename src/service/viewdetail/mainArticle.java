package service.viewdetail;

public class mainArticle {
	String name = new String();
	String partyName = new String();
	String title = new String();
	String content = new String();
	String img_url = new String();
	String date = new String();
	String article_id = new String();
	String ancestor_id = new String();
	String politician_id = new String();
	
	public String getPolitician_id() {
		return politician_id;
	}

	public String getName() {
		return name;
	}

	public String getPartyName() {
		return partyName;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getImg_url() {
		return img_url;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getArticle_id() {
		return article_id;
	}
	
	public String getAncestor_id() {
		return ancestor_id;
	}

	public mainArticle(String name, String partyName, String title, String content, String date, String article_id, String ancestor_id, String politician_id) {
		this.name = name;
		this.partyName = partyName;
		this.title = title;
		this.content = content;
		this.date = date;
		this.article_id = article_id;
		this.ancestor_id = ancestor_id;
		this.politician_id = politician_id;
	}
	
	public mainArticle(String name, String partyName, String title, String content, String date, String article_id, String ancestor_id, String img_url, String politician_id) {
		this(name, partyName, title, content, date, article_id, ancestor_id, politician_id);
		this.img_url = img_url;
	}
}
