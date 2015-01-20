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
	private int promiseFulfillment;

	public static class Builder {
		private int politicianId;
		private String name;
		private String local;
		private String party;
		private String imgUrl;
		private int promiseFulfillment = 0;

		public Builder(int politicianId, String name, String local,
				String party, String imgUrl) {
			this.politicianId = politicianId;
			this.name = name;
			this.local = local;
			this.party = party;
			this.imgUrl = imgUrl;
		}

		public Builder promiseFulfillment(int val) {
			promiseFulfillment = val;
			return this;
		}

		public Politician build() {
			return new Politician(this);
		}
	}

	private Politician(Builder builder) {

		politicianId = builder.politicianId;
		name = builder.name;
		local = builder.local;
		party = builder.party;
		imgUrl = builder.imgUrl;
		promiseFulfillment = builder.promiseFulfillment;
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

	public int getPromiseFulfillment() {
		return promiseFulfillment;
	}
}
