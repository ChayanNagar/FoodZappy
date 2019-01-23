<%@page import="java.util.ArrayList,beans.ProductBean" %>
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
 <tr><th>Pid</th><th>Category</th><th>Pname</th><th>Price</th><th>Description</th><th>Image</th></tr>
 <% 
 ArrayList<ProductBean> list=(ArrayList<ProductBean>)request.getAttribute("LIST");
 
 %>
 
 <%
   for(ProductBean ee:list)
   {
	  %>
   	 <tr>
   	<td> <%=ee.getPid()%> </td>
   	<td> <%=ee.getCategory()%> </td>
	<td> <%=ee.getProductname()%> </td>
	 <td><%=ee.getProductprice()%> </td>
	 <td><%=ee.getDescription()%> </td>
	 <td><%=ee.getFilename()%><img src="imgupload/<%=ee.getFilename()%>" height="100"width="100" /></td>
	 
 <td> <a href="ProductUpdate?productid=<%=ee.getPid()%>" class="glyphicon glyphicon-edit"  onClick="return confirm('Do you really want to Update this record?')"></a> </td>
	
<td> <a href="ProductDelete?productid=<%=ee.getPid()%>" class="glyphicon glyphicon-remove-sign"  onClick="return confirm('Do you really want to delete this record?')"></a> </td>
	 
	 <tr/>
	 <%
	 }
  %>
  </table></div>
  
  
