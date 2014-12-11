package service.article;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetArticleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int articleId = Integer.parseInt(request.getParameter("articleId"));
		ArticleModel art = new ArticleModel();
		Article article = null;
		try {
			article = art.getArticle(articleId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("article", article);

		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}
	
	
}