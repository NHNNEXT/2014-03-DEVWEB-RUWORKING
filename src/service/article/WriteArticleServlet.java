package service.article;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WriteArticleServlet
 */
@WebServlet("/WriteArticle.ruw")
public class WriteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //이게 무슨 뜻일까?

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		ArticleModel articleModel = new ArticleModel();
		List<String> promiseList = null;
		try {
			promiseList = articleModel.getPromiseTitle(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("promiseList", promiseList);
		request.setAttribute("politicianId", pid);
		RequestDispatcher view = request.getRequestDispatcher("module/evidence/upload.jsp");
		view.forward(request, response);
	}
}