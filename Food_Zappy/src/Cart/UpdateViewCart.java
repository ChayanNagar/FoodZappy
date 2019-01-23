package Cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MyDao;

/**
 * Servlet implementation class UpdateViewCart
 */
@WebServlet("/UpdateViewCart")
public class UpdateViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateViewCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     PrintWriter out=response.getWriter();
     String q=request.getParameter("q");
	 String cid=request.getParameter("cid");	
	 MyDao m=new MyDao();
	 int x=m.totalUpdateCart(q, cid);
	 if(x==1)
	 {
		out.println("Updated"); 
	 }
	 HttpSession session=request.getSession();

		String user=(String)session.getAttribute("uid");
		  
		if(user==null)
		{
			user=request.getRemoteAddr();
		}
		int y=m.gTotal(user);
		
	//	System.out.println(y);
         out.println(y);
	}

}
