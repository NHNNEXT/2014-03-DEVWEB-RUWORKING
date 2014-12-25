package service.vote;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

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
			return;
		}
        String score = request.getParameter("score");
        String politicianId = request.getParameter("politician-id");
        String promiseNum = request.getParameter("promise-num");
        String userId = (String) session.getAttribute("userId");
        System.out.println(politicianId);
        System.out.println(promiseNum);
        VoteModel model = new VoteModel();
        
        boolean voted = model.alreadyVoted(userId, politicianId, promiseNum);

        if(!voted){

        model.checkVoteList(userId, politicianId, promiseNum);
        model.vote(score, politicianId, promiseNum);      
        }
		Gson gson = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(voted));
    }
    
    
}



