package application.pdfparser.changeurl;

import java.util.ArrayList;

public class setRealURL {

	public ArrayList<String> setURL(ArrayList<String> list, String original) {
		ArrayList<String> ret = new ArrayList<String>();
		for (String string : list) {
			String insertURL = original + string;
			ret.add(insertURL);
		}
		return ret;
	}

}
