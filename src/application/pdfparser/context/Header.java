package application.pdfparser.context;

import java.sql.SQLException;
import java.util.ArrayList;

import application.pdfparser.dao.PdfModel;
import application.postrequest.Politician;

public class Header extends Context {
	StringBuffer header = new StringBuffer();
	String location = new String();
	String name = new String();
	String party = new String();

	@Override
	public void pushStringBuffer(String string) {
		header.append(string);
	}
	
	public String getLocation() {
		return location;
	}
	public String getName() {
		return name;
	}
	public String getParty() {
		return party;
	}
	
	public int parse(ArrayList <Politician> poli, int idx) throws SQLException {
		PdfModel model = new PdfModel();

		location = header.toString().split("선거구명")[1].split("후보자명")[0].trim().split(" ")[0];
		name = header.toString().split("선거구명")[1].split("후보자명 ")[1].split(" ")[0].trim();
		party = header.toString().split("소속정당명")[1].trim();
		
		System.out.println("name : " + name + " location : " + location + " party : " + party);
		return model.addPolitition(this, poli, idx);
	}
}
