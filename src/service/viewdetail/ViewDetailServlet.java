/**
 * @작성자  : hataeho
 */
package service.viewdetail;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.search.Politician;

@WebServlet("/viewDetail.ruw")
public class ViewDetailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int pid = Integer.parseInt(request.getParameter("pid"));
		ViewDetailModel model = new ViewDetailModel();
		
		Politician politician = model.getPolitician(pid);
		ArrayList<String> promiseTitles = model.getPromiseTitles(pid);
		
		request.setAttribute("politician", politician);
		request.setAttribute("promiseTitles", promiseTitles);
		request.setAttribute("pid", pid);
		
		RequestDispatcher view = request.getRequestDispatcher("module/politician/politician.jsp");
		view.forward(request, response);
	}
}
