import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;


public class ChangePDFtoText {
	private StringBuffer parsedText = null;;

	public ChangePDFtoText() {
		parsedText = new StringBuffer();
	}
	
	public StringBuffer getParsedText() {
		return parsedText;
	}

	public boolean changePDF(String fileName) {
			PDFParser parser;
			PDFTextStripper pdfStripper = null;
			PDDocument pdDoc = null;
			COSDocument cosDoc = null;
			File file = new File(fileName);
			if (!file.isFile()) {
				System.err.println("File " + fileName + " does not exist.");
				return false;
			}
			try {
				parser = new PDFParser(new FileInputStream(file));
			} catch (IOException e) {
				System.err.println("Unable to open PDF Parser. " + e.getMessage());
				return false;
			}
			try {
				parser.parse();
				cosDoc = parser.getDocument();
				pdfStripper = new PDFTextStripper();
				pdDoc = new PDDocument(cosDoc);
				pdfStripper.setStartPage(1);
				pdfStripper.setEndPage(5);
				parsedText.append(pdfStripper.getText(pdDoc));
			} catch (Exception e) {
				System.err
						.println("An exception occured in parsing the PDF Document."
								+ e.getMessage());
			} finally {
				try {
					if (cosDoc != null)
						cosDoc.close();
					if (pdDoc != null)
						pdDoc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return true;
	}
}
