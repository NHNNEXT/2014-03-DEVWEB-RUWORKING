package application.pdfparser;

public class Converter {	
	public void changePDFtoText(int pdfNum) throws Exception {
		ChangePDFtoText parser = new ChangePDFtoText();
		parser.changePDF("/Users/chaejong-un/Desktop/PDFDownloadTest/" + pdfNum + ".pdf");		
		StringBuffer textBuf = parser.getParsedText();
		
		String [] lines = textBuf.toString().split("\n");
		parseText textParser = new parseText();
		
		textParser.parse(lines);		
	}
}
