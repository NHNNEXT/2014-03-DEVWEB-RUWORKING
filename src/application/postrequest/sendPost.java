
package application.postrequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 

public class sendPost {
	private final String USER_AGENT = "Mozilla/5.0";
	private Politician[] temArray = new Politician[10];

	public sendPost() {
		for(int i = 0; i<temArray.length; i++) {
			temArray[i] = new Politician();
		}
	}
	
	public ArrayList<Politician> sendPostMsg(String url) throws Exception {
		int count;
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
 
		// add header
		post.setHeader("User-Agent", USER_AGENT);
		ArrayList<Politician> ret = new ArrayList<Politician>();
		
		for(int i = 1; i<28; i++) {
			List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("sungerCode", "02"));
			urlParameters.add(new BasicNameValuePair("page", String.valueOf(i)));
			
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			
			HttpResponse response = client.execute(post);
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + post.getEntity());
			System.out.println("Response Code : " + 
					response.getStatusLine().getStatusCode());
			
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));
			
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			
			Document doc = Jsoup.parse(result.toString());
			Elements pdfRows = doc.getElementsByClass("pm01");
			Elements imgRows = doc.getElementsByClass("profile_list").select("img");
			count = 0;
			for(Element row : pdfRows) {
				temArray[count++].setPdfURL(row.attr("href"));
			}
			count = 0;
			for (Element element : imgRows) {
				temArray[count++].setImageURL(element.attr("src"));
			}
			
			for(count = 0; count<pdfRows.size(); count++) {
				Politician poli = new Politician();
				poli.setImageURL(temArray[count].getImageURL());
				poli.setPdfURL(temArray[count].getPdfURL());
				ret.add(poli);
			}
		}
		
		return ret;
	}
	
}
