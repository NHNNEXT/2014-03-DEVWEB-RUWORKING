package application.pdfparser.changeurl;

import java.sql.SQLException;
import java.util.ArrayList;

/*  모델을 생성해서 데이터를 끌어온다.
 *  끌어온 url 앞에 전체 url 을 붙인 다음에 
 *  그 url 기준으로 download 를 수행하여 이미지를 저장한다.
 *  그 후에 전체 url 을 update로 전환하여 url 을 다시 넣는다.
 */

public class changeURL {
	public void change() throws SQLException {
		urlChangeModel model = new urlChangeModel();
		Downloader down = new Downloader();
		setRealURL real = new setRealURL();
		
		ArrayList <String> list = model.getImageURL();
		list = real.setURL(list, "http://policy.nec.go.kr");
		down.downloadImage("/WebApp/data/image", list);
		model.setImageURL(list);
	}
}
