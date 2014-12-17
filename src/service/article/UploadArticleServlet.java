package service.article;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Upload.ruw")
public class UploadArticleServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String title = request.getParameter("articleTitle");
		String content = request.getParameter("articleContent");
		String userId = (String) session.getAttribute("userId");
		int promiseNum = Integer.parseInt(request.getParameter("promiseNumber"));
		System.out.println(request.getParameter("politicianId"));
		int politicianId = Integer.parseInt((String)request.getParameter("politicianId"));	
	
		ArticleModel articleModel = new ArticleModel();
		try {
			boolean check = articleModel.postArticle(title, content, userId, promiseNum, politicianId);
			if(!check){
				String errorMessage = "로그인을 하지 않으시면 증거자료를 올리실 수 없습니다!";
				alertMessage(response, errorMessage);
				response.sendRedirect("/viewDetail.ruw?pid=" + politicianId); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//politician id로 redirect 해야하지 않을까?
		response.sendRedirect("/viewDetail.ruw?pid=" + politicianId);
	}	
	
	private void alertMessage(HttpServletResponse response, String message) throws IOException {
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<script type=\"text/javascript\">alert(" + message + ");</script>");
		out.print("</head><body></body></html>");
	}
}
