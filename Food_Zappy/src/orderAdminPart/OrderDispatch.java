package orderAdminPart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import beans.OrderBean;
//import beans.ProductBean;
import dao.MyDao;

/**
 * Servlet implementation class OrderDispatch
 */
@WebServlet("/OrderDispatch")
public class OrderDispatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDispatch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyDao m=new MyDao();
	      int oid =Integer.parseInt(request.getParameter("orderid"));
	      int action =Integer.parseInt(request.getParameter("action"));
			String emailid=request.getParameter("email");
            //System.out.println(emailid);
	     if(action==1) 
	     {
	      int x=m.productDispatch(oid);
   if(x!=0)
   {
	      ArrayList<OrderBean> list= m.viewPendingOrder();
	     
	      RequestDispatcher rd=request.getRequestDispatcher("Viewpendingorder.jsp");
	   request.setAttribute("LIST", list);
		    //request.setAttribute("msg","Product: "+pid+ " deleted Successfully..");
	   rd.forward(request, response);
	   String to=emailid;
		 String sub="Thanks for Zappy Food Online Food Shopping";
		 String msg="Your ORDER DISPATCHED SUCCESSFULLY and Your oid is:"+oid;
		 sendMail(to,sub,msg);
//	     out.println("Sent message successfully....");

   }
	     }
	     if(action==2) {
	    	     int x=m.productNotAvailable(oid);
	    	   if(x!=0)
	    	   {
	    		      ArrayList<OrderBean> list= m.viewPendingOrder();
	    		      
		    			
	    		      RequestDispatcher rd=request.getRequestDispatcher("Viewpendingorder.jsp");
	    		   request.setAttribute("LIST", list);
	    			    //request.setAttribute("msg","Product: "+pid+ " deleted Successfully..");
	    		   rd.forward(request, response);
	    		   String to=emailid;
	    			 String sub="Thanks for Zappy Food Online Shopping";
	    			 String msg="Your ORDER IS OUT OF STOCK for oid :"+oid;
	    			 sendMail(to,sub,msg);
	    	   }

	     }
	  
	
	}
	   public void sendMail(String to,String sub,String msg)
		 	{
		 	
		 		String from = "project.chayan@gmail.com";
		 	    final String username =  "project.chayan@gmail.com";//change accordingly
		 	    final String password = "Chayan1234";//change accordingly

		 	    // Assuming you are sending email through relay.jangosmtp.net
		 	    String host = "smtp.gmail.com";

		 	    Properties props = new Properties();
		 	    props.put("mail.smtp.auth", "true");
		 	    props.put("mail.smtp.starttls.enable", "true");
		 	    props.put("mail.smtp.host", host);
		 	    props.put("mail.smtp.port", "587");

		 	    // Get the Session object.
		 	    Session session = Session.getInstance(props,
		 	    new javax.mail.Authenticator() {
		 	       protected PasswordAuthentication getPasswordAuthentication() {
		 	          return new PasswordAuthentication(username, password);
		 	       }
		 	    });

		 	    try {
		 	       // Create a default MimeMessage object.
		 	       Message message = new MimeMessage(session);

		 	       // Set From: header field of the header.
		 	       message.setFrom(new InternetAddress(from));

		 	       // Set To: header field of the header.
		 	       message.setRecipients(Message.RecipientType.TO,
		 	       InternetAddress.parse(to));

		 	       // Set Subject: header field
		 	       message.setSubject(sub);

		 	       // Now set the actual message
		 	       message.setText(msg);

		 	       // Send message
		 	       
		 	       Transport.send(message);
		 	       } catch (Exception e) {
		 	  	  e.printStackTrace();
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
