package application.postrequest;

public class Politician {
	private String imageURL = new String();
	private String pdfURL = new String();
	
	 public String getImageURL() {
		return imageURL;
	}
	 public String getPdfURL() {
		return pdfURL;
	}
	 public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	 public void setPdfURL(String pdfURL) {
		this.pdfURL = pdfURL;
	}
}
