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
 * Servlet implementation class SearchByNameServlet
 */
@WebServlet(name = "hehe", urlPatterns={"/SearchByName"})
public class SearchByNameServlet extends HttpServlet {
	

	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Global.cardUsedName = request.getParameter("name");
		//System.out.println(CardName);
		String CardName = Global.cardUsedName;
		try{
		GetACardByName get = new GetACardByName();
		Card card = new Card();
		card = get.getCardByName(CardName);
		
		
		UserDAO dao = new UserDAO();
		String username = Global.username;
		User user = new User();
		user =dao.findUserbyUsername(username);
		HistoryDAO hdao = new HistoryDAO();
		History history = new History(card.getName(),new Date(), username , user);
		hdao.createHistory(user, history);
	
		request.setAttribute("card" , card);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchByNamenDAO.jsp");
		dispatcher.forward(request, response);
		//System.out.println(user);
		
	}
		catch(Exception e){
			PrintWriter out=response.getWriter(); 
			
			  out.print("<script language='javascript'>alert('Please enter a right cardname!');window.location.href='/neu.edu.cs5200/SearchByName.jsp';</script>");
			  //out.write("<script>alert(Please);location.href='/neu.edu.cs5200/SearchByName.jsp'</script>");
		}
		
	}

}
