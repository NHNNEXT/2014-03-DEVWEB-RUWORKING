package politician;

public class Article {

	private String title;
	private String content;
	private int politicianId;
	private int memberNumber;
	
	public Article(String title, String content, int politicianId, int memberNumber){
		this.title = title;
		this.content = content;
		this.politicianId = politicianId;
		this.memberNumber = memberNumber;
	}
	
	
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public int getPoliticianId() {
		return politicianId;
	}
	public int getMemberNumber() {
		return memberNumber;
	}


}