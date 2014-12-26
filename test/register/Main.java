package register;

import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {
		String absoluteURL = "/Users/chaejong-un/git/2014-03-DEVWEB-RUWORKING/WebApp";
		PDFparserTest downPdf = new PDFparserTest();
		downPdf.testPDFParser(absoluteURL);
		changeImageURLTest insertImage = new changeImageURLTest();
		insertImage.changeImageUrl(absoluteURL);
	}
}
