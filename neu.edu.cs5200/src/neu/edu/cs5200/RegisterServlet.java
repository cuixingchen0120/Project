package neu.edu.cs5200;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name="Register" , urlPatterns = {"/Register"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String email = request.getParameter("email");
		if(username==""){
			PrintWriter out=response.getWriter(); 
			
			out.print("<script language='javascript'>alert('Please enter the username');window.location.href='/neu.edu.cs5200/Register.jsp';</script>");
		}
		else if(password==""){
			PrintWriter out=response.getWriter(); 
			
			out.print("<script language='javascript'>alert('Please enter the password');window.location.href='/neu.edu.cs5200/Register.jsp';</script>");
		}
		else if(!password.equals(repassword)){
			PrintWriter out=response.getWriter(); 
			
			out.print("<script language='javascript'>alert(' The repassword must be equal to password');window.location.href='/neu.edu.cs5200/Register.jsp';</script>");
		}
		else if(email==""){
			PrintWriter out=response.getWriter(); 
			
			out.print("<script language='javascript'>alert('Please enter the email');window.location.href='/neu.edu.cs5200/Register.jsp';</script>");
		}
		else if(username!=""&& password!="" && password.equals(repassword)&&  email!=""){
			User user = new User();
			UserDAO dao = new UserDAO();
			if(dao.findUserbyUsername(username)==null){
			user = new User(new Date(),email,firstname,lastname,password,username);
			dao.createUser(user);
			response.sendRedirect("/neu.edu.cs5200/Login.jsp");
			}else{
				PrintWriter out=response.getWriter(); 
				
				out.print("<script language='javascript'>alert('Please try another username');window.location.href='/neu.edu.cs5200/Register.jsp';</script>");
			}
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/Index.jsp");
			//dispatcher.forward(request, response);
			 
		}else{
			PrintWriter out=response.getWriter(); 
			
		out.print("<script language='javascript'>alert('Please enter the right information!');window.location.href='/neu.edu.cs5200/Register.jsp';</script>");
		}
	}

}
