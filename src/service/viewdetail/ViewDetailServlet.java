/**
 * @작성자  : hataeho
 */
package service.viewdetail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

		String pid = request.getParameter("pid");
		ViewDetailModel model = new ViewDetailModel();
		
		Politician politician = model.getPolitician(pid);
		
		List<Promise> promises = model.getPromises(pid);
		int percent = model.getTotalPercent(promises);

		request.setAttribute("politician", politician);
		request.setAttribute("promises", promises);
		request.setAttribute("pid", pid);
		request.setAttribute("percent", percent);
		
		RequestDispatcher view = request.getRequestDispatcher("module/politician/politician.jsp");
		view.forward(request, response);
	}
}
