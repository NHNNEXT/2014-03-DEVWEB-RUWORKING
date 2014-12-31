/**
 * @작성자  : hataeho
 */
package service.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/search.ruw")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchQuery = request.getParameter("userQuery");
		SearchModel searchModel = new SearchModel();
		
		List<Politician> politicianList = searchModel.getResult(searchQuery);
		request.setAttribute("Query", searchQuery);
		request.setAttribute("Politician", politicianList);
			
		RequestDispatcher view = request.getRequestDispatcher("/module/search/search.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchQuery = request.getParameter("userQuery");
		SearchModel searchModel = new SearchModel();
		
		searchQuery = new String(searchQuery.getBytes("ISO-8859-1"), "utf-8");
		
		List<Politician> politicianList = searchModel.getQuickSearchResult(searchQuery);
		 response.setContentType("application/json");
	     response.setCharacterEncoding("UTF-8");
	     response.getWriter().write(new Gson().toJson(politicianList));
	}
}
