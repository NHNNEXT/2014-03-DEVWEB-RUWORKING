package service.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.article.ArticleModel;

public class GetBoardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int promiseId = Integer.parseInt(request.getParameter("promiseId"));

		BoardModel model = new BoardModel();
		ArrayList<String> articleList = null;

		try {
			articleList = model.getArticleBoard(promiseId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("articleBoard", articleList);
		RequestDispatcher rd = request.getRequestDispatcher("");
		rd.forward(request, response);
	}

}
