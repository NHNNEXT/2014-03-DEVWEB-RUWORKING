package service.viewdetail;

public class Promise {

	private String title;
	private int percent;
	
	public Promise(String title, int voteScore, int voteCount){
		this.title = title;
		this.percent = getPercent(voteScore, voteCount);
	}

	private int getPercent(int voteScore, int voteCount) {
		if(voteCount==0) return 0;
		return voteScore/voteCount;		
	}

	public String getTitle() {
		return title;
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
