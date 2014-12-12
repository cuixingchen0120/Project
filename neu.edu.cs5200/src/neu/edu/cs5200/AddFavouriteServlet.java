package neu.edu.cs5200;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddFavouriteServlet
 */
@WebServlet("/AddFavouriteServlet")
public class AddFavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO udao = new UserDAO();
		User u1 = udao.findUserbyUsername(Global.username);
		CardDAO cdao = new CardDAO();
		
		
		int userid = u1.getId();
		udao.addFavouriteCard(userid, Global.cardid);
		PrintWriter out=response.getWriter(); 
		
		  out.print("<script language='javascript'>alert('The card has been added to the favorite List !');window.location.href='/neu.edu.cs5200/SearchByNamenDAO.jsp';</script>");
	}

}
