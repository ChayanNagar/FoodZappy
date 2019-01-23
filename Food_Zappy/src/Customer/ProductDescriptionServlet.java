package Customer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductBean;
import dao.MyDao;

/**
 * Servlet implementation class ProductDescriptionServlet
 */
@WebServlet("/ProductDescriptionServlet")
public class ProductDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDescriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyDao m=new MyDao();
	      int pid =Integer.parseInt(request.getParameter("productid"));
       
  
	      ArrayList<ProductBean> list= m.productDesc(pid);
	   RequestDispatcher rd=request.getRequestDispatcher("ProductDescription.jsp");
	   request.setAttribute("LIST", list);
		    //request.setAttribute("msg","Product: "+pid+ " deleted Successfully..");
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
