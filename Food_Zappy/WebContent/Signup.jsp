<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Page</title>
<%@include file="Headeruser.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<style >
body
{
  

 height: 1000px; /* You must set a specified height */
   background-position: center; /* Center the image */
     background-size:  cover;
   
    background-repeat:no-repeat; /* Do not repeat the image */
 

}
h1
{
color:green;
}
label
{
font-size:20px;
font-family: comic sans ms;
color:#424bf4;
}
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 40%;
}

button:hover {
  opacity: 0.8;
}

</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#emailid").blur(function(){
	    
		var email=$("#emailid").val();
		//alert(email);
	var	mydata="id="+email;
		
	 $("#msg").html("<img src='images/pc.gif' height='50' width='50' ><font color=gray> Checking availability...</font>");
	 
	 $.ajax({
			url:'CheckEmail',
			data:mydata,
			type:'post',
			success:function(response){
				//alert(response);
				$("#msg").html(response);
				//alert(response);
		 		//alert(response.includes("Already Exist"));
				if(response.includes("Already Exist"))
				 {
					 $("#emailid").val("");
				 }	
		 		
			}
		 });
	});
});
</script>
<script src="Validation.js"></script>

</head>
<body>
<% String m=(String)request.getAttribute("msg"); 
    if(m!=null)
    {
  %>	
	<div class="alert alert-success alert-dismissible">
  <strong><%=m%></strong> 
</div>
<%
}
    %>

<h1 align="center" >Customer Registration Form</h1>

<div class="container">
	<div class="col-sm-3">
    <form name="myform" action="./InsertCustomer" method="post" >
 
    <div class="form-group">
    <label for="cname">Name:</label>
     <input type="text" onBlur="return valid();"class="form-control" name="cname" id="Cname">
   <span id="message"class="text-danger font-weight-bold">
   </span>
     
     </div>
 
  <div class="form-group">
    <label for="email">EmailId:</label>
    <input type="email" class="form-control" name="email" id="emailid">
    <span ID='msg' class="text-danger font-weight-bold">
   </span>
    
  </div>
 
  <div class="form-group">
    <label for="password">Password:</label>
   <input type="password" class="form-control" name="password" id="pwd">
   <span id="message2"class="text-danger font-weight-bold">
   </span>
   
    </div>
  
  <div class="form-group">
    <label for="mobile">MobileNo:</label>
   <input type="text" class="form-control" id="mobileno" name="mnumber" />
   <span id="message3"class="text-danger font-weight-bold">
   </span>
   
  </div>
  
  <div class="form-group">
    <label for="address">Address:</label>
   <textarea name="address" id="address" class="form-control" required></textarea>
   <span id="message4" class="text-danger font-weight-bold">
   </span>
   
  </div>
  
  
     <button type="submit" class="btn btn-primary" onClick="return valid();">Submit</button>
</form>
</div>
</div>


</body>
</html>