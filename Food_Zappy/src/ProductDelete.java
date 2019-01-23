

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import dao.MyDao;
import beans.ProductBean;

/**
 * Servlet implementation class ProductDelete
 */
@WebServlet("/ProductDelete")
public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyDao m=new MyDao();
	      int pid =Integer.parseInt(request.getParameter("productid"));
         int x=m.deleteEmp(pid);
     if(x!=0)
     {
  	      ArrayList<ProductBean> list= m.viewProduct();
  	   RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
  	   request.setAttribute("LIST", list);
		    request.setAttribute("msg","Product: "+pid+ " deleted Successfully..");
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
