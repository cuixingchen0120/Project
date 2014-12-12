package neu.edu.cs5200;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/CommentDeleteServlet")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentDAO commentdao = new CommentDAO();
		String username = Global.username;
		
		List<Comment> comments = commentdao.findCommentByUsername(username);
		
		for(Comment dir:comments) {
			
		System.out.println(dir.getUser());
			commentdao.deleteComment(dir.getCommentid());
		}
		PrintWriter out=response.getWriter();
		 out.print("<script language='javascript'>alert('The comment has been deleted !');window.location.href='/neu.edu.cs5200/SearchByNamenDAO.jsp';</script>");
	
	
//		 
//		 String username = Global.username;
//			String idStr = request.getParameter(name);
//			int id = Integer.parseInt(idStr);
//				commentdao.deleteComment(id);
	}

	
	
	
}
