package service.main;

public class LocalInfo {

	private String local;
	private int percent;
	
	public LocalInfo(String local, int localSum, int politicianNum) {
		this.local = local;
		this.percent = localSum/politicianNum;
	}


	public String getLocal() {
		return local;
	}

	public int getPercent() {
		return percent;
	}
	
	
}
