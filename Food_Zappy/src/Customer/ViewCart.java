package Customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CartBean;
import beans.JoinCart_Bean;
import beans.ProductBean;
import dao.MyDao;

/**
 * Servlet implementation class ViewCart
 */
@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		MyDao m=new MyDao();
	     HttpSession session=request.getSession();
	     String user=(String)session.getAttribute("uid");
	     
	     PrintWriter out = response.getWriter();
	     out.println(user);
		if(user==null)
		{
			user=request.getRemoteAddr();
			ArrayList<JoinCart_Bean> list= m.viewCart(user);
			
			ArrayList<JoinCart_Bean> listt= m.cartTotal(user);
			int count = m.cartCount(user); 
			request.setAttribute("count", count);
			if(list.isEmpty()==true)
			{
			 response.sendRedirect("index.jsp");				
		                 
			}
			     else {
			      RequestDispatcher rd=request.getRequestDispatcher("Viewcart.jsp");
			     request.setAttribute("LIST", list);
			     request.setAttribute("LISTT", listt);
			      rd.forward(request, response);
			      }
		}
			     	 
		else
		{
             ArrayList<JoinCart_Bean> list= m.viewCart(user);
			
			ArrayList<JoinCart_Bean> listt= m.cartTotal(user);
			int count = m.cartCount(user); 
			request.setAttribute("count", count);
			if(list.isEmpty()==true)
			{
			 response.sendRedirect("viewgridcustomer");				
		                 
			}
			     else {
			      RequestDispatcher rd=request.getRequestDispatcher("Viewcart.jsp");
			     request.setAttribute("LIST", list);
			     request.setAttribute("LISTT", listt);
			      rd.forward(request, response);}
			      
			     	      }

		}
	


		
	

		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
