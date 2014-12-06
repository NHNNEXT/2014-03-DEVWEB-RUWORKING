package login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import register.UserDAO;

@WebServlet("/Login.ruw")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null) {
			response.sendRedirect("/");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("module/login/loginFail.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		UserDAO userDAO = new UserDAO("dev");
		
		try {
			if (userDAO.checkUser(userId, userPw)) {
				// login success
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				session.setAttribute("userPw", userPw);
				
				response.sendRedirect("/");
			} else {
				// login failed
				RequestDispatcher view = request.getRequestDispatcher("module/login/loginFail.jsp");
				view.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher view = request.getRequestDispatcher("module/login/loginFail.jsp");
			view.forward(request, response);
		}
	}
}
