package service.login;

import java.io.IOException;
import java.sql.SQLException;

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

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") == null) {
			forwardToLoginFailPage(request, response);
			return;
		}
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("PwEncryption");
		LoginModel model = new LoginModel();

		try {
			if (model.isUserExist(userId, userPw)) {
				// login success
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				session.setAttribute("userPw", userPw);
				response.sendRedirect("/");
			} else {
				forwardToLoginFailPage(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			forwardToLoginFailPage(request, response);
		}
	}

	private void forwardToLoginFailPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String errorMessage = "RUWORKING에 등록되지 않은 회원이거나 아이디 또는 비밀번호를 잘못 입력하셨습니다.";
		request.setAttribute("errorMessage", errorMessage);
		RequestDispatcher view = request
				.getRequestDispatcher("module/login/loginFail.jsp");
		view.forward(request, response);
	}
}
