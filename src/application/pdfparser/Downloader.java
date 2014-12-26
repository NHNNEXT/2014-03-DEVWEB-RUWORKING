package application.pdfparser;

import java.util.ArrayList;

import application.pdfparser.download.PDFFileDownload;
import application.postrequest.Politician;
import application.postrequest.sendPost;

public class Downloader {
	public ArrayList<Politician> DownloadPdf(String absoluteURL) {
		ArrayList<Politician> urls = null; 
		PDFFileDownload down = new PDFFileDownload();
		sendPost poster = new sendPost();
		try {
			urls = poster.sendPostMsg("http://policy.nec.go.kr/svc/policy/PolicyList.do"); 
			down.Download(urls, absoluteURL);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return urls;
	}
}
