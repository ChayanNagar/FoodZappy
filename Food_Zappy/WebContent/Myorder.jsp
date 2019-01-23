<%@page import="java.util.ArrayList,beans.OrderBean" %>
 <%@include file="HeaderCust.jsp" %>
 
 	  <%
 	  String uid=(String)session.getAttribute("uid");
 	  
 	 if(uid==null)
  	   response.sendRedirect("index.jsp");
 	 
	   %>
	<center style="padding-top: 102px;"><font color=red><h1>Welcome,<%=uid%></h1></font><hr/>
	</center>
	${msg}
	
 <div class="container">
   
 <table class="table table-bordered">
 <tr><th>S.No.</th><th>Oid</th><th>Pid</th><th>Quantity</th><th>Price</th><th>Total</th><th>Emailid</th><th>Address</th><th>Status</th><th>Date-Time</th></tr>
 <% 
 ArrayList<OrderBean> list=(ArrayList<OrderBean>)request.getAttribute("LIST");
 
 %>
 
 <%
int x=1;
   for(OrderBean ee:list)
	      {
	        
	 
	   %>
	  	  
   	 <tr>
   	<td> <%=x%> </td>
   	<td> <%=ee.getOid()%> </td>
   	<td> <%=ee.getPid()%> </td>
	<td> <%=ee.getQuantity()%> </td>
	 <td><%=ee.getPrice()%> </td>
	 <td> <%=ee.getQuantity()*ee.getPrice()%> </td>
	
	 <td><%=ee.getUser()%> </td>
	 <td><%=ee.getAddress()%></td>
	 <td><%if(ee.getStatus()==0) out.println("PROCESSING");%>
	 <%if(ee.getStatus()==1) out.println("Completed");%>
	 <%if(ee.getStatus()==2) out.println("Out Of Stock");%>
	 </td>
	 <td><%=ee.getDate()%> </td>
  <tr/>
	 <%
	 x++;}
  %>
  </table></div>
  
  
