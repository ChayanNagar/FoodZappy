<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
        

<script type="text/javascript">

function check(i) 
{
	 var q=document.getElementById('q'+i).value;
	  var up=document.getElementById('p'+i).value;
	  var cid=document.getElementById('cid'+i).value;
	 document.getElementById('total'+i).value=q*up;
	 
	  var xhttp = new XMLHttpRequest();
	  //
	 // var quantity=document.getElementById('q').value;
	  xhttp.open("POST", "UpdateViewCart?cid="+cid+"&q="+q, true);
	  xhttp.send();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     document.getElementById("gtot").innerHTML = this.responseText;
	    
	    	   }
	  };
	  
	}
</script>

</head>
<body>
 <%@page import="java.util.ArrayList,beans.JoinCart_Bean" %>
<%
 	  String uid=(String)session.getAttribute("uid");
 	 if(uid==null) 
 	  {%>
 <%@include file="Headercust1.jsp" %>
 <%} %>
 <% if(uid!=null) 
 	  {%>
 <%@include file="HeaderCust.jsp" %>
 <%} %>
 <div style="padding-top: 70px;"></div>
 ${msg}
 
 <div class="container">
   
 <table class="table table-hover" style="
    margin-top: 65px;">
 <tr><th>Pimage</th><th>Pname</th><th>Price</th><th>Quantity</th><th>Total</th></tr>
 <% 
 ArrayList<JoinCart_Bean> list=(ArrayList<JoinCart_Bean>)request.getAttribute("LIST");
 
 %>
 <%
 int i=0;
   for(JoinCart_Bean ee:list)
   {
	  %>
	  <%
 int price=Integer.parseInt(ee.getPrice());
 
	  
 %>
 
   	 <tr>
   <input type="hidden"   value="<%=ee.getCid()%>" readonly  name="cid" id="cid<%=i %>" />
   	<td> <img src="imgupload/<%=ee.getImage()%>" height="100"width="165" /> </td>
   	<td> <%=ee.getPname()%> </td>
   	<td> <input type="text"   value="<%=ee.getPrice()%>" readonly name="price" id="p<%=i%>"/>
   	 </td>
   	<td > 
     <input type="text" value="<%=ee.getQuantity()%>" name="qunatity" id="q<%=i %>" onKeyUp="check(<%=i%>);"/> 
    </td>
	<td> <input type="text" value="<%=price*ee.getQuantity()%>" readonly name="t" id="total<%=i%>"> </td>
	<td> <a href="CartDelete?cartid=<%=ee.getCid()%>" class="glyphicon glyphicon-remove-sign"  onClick="return confirm('Do you really want to delete this record?')"></a> </td>
	
	 <tr/>
	 <%i++;
	 }
  %>
 </table></div>
 <%ArrayList<JoinCart_Bean> listt=(ArrayList<JoinCart_Bean>)request.getAttribute("LISTT"); %>
 <% 
 for(JoinCart_Bean ee:listt)
 {
	 
	  %>
	<div class="col-lg-11 col-sm-11 col-md-11">
	 <div class="cart_totals text-right">
	  <h1>Cart Total</h1>
	  <div class="order-total">
	  <span><strong><h3>Grand Total:</h3></strong></span>
	 <strong><h3> <div id="gtot"><%=ee.getTotal() %></div></h3></strong>
    </div>
    </div>
    </div>
   
 <%
	 }
  %>
  <div class="container">
	<div class="col-sm-6">
<form action="CheckOut" method="post">
<div class="form-group">
   <%if(uid!=null) {%>
   <label>Delivery Address:</label>
   <textarea name="daddress" class="form-control" required ></textarea>
   <%} %>
   
  </div>
  <button type="submit" class="btn btn-primary">Check Out</button>
</form>
</div>
</div>
</body>
</html>