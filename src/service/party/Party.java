package service.party;

public class Party {
	private int id;
	private String name;
	private int politicianNumber;
	private int averageRatio; 
	
	public Party(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPoliticianNumber() {
		return politicianNumber;
	}


	public void setPoliticianNumber(int politicianNumber) {
		this.politicianNumber = politicianNumber;
	}


	public int getAverageRatio() {
		return averageRatio;
	}


	public void setAverageRatio(int averageRatio) {
		this.averageRatio = averageRatio;
	}
}
