package Customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MyDao;

/**
 * Servlet implementation class CustomerCheck
 */
@WebServlet("/CustomerCheck")
public class CustomerCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerCheck() {
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
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String IP=request.getRemoteAddr();
		MyDao m=new MyDao();
		   int x=m.customerLogin(email, pwd);
		  int y=m.cartUpdate(email,IP);
		   if(x==1 || y==1 )
			{
			   //Session code here
				HttpSession session=request.getSession();
				session.setAttribute("uid",email);
				response.sendRedirect("viewgridcustomer");
				
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("CustomerLogin.jsp");
				request.setAttribute("msg","<h3>Login Fail Try Again..</h3>");
						
				rd.forward(request,response);
				  //response.sendRedirect("index.jsp");
			}
		
	
		

	}

}
