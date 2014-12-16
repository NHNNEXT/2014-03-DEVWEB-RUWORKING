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
		String promiseId = "1";//getParameter로 받아와야함
		
		VoteModel model = new VoteModel();
		
		try {
			model.addOpinion(score, promiseId);		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		response.sendRedirect("/module/politician/politician.jsp");
		
	}
}
