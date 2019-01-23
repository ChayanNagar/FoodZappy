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
import beans.ProductBean;
import dao.MyDao;

/**
 * Servlet implementation class AddCartByDescription
 */
@WebServlet("/AddCartByDescription")
public class AddCartByDescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartByDescription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String quantity = request.getParameter("qty");
		HttpSession session=request.getSession();
		String user = (String)session.getAttribute("uid");
		PrintWriter out=response.getWriter();
          CartBean e = new CartBean();
		
		
		MyDao m = new MyDao();
		
		
		 if(user==null)
		{
			 out.println(user);
			user=request.getRemoteAddr();
		}
		 
		 int count;
			count=m.cartCount(user);
			
			request.setAttribute("count", count);
		 
		 	e.setPid(Integer.parseInt(pid));
			e.setQuantity(Integer.parseInt(quantity));
			e.setUser(user);
			int x= m.insertCart(e);
			 //RequestDispatcher rd=request.getRequestDispatcher("index1.jsp");
				
			
	        
		    
	 	      ArrayList<ProductBean> list= m.productDesc(Integer.parseInt(pid));
	 	   RequestDispatcher rd=request.getRequestDispatcher("ProductDescription.jsp");
	 	   request.setAttribute("LIST", list);
			  //  request.setAttribute("msg","product: "+eid+ " deleted Successfully..");
	 	   	  
				  
				 
			      
			   if(x==1)
			   {
				   request.setAttribute("msg", "item add Successfully...");
			   }
	             else
		         {
	            	 request.setAttribute("msg", "Data Not Inserted Successfully...");
		         }
			   
			   rd.forward(request, response);   

	
	}


}
