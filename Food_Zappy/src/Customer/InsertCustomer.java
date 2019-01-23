package Customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CustomerBean;

import dao.MyDao;

/**
 * Servlet implementation class InsertCustomer
 */
@WebServlet("/InsertCustomer")
public class InsertCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCustomer() {
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
		
		String cname=request.getParameter("cname");
		String emailid=request.getParameter("email");
		String password=request.getParameter("password");
		String mobileno=request.getParameter("mnumber");
		String caddress=request.getParameter("address");
		
	CustomerBean e=new CustomerBean();
		
		e.setCname(cname);
		e.setEmailid(emailid);
		e.setPassword(password);
		e.setMobileno(mobileno);
		e.setCaddress(caddress);
		
		
			
	    MyDao m=new MyDao();
		//int x= m.insertCustomer(cname,caddress,mobileno,emailid,accno,password,balance);
		int x=m.insertCustomer(e);
		
		if(x!=0)
	    {
	    javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("Signup.jsp");
	    request.setAttribute("msg","<h1>Data Inserted Successfully...</h1>");
	    rd.forward(request, response);
	    
	    }
	    else
	    	out.println("<h1>Data Not Inserted</h1>");

	}

}
