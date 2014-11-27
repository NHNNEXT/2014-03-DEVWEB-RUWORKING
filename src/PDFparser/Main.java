package PDFparser;

import java.util.ArrayList;


public class Main {
	private static void DownloadPdf() {
		PDFFileDownload d = new PDFFileDownload();
		sendPost p = new sendPost();
		try {
			ArrayList<String> urls = p.sendPostMsg();
			d.Download(urls);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private static void parsePdf(int pdfNum) throws Exception {
		ChangePDFtoText parser = new ChangePDFtoText();
		parser.changePDF("/Users/chaejong-un/Desktop/PDFDownloadTest/" + pdfNum + ".pdf");
		StringBuffer dd = parser.getParsedText();
		String [] lines = dd.toString().split("\n");
		System.out.println(dd.toString());
		parseText t = new parseText();
		t.parse(lines);		
	}
	
	
	public static void main(String[] args) {
		DownloadPdf();
		for(int i=0; i<241; i++) {
			try {
				parsePdf(i);				
			} catch(Exception e) {
				System.out.println("num : "+ i);
				e.printStackTrace();
			}
		}
	}

}
