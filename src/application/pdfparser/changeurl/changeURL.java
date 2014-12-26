package application.pdfparser.changeurl;

import java.sql.SQLException;
import java.util.ArrayList;

public class changeURL {
	public void change(String absoluteURL) throws SQLException {
		urlChangeModel model = new urlChangeModel();
		Downloader down = new Downloader();
		setRealURL real = new setRealURL();
		
		ArrayList <String> list = model.getImageURL();
		list = real.setURL(list, "http://policy.nec.go.kr");
		
		down.downloadImage(absoluteURL + "/serviceData/image/", list);
		model.setImageURL(list);
	}
}
