/**
 * @작성자  : hataeho
 */
package service.viewdetail;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
		Map<Integer, List> relatedPostMap = model.getPromiseRelatePostList(pid);
		int percent = model.getTotalPercent(promises);
		
		request.setAttribute("politician", politician);
		request.setAttribute("promises", promises);
		request.setAttribute("percent", percent);
		request.setAttribute("relatePostMap", relatedPostMap);
		
		RequestDispatcher view = request.getRequestDispatcher("module/politician/politician.jsp");
		view.forward(request, response);
	}
}
