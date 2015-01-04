package service.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.ruw")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] cardList = {"cardA", "cardB", "cardB", "cardA", "cardC", "cardC", "cardC", "cardC"};
		MainModel mainModel = new MainModel();

		request.setAttribute("Top5List", mainModel.getRankedFulfillment(5));
		request.setAttribute("DDay", mainModel.getPoliticianTermD_Day());
				
		request.setAttribute("mainArticleNotImage", mainModel.getRecentArticleNotImage());
		request.setAttribute("mainArticleImage", mainModel.getRecentArticleImage());
		request.setAttribute("cardList", cardList);
		
		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
		view.forward(request, response);
	}
}
