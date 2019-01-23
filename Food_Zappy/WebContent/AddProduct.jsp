<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@include file="Header.jsp" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
 <script type="text/javascript">
$(document).ready(function(){
	$("#Pname").blur(function(){
	    
		var pname=$("#Pname").val();
		//alert(email);
	var	mydata="id="+pname;
		
	 $("#msg").html("<img src='images/pc.gif' height='50' width='50' ><font color=gray> Checking availability...</font>");
	 
	 $.ajax({
			url:'CheckProductName',
			data:mydata,
			type:'post',
			success:function(response){
				//alert(response);
				$("#msg").html(response);
				if(response.includes("Already Exist"))
				$("#Pname").val("");
				
			}
		 });
	});
});
</script>
 
   <body background="images/bg1.jpg">
       <% 
	  	String uid=(String)session.getAttribute("uid");
	  
       if(uid==null)
    	   response.sendRedirect("index.jsp");
       
       %>
	   
	<center><font color=red><h1>Welcome,<%=uid%></h1></font><hr/>
	
	</center>
	
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


	<div class="container">
	<div class="col-sm-3">
    <form action="./UploadProduct" method="post" enctype="multipart/form-data">
 
  <div class="form-group">
    <label for="category">Category:</label>
    <select name="Category">
  <option value="Ready to drink">Ready to Drink</option>
  <option value="Ready to eat">Ready to Eat</option>
  <option value="Ready to cook">Ready to Cook</option>
  </select>
  </div>
 
  <div class="form-group">
    <label for="pname">Product Name:</label>
     <input type="text" class="form-control" name="pname" id="Pname">
     <span id="msg"></span>
     </div>
 
  <div class="form-group">
    <label for="price">Price:</label>
    <input type="text" class="form-control" name="price" id="Price">
  </div>
 
  <div class="form-group">
    <label for="description">Description:</label>
   <textarea name="description" class="form-control" ></textarea>
  </div>
  
  <div class="form-group">
    <label for="image">Image:</label>
   <input type="file" class="form-control" id="img" name="file" />
  </div>
  
     <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</div>
	
</body>
</html>