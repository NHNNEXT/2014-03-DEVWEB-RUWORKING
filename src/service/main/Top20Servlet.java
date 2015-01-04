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

@WebServlet("/Top20.ruw")
public class Top20Servlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PoliticianRankingModel rankingModel = new PoliticianRankingModel();
			int startNum = 0;
			int amount = 20;
			List<Politician> politicianList = rankingModel.getPromiseList(startNum, amount);
			request.setAttribute("Politician", politicianList);
				
			RequestDispatcher view = request.getRequestDispatcher("/module/ranking/Top20.jsp");
			view.forward(request, response);
		}
}
