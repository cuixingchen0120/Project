package neu.edu.cs5200;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletToLogin
 */
@WebServlet("/Login")
public class ServletToLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Global.username = username;
	
		//user = new User(username,password);
		
		if(username==""){
			PrintWriter out=response.getWriter(); 
			
			out.print("<script language='javascript'>alert('Please enter your username');window.location.href='/neu.edu.cs5200/Login.jsp';</script>");
		}
		else if(password==""){
			PrintWriter out=response.getWriter(); 
			
			out.print("<script language='javascript'>alert('Please enter your password');window.location.href='/neu.edu.cs5200/Login.jsp';</script>");
		}
		User user = new User();
		UserDAO dao = new UserDAO();
		user =dao.findUserByUsernameAndPassword(username, password);
		if(user!=null){
			
			Global.password = user.getPassword();
			Global.firstname = user.getFirstname();
			Global.lastname = user.getLastname();
			Global.email = user.getEmail();
			
			
			response.sendRedirect("/neu.edu.cs5200/IndexAfterLogin.jsp");
		}
		else{
		
		PrintWriter out=response.getWriter(); 
		
		out.print("<script language='javascript'>alert('Please register your account');window.location.href='/neu.edu.cs5200/Login.jsp';</script>");
		}
	}
	}


