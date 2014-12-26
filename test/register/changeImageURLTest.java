package register;

import java.sql.SQLException;

import application.pdfparser.changeurl.changeURL;

public class changeImageURLTest {
	public void changeImageUrl(String absoluteURL) throws SQLException {
		changeURL changer = new changeURL();
		changer.change(absoluteURL);
	}
}
