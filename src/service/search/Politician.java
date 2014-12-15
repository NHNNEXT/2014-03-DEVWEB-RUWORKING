/**
 * @작성자  : hataeho
 */
package service.search;

public class Politician {
	private int politicianId;
	private String name;
	private String local;
	private int partyId;
	private String imgUrl;

	public Politician(int politicianId, String name, String local, int partyId, String imgUrl) {
		this.politicianId = politicianId;
		this.name = name;
		this.local = local;
		this.partyId = partyId;
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

	public int getPartyId() {
		return partyId;
	}

	public String getImgUrl() {
		return imgUrl;
	}
}
