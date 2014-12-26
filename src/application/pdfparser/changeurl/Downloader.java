package application.pdfparser.changeurl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Downloader {
	public void downloadImage(String downloadPath, ArrayList<String> list) {
		URL url;
		InputStream in = null;

		int length = -1;
		FileOutputStream fop = null;
		try {
			for(int i = 0; i<list.size(); i++) {
				
				url = new URL(list.get(i));
				in = url.openStream();
				fop = new FileOutputStream(new File(downloadPath + i + ".jpg"));
				
				byte [] contentInBytes = new byte[1024];
				
				while((length = in.read(contentInBytes)) > -1) {
					fop.write(contentInBytes, 0, length);
				}
				fop.flush();
				fop.getFD().sync();
			}
		}catch(MalformedURLException mue) {
			mue.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			System.out.println("image file download end");
			try {
				if(in != null) in.close();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}
