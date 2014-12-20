package service.viewdetail;

public class ArticleTitle {

	private String title;
	private String id;
	
	ArticleTitle(String id, String title){
		this.id = id;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public String getId() {
		return id;
	}
	
	
}
