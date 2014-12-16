package application.pdfparser.context;

public class Promise extends Context {
	StringBuffer promiseBuffer = new StringBuffer();
	StringBuffer promise = new StringBuffer();
	String promiseTitle = new String();
	char promiseNum;
	
	@Override
	public void pushStringBuffer(String string) {
		promiseBuffer.append(string);
	}
	
	public void parse() throws Exception {
			boolean copyFlag = false;
			boolean numFlag = true;
			boolean titleFlag = true;
			String [] lines = promiseBuffer.toString().split("\n");
			for(int i=0; i<lines.length; i++) {
				if(copyFlag == true) {
					promise.append(lines[i] + "\n");
				}
				if(lines[i].matches(".*번호.*") && numFlag) {
					promiseNum = promiseBuffer.toString().split(": ")[1].charAt(0);
					numFlag = false;
				}
				if(lines[i].matches(".*제목.*") && titleFlag) {
					promiseTitle = lines[i].split("제목 :")[1];
					titleFlag = false;
					copyFlag = true;
				}
			}
//			System.out.println("========================================");
//			System.out.println(promiseBuffer.toString());
//			System.out.println("========================================");
			System.out.println("공약번호 :" +  promiseNum);
			System.out.println("타이틀 :" +  promiseTitle);
//			System.out.println("공약내용 :" +  promise.toString());			
	}

}
