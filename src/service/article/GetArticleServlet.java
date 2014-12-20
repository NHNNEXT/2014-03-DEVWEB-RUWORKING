package service.article;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetArticle.ruw")
public class GetArticleServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String articleId = request.getParameter("article-id");
		
		ArticleModel model = new ArticleModel();
		Article article=null;
		try {
			article = model.getArticle(articleId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("article", article);
	
		RequestDispatcher view = request.getRequestDispatcher("module/evidence/show.jsp");
		view.forward(request, response);		
		
	}

	
}
