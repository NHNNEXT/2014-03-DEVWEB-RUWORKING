package service.vote;

public class VoteResponse {

	private boolean alreadyVoted;
	private int totalPercent;
	private int eachPercent;
	
	VoteResponse(boolean alreadyVoted, int totalPercent, int eachPercent){
		this.alreadyVoted=alreadyVoted;
		this.totalPercent = totalPercent;
		this.eachPercent = eachPercent;		
	}

	public boolean isAlreadyVoted() {
		return alreadyVoted;
	}

	public int getTotalPercent() {
		return totalPercent;
	}

	public int getEachPercent() {
		return eachPercent;
	}
	
	
}
