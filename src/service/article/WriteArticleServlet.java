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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class WriteArticleServlet
 */
@WebServlet("/WriteArticle.ruw")
public class WriteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //이게 무슨 뜻일까?

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에 아이디 없으면 로그인 페이지로 redirect 
		HttpSession session = request.getSession();
		if(session.getAttribute("userId") == null) {
			RequestDispatcher view = request.getRequestDispatcher("module/evidence/writeFail.jsp");
			view.forward(request, response);		
		}
		int politicianId = Integer.parseInt(request.getParameter("pid"));
		ArticleModel articleModel = new ArticleModel();
		List<String> promiseList = null;
		try {
			promiseList = articleModel.getPromiseTitle(politicianId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("promiseList", promiseList);
		request.setAttribute("politicianId", politicianId);
		RequestDispatcher view = request.getRequestDispatcher("module/evidence/upload.jsp");
		view.forward(request, response);
	}
}