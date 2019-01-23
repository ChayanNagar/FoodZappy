

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import beans.ProductBean;
import dao.MyDao;

/**
 * Servlet implementation class UploadProduct
 */
@WebServlet("/UploadProduct")
public class UploadProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String filePath;
	   private int maxFileSize = 1000 * 4096;
	   private int maxMemSize = 1000 * 4096;
	   private File file ;
    	
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/html");
			  PrintWriter out = response.getWriter();
			  boolean isMultipart = ServletFileUpload.isMultipartContent(request);//true
	      
			  if( !isMultipart ){
	             return;
	      }
			  
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	       // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );

	      try{

	      // Parse the request to get file items.
	      List fileItems = upload.parseRequest(request);  //formfield-2    Non FormField-1

	      // Process the uploaded file items
	      Iterator i = fileItems.iterator();
	  
	      String category=null;
	      String productname=null;
	      String productprice=null;
	      String description=null;
	      String filename=null;
	      
	      while ( i.hasNext())
	      {

	         FileItem fi = (FileItem)i.next();
	         if ( fi.isFormField () )
	         {
	            // Get the uploaded file parameters
	           String  fieldName = fi.getFieldName();
	           if(fieldName.equals("Category"))
	             {
	        	  category=fi.getString();
	              System.out.println(category);
	             }
	           if(fieldName.equals("pname"))
	           {
	        	   productname=fi.getString();
	            System.out.println(productname);
	           }
	           
	           if(fieldName.equals("price"))
	           {
	        	   productprice=fi.getString();
	            System.out.println(productprice);
	           }
	           if(fieldName.equals("description" ))
	           {
	        	   description=fi.getString();
	            System.out.println(description);
	           }

	          
	         }
	         else
	          {    
	        	 String fieldName = fi.getFieldName();

	            if(fieldName.equals("file"))
	            {
	             ServletConfig sc=getServletConfig();
	            // String field=fi.getString();
	            // String contentType = fi.getContentType();
	             filename=fi.getName();
	              //boolean isInMemory = fi.isInMemory();
	              //long sizeInBytes = fi.getSize();

	              //create folder
	              File f = new File(sc.getServletContext().getRealPath("/")+"imgupload/") ;
	                 if(!f.exists())
	                	 f.mkdir();
	              // Write the file
	              file = new File(sc.getServletContext().getRealPath("/")+"imgupload/"+filename) ;
	               fi.write( file ) ;
	              out.println("Uploaded Filename: " +filename + "<br>");
	            System.out.println("PATH="+file.getPath());
	            }
	         }
	      }

	      ProductBean e=new ProductBean();
			e.setCategory(category);
			e.setProductname(productname);
			e.setProductprice(productprice);
			e.setDescription(description);
			e.setFilename(filename);
			
			MyDao m=new MyDao();
			int x=m.insertProduct(e);
			
			if(x!=0)
		    {
		    javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("AddProduct.jsp");
		    request.setAttribute("msg","<h1>Data Inserted Successfully...</h1>");
		    rd.forward(request, response);
		    
		    
		    }
		    else
		    	out.println("<h1>Data Not Inserted</h1>");

	      }catch(Exception ex)
	    {
	        ex.printStackTrace();
	       System.out.println(ex);
	   }

		
	


	   
	   }
}

