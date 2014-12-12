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
 * Servlet implementation class CommentServlet
 */
@WebServlet("/SearchByNamenDAO")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Comment = request.getParameter("comment");
		if(Comment!=""){
			CommentDAO commentdao = new CommentDAO();
			Comment comment = new Comment();
			String cardname = Global.cardname;
			String username = Global.username;
			UserDAO udao = new UserDAO();
			User u1 = udao.findUserbyUsername(username);
			comment = new Comment(cardname,Comment,new Date(),username,u1);
			commentdao.createComment(comment);
			PrintWriter out=response.getWriter(); 
			
			  out.print("<script language='javascript'>alert('Your comment has been submitted !');window.location.href='/neu.edu.cs5200/SearchByNamenDAO.jsp';</script>");
			  //RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchByName.jsp");
			  //dispatcher.forward(request, response);
		}
		else{
			PrintWriter out=response.getWriter(); 
			
			  out.print("<script language='javascript'>alert('Please enter your comment !');window.location.href='/neu.edu.cs5200/SearchByNamenDAO.jsp';</script>");
		}
	}

}
