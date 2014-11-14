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
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null) {
			response.sendRedirect("/index.jsp");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("loginFail.jsp");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		UserDAO userDAO = new UserDAO();
		
		try {
			if (userDAO.checkUser(userId, userPw)) {
				// login success
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				session.setAttribute("userPw", userPw);
				
				response.sendRedirect("/index.jsp");
			} else {
				// login failed
				RequestDispatcher view = request.getRequestDispatcher("loginFail.jsp");
				view.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher view = request.getRequestDispatcher("loginFail.jsp");
			view.forward(request, response);
		}
	}
}
