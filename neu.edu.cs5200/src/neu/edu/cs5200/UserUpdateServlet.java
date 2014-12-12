package neu.edu.cs5200;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = Global.username;
		UserDAO udao = new UserDAO();
		User u1 = udao.findUserbyUsername(username);
		String username1 = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		User u2 = udao.UpdateUser(u1, username1, password, firstname, lastname, email);
		
		Global.username = u2.getUsername();
		Global.password = u2.getPassword();
		Global.firstname = u2.getFirstname();
		Global.lastname = u2.getLastname();
		Global.email = u2.getEmail();
		PrintWriter out=response.getWriter(); 
		
		out.print("<script language='javascript'>alert('Your information has been updated!');window.location.href='/neu.edu.cs5200/update.jsp';</script>");
		
	}

}
