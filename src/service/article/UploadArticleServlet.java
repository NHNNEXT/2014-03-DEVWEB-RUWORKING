package service.article;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadArticleServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int politicianId = Integer.parseInt(request.getParameter("politicianId"));
		int promiseId = Integer.parseInt(request.getParameter("promiseId"));
		int memberNumber = Integer.parseInt(request.getParameter("memberNumber"));
	
		ArticleModel art = new ArticleModel();
		
		try {
			art.postArticle(title, content, politicianId, promiseId, memberNumber);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("");

	}	
}
