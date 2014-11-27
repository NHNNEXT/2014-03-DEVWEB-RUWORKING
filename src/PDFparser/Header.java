package PDFparser;

public class Header extends Context{
	StringBuffer header = new StringBuffer();
	String location = new String();
	String name = new String();
	String party = new String();
	
	@Override
	public void pushStringBuffer(String string) {
		 header.append(string);
	}
	public void parse() {
		
			location = header.toString().split("선거구명")[1].split("후보자명")[0];
			name = header.toString().split("선거구명")[1].split("후보자명 ")[1].split(" ")[0];
			party = header.toString().split("소속정당명")[1];
			System.out.println("name : " + name + " location : " + location + " party : " + party);			
		
	}
	
}
