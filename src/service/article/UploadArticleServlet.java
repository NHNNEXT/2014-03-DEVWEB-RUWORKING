package service.article;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

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

		ArrayList<Object> postArticleValues = makeQueryValues(request,
				relativePath, multi);
		ArticleModel articleModel = new ArticleModel();

		if(multi.getParameter("ancestorId") == null)
			postArticleValues.add(articleModel.getMaxArticleId());
		else
			postArticleValues.add(Integer.parseInt(multi.getParameter("ancestorId")));	
		
			
		try {
			articleModel.postArticle(postArticleValues);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("/viewDetail.ruw?pid=" + (String)multi.getParameter("politicianId"));
	}

	private ArrayList<Object> makeQueryValues(HttpServletRequest request,
			String relativePath, MultipartRequest multi) {
		ArrayList<Object> postArticleValues = new ArrayList<Object>();
		Timestamp date = new Timestamp(System.currentTimeMillis());
		HttpSession session = request.getSession();
		postArticleValues.add(multi.getParameter("articleTitle"));
		postArticleValues.add(multi.getParameter("articleContent"));
		postArticleValues.add(relativePath+"/"+multi.getFilesystemName("attachedFile"));
		postArticleValues.add(null);//Link 수정해야함
		postArticleValues.add(date);
		postArticleValues.add(Integer.parseInt(multi.getParameter("version")));
		postArticleValues.add((String) session.getAttribute("userId"));
		postArticleValues.add(Integer.parseInt(multi.getParameter("promiseNumber")));
		postArticleValues.add(Integer.parseInt((String)multi.getParameter("politicianId")));
		return postArticleValues;
	}
}
