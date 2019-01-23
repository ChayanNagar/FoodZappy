<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.ArrayList,beans.ProductBean"%>\
<%
response.addHeader("pragma","no-cache");
response.addHeader("cache-control","no-store");
response.addHeader("expire","0");
%>

<head>
<title>Zappy Food</title>

  <meta charset="utf-8">
 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <style >
 body{
  background:url(images/bg9.jpg);
  margin:0px;
  padding:0px;
   background-position: center;
  background-size:cover;
  }
 h3{
   
  font-family:comic sans ms,sans-serif;
  background:#f4cb42;
  padding:8px 20px 10px;
  font-weight:bold;
  font-size:24px;
  }
 
 table
  {
  text-align:center;
  border:none;
  font-weight: bolder; 
  width:250px;
  font-size: large;
  background-color:white;
   padding:0px;
   border-radius: 5px;
  }
  input[type="number"]
  {
  width:50px;
  text-align:center;
  font-weight: bolder; 
 
  font-size: large;
  }
  td{
  border:none;
  }
 
 
 
 <%--.set
  {
  margin:60px;
  border:2px;
  text-align:center;
  font-size:large;
  font-weight:bolder;
  }--%>
 table:hover
  {
  border:5px blue solid;
  }
</style> 
<%@include file="HeaderCust.jsp" %>


</head>
<body >

<% 
	  	String uid=(String)session.getAttribute("uid");
       if (uid==null)
       {
    	   response.sendRedirect("index.jsp");
       }
	
	   %>
	

	   
	       


	  <center style="padding-top: 70px;">
	  <font color="#0b9aed">
	   
	<h1 >Welcome,<%=uid%></h1>
	</font>
	<hr/>
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
   
   <%@page import="java.sql.*" %>
   <% 
 
 ArrayList<ProductBean> list1=(ArrayList<ProductBean>)request.getAttribute("LIST1");
 
 %>

<div class="container-fluid">
  <h3 >Ready to Drink</h3>
        
  
     
	<div class="row">
	 <%
 for(ProductBean ee:list1)
   {
	   
	  %>
    <div class="col-lg-3 col-md-4 col-xs-6" >
    
    
	 <table class="set" border="3" >
		<tr><td> <a href="ProductDescriptionServlet?productid=<%=ee.getPid()%>"><img src="imgupload/<%=ee.getFilename()%>"  height="150" width="250"/></a></td>
		</tr>
		 <tr><td><b><%=ee.getCategory()%></b></td> </tr>
		  <tr><td><b><%=ee.getProductname()%></b></td> </tr>
		       <tr><td> <b><%=ee.getProductprice()%> Rs.</b></td>  </tr>
		      
		     
		   <form action="./AddCart" method="post">
         <tr>  <td><b><label>Quantity:</label>
		 <input type="number" name="qty" value="1" min="0" ></td></tr>
		 
		 <input type="text" name="pid" value="<%=ee.getPid()%>" hidden /></td></tr>
         <tr>  <td> <button type="submit" name="addcart" class="btn btn-success btn-lg" /> Add To Cart</td></tr>
         </form>
		   
    
     
	 </table>
          
      
       </div>
    <%
	 }
	 %>	
  </div>
  
</div>


<% 
 
 ArrayList<ProductBean> list2=(ArrayList<ProductBean>)request.getAttribute("LIST2");
 
 %>



<div class="container-fluid">
  <h3>Ready to eat</h3>
        
  
     
	<div class="row">
	 <%
 for(ProductBean ee:list2)
   {
	   
	  %>
    <div class="col-lg-3 col-md-4 col-xs-6" >
    
    
	 <table class="set" border="3" >
		<tr><td> <a href="ProductDescriptionServlet?productid=<%=ee.getPid()%>"><img src="imgupload/<%=ee.getFilename()%>"  height="150" width="180"/></a></td>
		</tr>
		 <tr><td><b><%=ee.getCategory()%></b></td> </tr>
		  <tr><td><b><%=ee.getProductname()%></b></td> </tr>
		       <tr><td> <b><%=ee.getProductprice()%> Rs.</b></td>  </tr>
		      
		     
		   <form action="./AddCart" method="post">
         <tr>  <td><b><label>Quantity:<b></label>
		 <input type="number" name="qty" value="1" min="0" ></td></tr>
		 
		 <input type="text" name="pid" value="<%=ee.getPid()%>" hidden /></td></tr>
         <tr>  <td> <button type="submit" name="addcart" class="btn btn-success btn-lg" /> Add To Cart</td></tr>
         </form>
		   
    
     
	 </table>
          
      
       </div>
    <%
	 }
	 %>	
  </div>
  
</div>
<% 
 
 ArrayList<ProductBean> list3=(ArrayList<ProductBean>)request.getAttribute("LIST3");
 
 %>
<div class="container-fluid">
  <h3>Ready to cook</h3>
        
  
     
	<div class="row">
	 <%
 for(ProductBean ee:list3)
   {
	   
	  %>
    <div class="col-lg-3 col-md-4 col-xs-6" >
    
     
	 <table class="set" border="3" >
		<tr><td><a href="ProductDescriptionServlet?productid=<%=ee.getPid()%>"><img src="imgupload/<%=ee.getFilename()%>"  height="150" width="180"/></a></td>
		</tr>
		 <tr><td><b><%=ee.getCategory()%></b></td> </tr>
		  <tr><td><b><%=ee.getProductname()%></b></td> </tr>
		       <tr><td> <b><%=ee.getProductprice()%> Rs.</b></td>  </tr>
		      
		     
		   <form action="./AddCart" method="post">
         <tr>  <td><b><label>Quantity:<b></label>
		 <input type="number" name="qty" value="1" min="0" ></td></tr>
		 
		 <input type="text" name="pid" value="<%=ee.getPid()%>" hidden /></td></tr>
         <tr>  <td> <button type="submit" name="addcart" class="btn btn-success btn-lg" /> Add To Cart</td></tr>
         </form>
		   
    
     
	 </table>
          
      
       </div>
    <%
	 }
	 %>	
  </div>
  
</div>
  
   <%@include file="Footer.jsp" %>
  </body>
</html>