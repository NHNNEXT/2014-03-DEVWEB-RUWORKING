package service.article;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetArticleBoardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int promiseId = Integer.parseInt(request.getParameter("promiseId"));

		ArticleModel art = new ArticleModel();
		ArrayList<String> articleBoard = null;

		try {
			articleBoard = art.getArticleBoard(promiseId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("articleBoard", articleBoard);
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}

}
