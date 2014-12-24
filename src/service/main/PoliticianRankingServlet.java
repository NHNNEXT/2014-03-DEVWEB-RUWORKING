package service.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.search.Politician;

import com.google.gson.Gson;

@WebServlet("/ranking.ruw")
public class PoliticianRankingServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	int startNum = 0;
	int amount = 10;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PoliticianRankingModel rankingModel = new PoliticianRankingModel();
		
		List<Politician> politicianList = rankingModel.getPromiseList(startNum, amount);
		request.setAttribute("Politician", politicianList);
			
		RequestDispatcher view = request.getRequestDispatcher("/module/ranking/ranking.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int startNum = Integer.parseInt(request.getParameter("start"));
		System.out.println(startNum++);
		PoliticianRankingModel rankingModel = new PoliticianRankingModel();
		
		List<Politician> politicianList = rankingModel.getPromiseList(startNum, amount);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(new Gson().toJson(politicianList));
	}
}
