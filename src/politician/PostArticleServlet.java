package politician;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostArticleServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int politicianId = Integer.parseInt(request.getParameter("politicianId"));
		int memberNumber = Integer.parseInt(request.getParameter("memberNumber"));
	
		Article article = new Article(title, content, politicianId, memberNumber);
		ArticleDAO articleDAO = new ArticleDAO();
		
		try {
			articleDAO.addArticle(article);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
}

