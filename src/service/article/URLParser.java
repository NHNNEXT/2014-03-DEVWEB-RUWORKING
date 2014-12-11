package service.article;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Splitter;

class URLParser {
	public Map<String, String> parsePromiseId (String url){
		Map<String, String> promiseIds = new HashMap<String, String>();
		String query = url.split("\\?")[1];
        promiseIds = Splitter.on('&').trimResults().withKeyValueSeparator("=").split(query);
		return promiseIds;
	}
}
