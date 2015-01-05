package service.register;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Register.ruw")
public class RegisterServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("pwEncryption");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		RegisterModel model = new RegisterModel();
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = null;
		try {
			if(model.addUser(id, password, email, gender)) {
				rd = sc.getRequestDispatcher("/module/register/registerSuccess.jsp");			
			} else {
				rd = request.getRequestDispatcher("/module/register/registerFail.jsp");			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rd.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null) {
			response.sendRedirect("/index.jsp");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/module/register/register.jsp");
			view.forward(request, response);
		}
	}
}



