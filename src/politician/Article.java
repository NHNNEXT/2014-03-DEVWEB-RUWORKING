package politician;

public class Article {

	private String title;
	private String content;
	private int politicianId;
	private int memberNumber;
	private int id;
	private int promiseId;
	
	public Article(){
		
	}
	
	public Article(String title, String content, int politicianId, int memberNumber, int promiseId){
		this( null, title, content, politicianId, memberNumber, promiseId);
	}
	
	public Article(Integer id, String title, String content,
			int politicianId, int memberNumber, int promiseId) {
		this.id= id;
		this.title = title;
		this.content = content;
		this.politicianId = politicianId;
		this.memberNumber = memberNumber;
		this.promiseId = promiseId;
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
	public int getId() {
		return id;
	}

	public int getPromiseId() {
		return promiseId;
	}

}