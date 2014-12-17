package service.article;

import java.util.Map;
import junit.framework.TestCase;

public class URIParserTest extends TestCase {
	public void testUriParser() throws Exception {
		String uri = "http://localhost:8080/module/politician/test.ruw?promise1=1&promise2=2&promise3=3&promise4=4&promise5=5"; 
		Map<String, String> result = URIParser.parseURI(uri);
		assertEquals(result.get("promise1"), "1");
		assertEquals(result.get("promise2"), "2");
		assertEquals(result.get("promise3"), "3");
		assertEquals(result.get("promise4"), "4");
		assertEquals(result.get("promise5"), "5");
	}
	
	public void testUriParser2() throws Exception {
		String uri = "http://localhost:8080/module/politician/test.ruw?pid=1&round=18"; 
		Map<String, String> result = URIParser.parseURI(uri);
		assertEquals(result.get("pid"), "1");
		assertEquals(result.get("round"), "18");
	}
}
