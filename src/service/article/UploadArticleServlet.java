package service.article;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/Upload.ruw")
public class UploadArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String relativePath = "/userData/articleImg";
		String savePath = request.getServletContext().getRealPath(relativePath);
		
		int sizeLimit = 1024*1024*50;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
		HttpSession session = request.getSession();
		String title = multi.getParameter("articleTitle");
		String content = multi.getParameter("articleContent");
		int version = Integer.parseInt(multi.getParameter("version"));
		String userId = (String) session.getAttribute("userId");
		int promiseNum = Integer.parseInt(multi.getParameter("promiseNumber"));
		int politicianId = Integer.parseInt((String)multi.getParameter("politicianId"));
		String fileName = multi.getFilesystemName("attachedFile"); 
		String filePath = relativePath+"/"+fileName;
		Article article = new Article.Builder(title, content, filePath, version, userId, promiseNum, politicianId).build();
		ArticleModel articleModel = new ArticleModel();

		if(multi.getParameter("ancestorId") == null) {
			//올릴 때
			try {
				articleModel.postArticle(article);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			//수정할 때
			int ancestorId = Integer.parseInt(multi.getParameter("ancestorId"));
			try {
				articleModel.postArticle(article, ancestorId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.sendRedirect("/viewDetail.ruw?pid=" + politicianId);
	}
}
