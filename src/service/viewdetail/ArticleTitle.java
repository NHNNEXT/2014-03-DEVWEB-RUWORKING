package service.viewdetail;

public class ArticleTitle {

	private String title;
	private String id;
	private String ancestorId;
	
	ArticleTitle(String id, String title, String ancestorId){
		this.id = id;
		this.title = title;
		this.ancestorId = ancestorId;
	}

	public String getAncestorId() {
		return ancestorId;
	}

	public String getTitle() {
		return title;
	}

	public String getId() {
		return id;
	}
	
	
}
