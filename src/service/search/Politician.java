/**
 * @작성자  : hataeho
 */
package service.search;

public class Politician {
	private int politicianId;
	private String name;
	private String local;
	private String party;
	private String imgUrl;

	public Politician(int politicianId, String name, String local, String party, String imgUrl) {
		this.politicianId = politicianId;
		this.name = name;
		this.local = local;
		this.party = party;
		this.imgUrl = imgUrl;
	}

	public int getPoliticianId() {
		return politicianId;
	}

	public String getName() {
		return name;
	}

	public String getLocal() {
		return local;
	}

	public String getParty() {
		return party;
	}

	public String getImgUrl() {
		return imgUrl;
	}
}
