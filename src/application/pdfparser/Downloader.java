package application.pdfparser;

import java.util.ArrayList;

import application.pdfparser.download.PDFFileDownload;
import application.postrequest.sendPost;

public class Downloader {
	public void DownloadPdf() {
		PDFFileDownload down = new PDFFileDownload();
		sendPost poster = new sendPost();
		try {
			ArrayList<String> urls = poster.sendPostMsg("http://policy.nec.go.kr/svc/policy/PolicyList.do"); 
			down.Download(urls);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
