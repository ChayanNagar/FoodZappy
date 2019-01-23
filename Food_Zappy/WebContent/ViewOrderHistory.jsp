<%@page import="java.util.ArrayList,beans.OrderBean" %>
 <%@include file="Header.jsp" %>
 
 	  <%
 	  String uid=(String)session.getAttribute("uid");
 	  
 	 if(uid==null)
  	   response.sendRedirect("index.jsp");
	   %>
	<center><font color=red><h1>Welcome,<%=uid%></h1></font><hr/>
	</center>
	${msg}
	
 <div class="container">
   
 <table class="table table-bordered">
 <tr><th>Oid</th><th>Pid</th><th>Quantity</th><th>Price</th><th>Emailid</th><th>Address</th><th>Status</th><th>Date-Time</th></tr>
 <% 
 ArrayList<OrderBean> list=(ArrayList<OrderBean>)request.getAttribute("LIST");
 
 %>
 
 <%
   for(OrderBean ee:list)
   {
	  %>
   	 <tr>
   	<td> <%=ee.getOid()%> </td>
   	<td> <%=ee.getPid()%> </td>
	<td> <%=ee.getQuantity()%> </td>
	 <td><%=ee.getPrice()%> </td>
	 <td><%=ee.getUser()%> </td>
	 <td><%=ee.getAddress()%></td>
	 <td>
	 <% if(ee.getStatus()==1){
	 out.println("DISPATCH");}
	 else
	 {
		 out.println("NOT AVAILABLE");
	 }
	 %> </td>
	  <td><%=ee.getDate()%> </td>
	 <tr/>
	 <%
	 }
  %>
  
  </table></div>
  
  
