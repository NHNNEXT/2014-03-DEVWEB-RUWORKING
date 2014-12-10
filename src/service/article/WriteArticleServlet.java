package service.article;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
		String uri = request.getRequestURI();
		Map<String, String> infoForPromise = URIParser.parseURI(uri);
		ArticleModel articleModel = new ArticleModel();
		List<String> promiseList = articleModel.getPromiseContent(infoForPromise.get("pid"), infoForPromise.get("round"));
		//해당 정치인의 공약을 순서대로 리턴함
		request.setAttribute("promiseList", promiseList);
		RequestDispatcher view = request.getRequestDispatcher("module/evidence/upload.jsp");
		view.forward(request, response);
	}
}