package service.article;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditArticle.ruw")
public class EditArticleServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Object> articleIngredients = new ArrayList<Object>();
		articleIngredients.add(request.getParameter("articleId"));
		ArticleModel articleModel = new ArticleModel();
		Article article = articleModel.getArticle(articleIngredients);
		String promiseTitle=null;
		try {
			promiseTitle = articleModel.getPromiseTitle(article.getPoliticianId(), article.getPromiseNum());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("article", article);
		request.setAttribute("promiseTitle", promiseTitle);
		RequestDispatcher view = request.getRequestDispatcher("module/evidence/upload.jsp");
		view.forward(request, response);		
	}
}