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

	public ArrayList sendPostMsg() throws Exception {
		String url = "http://policy.nec.go.kr/svc/policy/PolicyList.do";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
 
		// add header
		post.setHeader("User-Agent", USER_AGENT);
		ArrayList<String> ret = new ArrayList<String>();
		
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
			Elements rows = doc.getElementsByClass("pm01");
			for(Element row : rows) {
				ret.add(row.attr("href"));
				System.out.println(row.attr("href"));
			}			
		}
		return ret;
	}
	
}
