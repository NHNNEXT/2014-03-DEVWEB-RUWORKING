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

import service.comment.CommentModel;

@WebServlet("/GetArticle.ruw")
public class GetArticleServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String articleId = request.getParameter("article-id");
		ArticleModel model = new ArticleModel();
		CommentModel commentModel = new CommentModel();
		
		List commentList= commentModel.getCommentList(articleId);
		Article article = model.getArticle(articleId);
		
		request.setAttribute("article", article);
		request.setAttribute("commentList", commentList);

		RequestDispatcher view = request.getRequestDispatcher("module/evidence/show.jsp");
		view.forward(request, response);		
		
	}
}
