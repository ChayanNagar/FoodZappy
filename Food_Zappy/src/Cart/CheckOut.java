package Cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CartBean;

import dao.MyDao;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
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
		String address=request.getParameter("daddress");
		HttpSession session=request.getSession();
        String user=(String)session.getAttribute("uid");
        MyDao m=new MyDao();
        if(user==null)
        	
        {
        	response.sendRedirect("CustomerLogin.jsp");
        }
        else {
       // int z=m.gTotal(user);
        ArrayList<CartBean> list= m.checkOut(user,address);
          	                       //CartBean c=new CartBean();
                 
                                //    int y=m.insertOrder1(ee, address,z);
                //  if(y==1)
                 // {
                //	  System.out.println("Inserted");
                	 // int delete=m.deleteCartTable();
                	 // if(delete==1)
                	  //{
                		 // System.out.println("Deleted");
                	 // }
                	 
               //   }
          
                  RequestDispatcher rd=request.getRequestDispatcher("ViewCheckOut.jsp");
           	     request.setAttribute("msg", "<h3>Order placed successfully...Product will be send as soon as possible</h3>");
           	 rd.forward(request, response);
        }

                                      
	}

}
