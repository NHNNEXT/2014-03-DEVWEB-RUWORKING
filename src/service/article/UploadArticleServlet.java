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
		//System.out.println(savePath);
		
		int sizeLimit = 1024*1024*50;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
		HttpSession session = request.getSession();
		String title = multi.getParameter("articleTitle");
		String content = multi.getParameter("articleContent");
		String userId = (String) session.getAttribute("userId");
		int promiseNum = Integer.parseInt(multi.getParameter("promiseNumber"));
		int politicianId = Integer.parseInt((String)multi.getParameter("politicianId"));
		String fileName = multi.getFilesystemName("attachedFile"); 
		String filePath = relativePath+"/"+fileName;
		
		Article article = new Article(title, content, filePath, null, userId, promiseNum, politicianId);
		ArticleModel articleModel = new ArticleModel();
		
		boolean check;
		try {
			check = articleModel.postArticle(article);
			if (!check) {
				String errorMessage = "로그인을 하지 않으시면 증거자료를 올리실 수 없습니다!";
				alertMessage(response, errorMessage);
				response.sendRedirect("/viewDetail.ruw?pid=" + politicianId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/viewDetail.ruw?pid=" + politicianId);
	}

	private void alertMessage(HttpServletResponse response, String message)
			throws IOException {
		PrintWriter out = response.getWriter();
		out.print("<html><head>");
		out.print("<script type=\"text/javascript\">alert(" + message
				+ ");</script>");
		out.print("</head><body></body></html>");
	}
}
