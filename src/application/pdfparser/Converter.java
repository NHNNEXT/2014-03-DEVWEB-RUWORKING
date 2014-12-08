package application.pdfparser;

public class Converter {	
	public void changePDFtoText(int pdfNum) throws Exception {
		ChangePDFtoText parser = new ChangePDFtoText();
		parser.changePDF("/Users/hataeho/Desktop/PDFDownloadTest/" + pdfNum + ".pdf");
		
		StringBuffer dd = parser.getParsedText();
		
		String [] lines = dd.toString().split("\n");
		parseText textParser = new parseText();
		textParser.parse(lines);		
	}
}
