package register;
import application.pdfparser.*;

public class PDFparserTest {
	public void testPDFParser() {
		Converter converter = new Converter();
		Downloader downloader = new Downloader();
		downloader.DownloadPdf();
		
		for(int i=0; i<241; i++) {
			try {
				converter.changePDFtoText(i);			
			} catch(Exception e) {
				System.out.println("num : "+ i);
				e.printStackTrace();
			}
		}
	}
	
}
