package service.article;

import java.util.Map;
import junit.framework.TestCase;

public class urlParserTest extends TestCase {
	public void testUrlParser() throws Exception {
		String url = "http://localhost:8080/module/politician/test.ruw?promise1=1&promise2=2&promise3=3&promise4=4&promise5=5";
		URLParser urlParser = new URLParser(); 
		Map<String, String> result = urlParser.parsePromiseId(url);
		assertEquals(result.get("promise1"), "1");
		assertEquals(result.get("promise2"), "2");
		assertEquals(result.get("promise3"), "3");
		assertEquals(result.get("promise4"), "4");
		assertEquals(result.get("promise5"), "5");
	}
}
