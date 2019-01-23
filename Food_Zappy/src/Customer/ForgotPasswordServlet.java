package Customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.OrderBean;
import dao.MyDao;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
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
		MyDao m=new MyDao();
	     		String emailid=request.getParameter("email");
	     		//String password=m.sendPassword(emailid);
	     		HttpSession session=request.getSession();
	     		session.setAttribute("emailid",emailid);
	     		//String otp=m.insertOTP(emailid);
	     		//String otp1=m.sendOTP(emailid);
	     		String substr=null;   		

	     		//System.out.println(emailid+""+password);
	     		if(emailid!=null)
	     	   {
	     			 long l=System.currentTimeMillis();
			 		   String str=l+"";
			 		   substr=str.substring(7,11);
			 		  out.print(substr);
			 		  int y=m.insertOtp(emailid,substr);
			 		 //response.sendRedirect("otpverification.jsp");
	     			/*int x=m.checkEmailForForgotPassword(emailid);
		   		 if(x==1)
			 		{
			   			
			 		}
			 	 else  
			 		   {
			 				//RequestDispatcher rd=request.getRequestDispatcher("ForgotPassword.jsp");
			 				//.request.setAttribute("msg1","<h3>Emailid doesn't exist..</h3>");
			 						
			 				rd.forward(request,response);
			 				  }*/
		   		 RequestDispatcher rd=request.getRequestDispatcher("otpverification.jsp");
	     		  request.setAttribute("msg","<h3>Otp send to your emailid</h3>");
	     			    //request.setAttribute("msg","Product: "+pid+ " deleted Successfully..");
	     		  
	     		   String to=emailid;
	     			 String sub="Your Otp ";
	     			 String msg="Your password for Zappy food shoppong is:"+substr;
	     			 sendMail(to,sub,msg);
	     			 rd.forward(request, response);
//	     		     out.println("Sent message successfully....");

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

}
