package service.article;

import java.io.IOException;
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
		String memberId = (String) session.getAttribute("userId"); //DB재설계 필요 - member table에서 id가 primary key여야 함.
		int promiseNum = Integer.parseInt(request.getParameter("promiseNumber"));
		//if문으로 대통령인지 국회의원인지 check하는 코드 필요하다.
		int round = Integer.parseInt(this.getServletContext().getInitParameter("roundOfAssembly")); 
		int pid = Integer.parseInt(request.getParameter("pid"));	
	
		ArticleModel articleModel = new ArticleModel();
		try {
			articleModel.postArticle(title, content, memberId, promiseNum, round, pid);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//politician id로 redirect 해야하지 않을까?
		response.sendRedirect("/module/politician/politician.jsp");
	}	
}
