package neu.edu.cs5200;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Snum = request.getParameter("name");
		int num = Integer.parseInt(Snum);
		UserDAO udao = new UserDAO();
		CardDAO cdao = new CardDAO();
		Card c1 = cdao.findCardById(Global.cardid);
		ShoppingCartDAO dao = new ShoppingCartDAO();
		User u1 = udao.findUserbyUsername(Global.username);
		
		dao.orderCard(u1, c1, num);
		
		PrintWriter out=response.getWriter(); 
		
		  out.print("<script language='javascript'>alert('The card has been added to the favorite List !');window.location.href='/neu.edu.cs5200/SearchByNamenDAO.jsp';</script>");
	}

}
