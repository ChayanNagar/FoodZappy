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
 <tr><th>Oid</th><th>Pid</th><th>Quantity</th><th>Price</th><th>Emailid</th><th>Address</th><th>Status</th><th>Date-Time</th><th>Dispatch</th><th>Not Available</th></tr>
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
	 <td><%if(ee.getStatus()==0) out.println("PENDING");%></td>
	 <td><%=ee.getDate()%> </td>
 <td> <a href="OrderDispatch?orderid=<%=ee.getOid()%>&action=1&email=<%=ee.getUser()%>" class="glyphicon glyphicon-edit" onClick="return confirm('Do you really want to Dispatch the order?')"></a> </td>
	
<td> <a href="OrderDispatch?orderid=<%=ee.getOid()%>&action=2&email=<%=ee.getUser()%>" class="glyphicon glyphicon-remove-sign"></a> </td>
	 
	 <tr/>
	 <%
	 }
  %>
  </table></div>
  
  
