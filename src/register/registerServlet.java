package register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register.ruw")
public class registerServlet extends HttpServlet{
	
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
			RequestDispatcher rd = sc.getRequestDispatcher("/greeting/greeting.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("memberRegister/registerFailPage.jsp");
		}
			
	}

	//doget으로 올때 어디로 갈지 리다이렉트해주어야
}



