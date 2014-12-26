package register;
import java.util.ArrayList;

import application.pdfparser.*;
import application.postrequest.Politician;

public class PDFparserTest {
	public void testPDFParser(String absoluteURL) {
		Converter converter = new Converter();
		Downloader downloader = new Downloader();
		ArrayList <Politician> poliURL = downloader.DownloadPdf(absoluteURL);
		
		for(int i=0; i<241; i++) {
			try {
				converter.changePDFtoText(i, poliURL, absoluteURL);			
			} catch(Exception e) {
				System.out.println("num : "+ i);
				e.printStackTrace();
			}
		}
	}
}
