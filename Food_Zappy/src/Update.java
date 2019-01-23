

import java.io.IOException;
//import java.io.PrintWriter;
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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		//PrintWriter out=response.getWriter();
		String ppid=request.getParameter("pid");
		String category=request.getParameter("Category");
		String pname=request.getParameter("name");
		String price=request.getParameter("price");		
		String description=request.getParameter("desc");
		
		
		ProductBean e=new ProductBean();
		e.setPid(Integer.parseInt(ppid));
		e.setCategory(category);
		e.setProductname(pname);
		e.setProductprice(price);
		e.setDescription(description);
	
		
		
		    MyDao m=new MyDao();
			int x= m.updateProduct(e);
	         if(x==1)
	         {
	        	 RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
	        	 ArrayList<ProductBean> list= m.viewProduct();
			     request.setAttribute("LIST", list);
	        	 request.setAttribute("msg", "Data Updated Successfully...");
               rd.forward(request, response);
	         }// out.println("<h1>Data Inserted</h1>");
			
			
	
	}

}
