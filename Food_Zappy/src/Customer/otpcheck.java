package Customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;

/**
 * Servlet implementation class otpcheck
 */
@WebServlet("/otpcheck")
public class otpcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public otpcheck() {
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
		String otp=request.getParameter("otp");
		MyDao m=new MyDao();
		int x=m.checkOtp(otp);
		if(x==1)
		{
			response.sendRedirect("Passwordchange.jsp");
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("otpverification.jsp");
				request.setAttribute("msg1","<h3>Otp Incorrect..</h3>");
						
				rd.forward(request,response);
		}
		
	
	}

}
