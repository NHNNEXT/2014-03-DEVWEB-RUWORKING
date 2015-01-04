package service.viewdetail;

public class mainArticle {
	String name = new String();
	String partyName = new String();
	String title = new String();
	String content = new String();
	String img_url = new String();
	
	public mainArticle(String name, String partyName, String title, String content) {
		this.name = name;
		this.partyName = partyName;
		this.title = title;
		this.content = content;
	}
	
	public mainArticle(String name, String partyName, String title, String content, String img_url) {
		this(name, partyName, title, content);
		this.img_url = img_url
				;
	}
}
