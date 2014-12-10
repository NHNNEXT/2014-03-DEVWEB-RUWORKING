package service.article;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Splitter;

class URIParser {
	public static Map<String, String> parseURI (String uri){
		if(uri == null) {
			throw new IllegalArgumentException("uri should not be null");
		}
		Map<String, String> ids = new HashMap<String, String>();
		String query = uri.split("\\?")[1];
        ids = Splitter.on('&').trimResults().withKeyValueSeparator("=").split(query);
		return ids;
	}
}
