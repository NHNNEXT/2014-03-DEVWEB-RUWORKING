package register;

import java.io.IOException;

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
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("pw1");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		User user = new User(id, password, email, gender);
		UserDAO userDAO = new UserDAO();
		
		try {
			userDAO.addUser(user);
			ServletContext sc = this.getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("module/register/registerGreeting.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("module/register/registerFail.jsp");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null) {
			response.sendRedirect("/index.jsp");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("module/register/register.jsp");
			view.forward(request, response);
		}
	}
}


