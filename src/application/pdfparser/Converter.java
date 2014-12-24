package application.pdfparser;

import java.util.ArrayList;

import application.postrequest.Politician;

public class Converter {	
	public void changePDFtoText(int pdfNum, ArrayList<Politician> poliURL) throws Exception {
		ChangePDFtoText parser = new ChangePDFtoText();
		parser.changePDF("/Users/chaejong-un/Desktop/PDFDownloadTest/" + pdfNum + ".pdf");		
		StringBuffer textBuf = parser.getParsedText();
		
		String [] lines = textBuf.toString().split("\n");
		parseText textParser = new parseText();
		
		textParser.parse(lines, pdfNum, poliURL);		
	}
}
