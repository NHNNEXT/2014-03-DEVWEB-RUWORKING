package register;

import java.sql.SQLException;

import application.pdfparser.changeurl.changeURL;

public class changeImageURLTest {
	public void changeImageUrl() throws SQLException {
		changeURL changer = new changeURL();
		changer.change();
	}
}
