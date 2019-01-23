package Customer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.JoinCart_Bean;
import dao.MyDao;

/**
 * Servlet implementation class CartDelete
 */
@WebServlet("/CartDelete")
public class CartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyDao m=new MyDao();
		HttpSession session=request.getSession();

		String user=(String)session.getAttribute("uid");

		int cid =Integer.parseInt(request.getParameter("cartid"));
       int x=m.deleteCart(cid);
   if(x!=0)
   {
	      ArrayList<JoinCart_Bean> list= m.viewCart(user);
	      ArrayList<JoinCart_Bean> listt= m.cartTotal(user);
	   RequestDispatcher rd=request.getRequestDispatcher("ViewCart");
	   request.setAttribute("LIST", list);
	   request.setAttribute("LISTT", listt);
		    request.setAttribute("msg","Product: "+cid+ " deleted Successfully..");
	   rd.forward(request, response);
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
