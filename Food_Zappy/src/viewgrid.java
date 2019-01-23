

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ProductBean;
import dao.MyDao;

/**
 * Servlet implementation class viewgrid
 */
@WebServlet("/viewgrid")
public class viewgrid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewgrid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		MyDao m=new MyDao();
		
		HttpSession session=request.getSession();

		String user=(String)session.getAttribute("uid");
		
		if(user==null)
		{
			user=request.getRemoteAddr();
		}
		int count = m.cartCount(user); 
		request.setAttribute("count", count);
	      
		
		ArrayList<ProductBean> list1= m.viewProductreadytodrink();
	      
	      ArrayList<ProductBean> list2= m.viewProductreadytoeat();
	      
	      ArrayList<ProductBean> list3= m.viewProductreadytocook();
	      
	      RequestDispatcher rd=request.getRequestDispatcher("index1.jsp");
	      request.setAttribute("LIST1", list1);
	      request.setAttribute("LIST2", list2);
	      request.setAttribute("LIST3", list3);
	      
	      rd.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
