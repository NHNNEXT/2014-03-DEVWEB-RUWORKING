package service.viewdetail;

public class Promise {

	private String title;
	private String content;
	private int percent;
	
	public Promise(String title, String content, int voteScore, int voteCount){
		this.title = title;
		this.content=content;
		this.percent = getPercent(voteScore, voteCount);
	}

	private int getPercent(int voteScore, int voteCount) {
		if(voteCount==0) return 0;
		return voteScore/voteCount;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	public int getPercent() {
		return percent;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	
}
