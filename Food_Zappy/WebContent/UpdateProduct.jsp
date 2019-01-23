<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <%@include file="Header.jsp" %>
   <style>
   h3{
   color:purple;
   font-size:25px;
   font-family:comic sans ms;
   }
  button
   {
  background-color:orange;
   }
  label
  {
  font-size:18px;
  }
   .update
   {
   width:500px;
   float:left;
   margin-left:100px;
   margin-top:50px;
   
   }
   .updateimg
   {
   float:left;
   width:500px;
   margin-left:100px;
   margin-top:50px;
   
   }
   </style>
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


	<div class="update">
	<div class="container">
	<div class="col-sm-3">
 
 <%@page import="beans.ProductBean" %>
 <%
 ProductBean e=(ProductBean)request.getAttribute("product");
 %>
 
  <h3 >For Data Updation:</h3>
    
    <form action="./Update" method="post" >
  
  <div class="form-group">
    <label for="pwd">Pid:</label>
    <input type="text" readonly  value="<%=e.getPid()%>"  class="form-control" id="pwd" name="pid" />
  </div>
 
 <div class="form-group">
    <label for="category">Category:</label>
    <select name="Category">
  <option value="Ready to drink">Ready to Drink</option>
  <option value="Ready to eat">Ready to Eat</option>
  <option value="Ready to cook">Ready to Cook</option>
  </select>
  
  </div>
  <div class="form-group">
    <label for="pwd">PName:</label>
    <input type="text"  value="<%=e.getProductname()%>"  class="form-control" id="pwd" name="name" />
  </div>
  <div class="form-group">
    <label for="email">Price:</label>
    <input type="text" class="form-control"  value="<%=e.getProductprice()%>"  name="price" id="email">
  </div>
 
  <div class="form-group">
    <label for="email">Description:</label>
    <textarea name="desc" class="form-control" > <%=e.getDescription()%> </textarea>
  </div>
  
   <button type="submit" class="btn btn-warning" onClick="return confirm('Do you really want to Update this record?')">Update</button>
   </form>
   </div>
   
   

  <div class="updateimg">
	
	<div class="col-sm-6">
  <h3>For Image Updation:</h3>
 <form action="./UpdateImage" method="post"  enctype="multipart/form-data">
 
 <div class="form-group">
    <label for="pwd">Pid:</label>
    <input type="text" readonly value="<%=e.getPid()%>"  class="form-control" id="pwd" name="pid" />
  </div>
  
    <div class="form-group">
    <label for="image">Image:</label><br></br>
   <img src="imgupload/<%=e.getFilename()%>" class="img-rounded"  height="100" width="100"/>
   <input type="file" class="form-control" id="img" name="file" />
   
  </div>
  
  <button type="submit" class="btn btn-warning" onClick="return confirm('Do you really want to Update this record?')">Update</button>
 
 
 </form>
</div>
</div>
</div>
</body>
</html>
