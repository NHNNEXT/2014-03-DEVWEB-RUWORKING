/**
 * @작성자  : hataeho
 */
package service.viewdetail;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewDetail.ruw")
public class ViewDetailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		request.setAttribute("pid", pid);
		RequestDispatcher view = request.getRequestDispatcher("module/politician/politician.jsp");
		view.forward(request, response);
	}
}
