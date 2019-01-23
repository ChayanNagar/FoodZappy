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
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out =response.getWriter();
		
		String quantity=request.getParameter("qty");
			String pid=request.getParameter("pid");
			HttpSession session=request.getSession();

			String user=(String)session.getAttribute("uid");
			  MyDao m=new MyDao();
			if(user==null)
			{
				user=request.getRemoteAddr();
				CartBean e=new CartBean();
				  e.setPid(Integer.parseInt(pid));
				  e.setQuantity(Integer.parseInt(quantity));
				  e.setUser(user);
				   int y=m.quantityCheck(pid, user);
					if(y==1)
					{
												
						e.setQuantity(Integer.parseInt(quantity));
				         e.setPid(Integer.parseInt(pid));
				         e.setUser(user);
				         System.out.println("true");
				        
				    	
				    	
			       int x=m.updateQuantityViaCart(e , quantity);
			  
//				    	
//				      request.setAttribute("LIST3", list3);
				    	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				    	request.setAttribute("msg","<h3>Product added to cart..</h3>");	
				    	rd.forward(request, response);	
				    	//out.println("<h2>Added to cart...</h2>");
			    	
					}
					
            if(y==0) {
				  MyDao d=new MyDao();
				  int x=d.insertCart(e);
				  
				  if(x!=0)
				    {
					  int count = m.cartCount(user); 
					request.setAttribute("count", count);

					
					  ArrayList<ProductBean> list1= m.viewProductreadytodrink();

					  ArrayList<ProductBean> list2= m.viewProductreadytoeat();

					  ArrayList<ProductBean> list3= m.viewProductreadytocook();

					  
					  request.setAttribute("LIST1", list1);
					  request.setAttribute("LIST2", list2);
					  request.setAttribute("LIST3", list3);

					  
					  RequestDispatcher rd=request.getRequestDispatcher("index1.jsp");
					  
				    request.setAttribute("msg","<h3 style=margin-top:18px;>Product Added To your Cart Successfully...</h3>");
				    rd.forward(request, response);
				    
				    
				    }
			}
			}
			else if(user!=null)
	  {
				CartBean c=new CartBean();
		  c.setPid(Integer.parseInt(pid));
		  c.setQuantity(Integer.parseInt(quantity));
		  c.setUser(user);
		  int z=m.quantityCheck(pid, user);
			if(z==1)
			{
										
			c.setQuantity(Integer.parseInt(quantity));
		         c.setPid(Integer.parseInt(pid));
		         c.setUser(user);
		       //  System.out.println("true");
		        
		    	
		    	
	       int x=m.updateQuantityViaCart(c , quantity);
	  
//		    	
//		      request.setAttribute("LIST3", list3);
		    	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		    	request.setAttribute("msg","<h3>Product added to cart..</h3>");	
		    	rd.forward(request, response);	
		    	//out.println("<h2>Added to cart...</h2>");
	    	
			}
		if(z==0) {
		  MyDao o=new MyDao();
		  int x=o.insertCart(c);
		  
		  if(x!=0)
		    {
			  int count = m.cartCount(user); 
				request.setAttribute("count", count);

			  ArrayList<ProductBean> list1= m.viewProductreadytodrink();

			  ArrayList<ProductBean> list2= m.viewProductreadytoeat();

			  ArrayList<ProductBean> list3= m.viewProductreadytocook();

			 
			  request.setAttribute("LIST1", list1);
			  request.setAttribute("LIST2", list2);
			  request.setAttribute("LIST3", list3);

			  RequestDispatcher rd=request.getRequestDispatcher("CustomerHome.jsp");
		    
		    request.setAttribute("msg","<h3>Product Added to your cart Successfully...</h3>");
		    rd.forward(request, response);
		    
		    
		    }
		  
	  }
	  }
	   // else
	    	{
	    	out.println("<h3>Product Not Added to your cart</h3>");
	    	}



	  
		  
	
	}
			}
	
	

