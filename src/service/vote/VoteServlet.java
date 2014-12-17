package service.vote;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Vote.ruw")
public class VoteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String score = request.getParameter("score");
		String politicianId = request.getParameter("politician-id");
		String promiseNum = request.getParameter("promise-num");
		
		VoteModel model = new VoteModel();
		
		try {
			model.addOpinion(score, politicianId, promiseNum);		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		response.sendRedirect("/viewDetail.ruw?pid="+politicianId);
		
	}
}
