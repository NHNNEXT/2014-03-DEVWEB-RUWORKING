package service.vote;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Vote.ruw")
public class VoteServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        HttpSession session = request.getSession();
        if(session.getAttribute("userId") == null) {
        	String errorMessage = "로그인을 하지 않으시면 투표하실 수 없습니다.";
        	request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher view = request.getRequestDispatcher("module/login/loginFail.jsp");
			view.forward(request, response);		
		}
        String score = request.getParameter("score");
        String politicianId = request.getParameter("politician-id");
        String promiseNum = request.getParameter("promise-num");
        String userId = (String) session.getAttribute("userId");
        VoteModel model = new VoteModel();
        
        try {
            model.addOpinion(score, politicianId, promiseNum);      
           // model.checkVote(userId, politicianId, promiseNum);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
                
        response.sendRedirect("/viewDetail.ruw?pid="+politicianId);
    }
    
}



