package service.party;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Parties.ruw")
public class ShowPartyServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//파티 이름 다 가져오기. 파티 아이디 다 가져오기.
		//(전체 의원수 레퀘스트에 묶기?)
		//파티 아이디별로 의원수 저장한 리스트 리퀘스트에 
		//파티 아이디별로 평균공약율 저장하기
		PartyModel partyModel = new PartyModel();
		List<Party> partyList = partyModel.getPartyList();
		int totalPoliticianNumber = 0;
		for(Party party : partyList){
			totalPoliticianNumber += party.getPoliticianNumber();
		}
		request.setAttribute("partyList", partyList);
		request.setAttribute("totalPoliticianNumber", totalPoliticianNumber);
		RequestDispatcher view = request.getRequestDispatcher("/module/party/party.jsp");
		view.forward(request, response);
	}
}
