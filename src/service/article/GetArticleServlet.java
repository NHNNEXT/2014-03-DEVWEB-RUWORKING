package service.article;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.comment.CommentModel;

@WebServlet("/GetArticle.ruw")
public class GetArticleServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ArrayList<Object> articleIngredients = new ArrayList<Object>();
		articleIngredients.add(request.getParameter("article-id"));
		ArticleModel model = new ArticleModel();
		Article article = model.getArticle(articleIngredients);
		
		ArrayList<Object> commentsIngredients = new ArrayList<Object>();
		commentsIngredients.add(request.getParameter("ancestor-id"));
		CommentModel commentModel = new CommentModel();
		List comments= commentModel.getComments(commentsIngredients);
		
				
		request.setAttribute("article", article);
		request.setAttribute("commentList", comments);

		RequestDispatcher view = request.getRequestDispatcher("module/evidence/show.jsp");
		view.forward(request, response);		
		
	}
}
