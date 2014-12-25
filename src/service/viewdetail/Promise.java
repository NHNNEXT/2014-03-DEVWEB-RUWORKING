package service.viewdetail;

public class Promise {

	private String title;
	private String content;
	private int percent;
	private int promiseNum;
	
	public Promise(String title, String content, int voteScore, int voteCount, int promiseNum){
		this.title = title;
		this.content=content;
		this.percent = getPercent(voteScore, voteCount);
		this.promiseNum = promiseNum;
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

	public int getPromiseNum() {
		return promiseNum;
	}

	
}
