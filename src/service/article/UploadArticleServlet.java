package service.article;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadArticleServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int promiseId = Integer.parseInt(request.getParameter("promiseId"));
		int memberNumber = Integer.parseInt(request.getParameter("memberNumber"));
	
		ArticleModel articleModel = new ArticleModel();
		
		try {
			articleModel.postArticle(title, content, memberNumber, promiseId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("");

	}	
}
