package application.pdfparser.context;

import java.util.ArrayList;

import application.pdfparser.dao.PdfModel;
import application.postrequest.Politician;

public class Promise extends Context {
	StringBuffer promiseBuffer = new StringBuffer();
	StringBuffer promise = new StringBuffer();
	String promiseTitle = new String();
	String promiseNum = new String();
	
	@Override
	public void pushStringBuffer(String string) {
		promiseBuffer.append(string);
	}
	
	public String getPromise() {
		return promise.toString();
	}
	
	public String getPromiseNum() {
		return promiseNum;
	}
	
	public String getPromiseTitle() {
		return promiseTitle;
	}
	
	public void parse(int poliId) throws Exception {
			PdfModel model = new PdfModel();
			boolean copyFlag = false;
			boolean numFlag = true;
			boolean titleFlag = true;
			String [] lines = promiseBuffer.toString().split("\n");
			for(int i=0; i<lines.length; i++) {
				if(copyFlag == true) {
					promise.append(lines[i] + "\n");
				}
				if(lines[i].matches(".*번호.*") && numFlag) {
					promiseNum = Character.toString(promiseBuffer.toString().split(": ")[1].charAt(0));
					numFlag = false;
				}
				if(lines[i].matches(".*제목.*") && titleFlag) {
					promiseTitle = lines[i].split("제목 :")[1];
					titleFlag = false;
					copyFlag = true;
				}
			}
			System.out.println("공약번호 :" +  promiseNum);
			System.out.println("타이틀 :" +  promiseTitle);
			model.addPromise(this, poliId);
	}

}
