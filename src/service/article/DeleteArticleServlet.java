package service.article;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteArticle.ruw")
public class DeleteArticleServlet extends HttpServlet{

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
		int politicianId = article.getPoliticianId();
		try {
			if(articleModel.deleteArticleById(articleIngredients)){
				response.sendRedirect("viewDetail.ruw?pid="+politicianId);
			}else {
				//경고창 띄우기 "서버 문제로 게시글이 삭제되지 않았습니다." 	
				String message = "서버 문제로 게시글이 삭제되지 않았습니다. 이용에 불편을 드려 죄송합니다.";
				alertMessage(response, message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//uploadArticleServlet에 있는 코드. 중복제거해야 한다.
	private void alertMessage(HttpServletResponse response, String message)
			throws IOException {
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<script type=\"text/javascript\">alert(" + message
				+ ");</script>");
		out.print("</head><body></body></html>");
	}
}