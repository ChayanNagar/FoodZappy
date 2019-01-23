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
 <div style="padding-top: 90px;"></div>
 ${msg}
 
 </body>
</html>