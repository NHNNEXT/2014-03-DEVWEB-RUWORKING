package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login.ruw")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		if ((userId.equals("test1004") && userPw.equals("pw1004")) || userId.equals("manager")) {
			// login success
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("userPw", userPw);
			
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		} else {
			// login failed
			RequestDispatcher view = request.getRequestDispatcher("loginFail.jsp");
			view.forward(request, response);
		}		
	}
}
