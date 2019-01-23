<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.ArrayList,beans.ProductBean"%>

<%
response.addHeader("pragma","no-cache");
response.addHeader("cache-control","no-store");
response.addHeader("expire","0");
%>

<head>
  
         
  
  
  <style>
  body{
  background:url(images/bg8.jpg);
  background-position: center;
  background-size:cover;
  color:#026836;
  }
  .container
  {
  margin-top:79px;
  }
  h3{
  font-family:comic sans ms,sans-serif;
  background:#f4cb42;
  padding:8px 20px 10px;
  font-weight:bold;
  font-size:24px;
  
  }
  .orange_divider{
  border:2px solid #f05523;
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
  table:hover
  {
  border:3px  violet solid;
  
  }
  <%---.set
  {
  margin:60px;
  border:2px;
  text-align:center;
  font-size:large;
  font-weight:bolder;
  }---%>
  
  </style>
  <title></title>
  <meta charset="utf-8">
 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/chosen.min.css">
        <link rel="stylesheet" href="assets/css/ionicons.min.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/material-design-iconic-font.min.css">
        <link rel="stylesheet" href="assets/css/meanmenu.min.css">
        <link rel="stylesheet" href="assets/css/bundle.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/responsive.css">
        <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>
 
</head>
<body> 
 

<nav class="navbar navbar-light navbar-fixed-top " style="background:#e6ffff;" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <div id="logo" class="fl_left">
      <a class="navbar-brand" href="index.jsp"><img src = "images/zappy-logo.png"></a>
      </div>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">Home</a></li>
      <li><a href="#">What's Zappy</a></li>
      
          <li><a href="#">Spreading zappiness</a></li>
          <li><a href="#">Join us</a></li>
          <li><a href="#">Contact Us</a></li>
          <li><a href="Signup.jsp">Sign Up </a></li>
          <li><a href="Login.jsp">Login</a></li>
     <!-- <li><a href="AddProduct.jsp">Add product details here</a></li>
      <li><a href="ViewProduct">View All product details</a></li>-->
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="ViewCart"><span class="glyphicon glyphicon-shopping-cart"> <span class="cart_count">${count}</span></span><h5> Cart</h5></a></li>
    </ul>
  </div>
</nav>
<% 
	  	String uid=(String)session.getAttribute("uid");
       
	
	   %>
	<% String m=(String)request.getAttribute("msg"); 
    if(m!=null)
    {
  %>	
	<div class="alert alert-success alert-dismissible" style="
    margin-top: 62px;">
  <strong><%=m%></strong> 
</div>
<%
}
    %>
    <div class="inner-container "style="margin:55px;"  >
        <!-- Begin Content -->
         <div class="item-page" itemscope itemtype="http://schema.org/Article">
	<meta itemprop="inLanguage" content="en-GB" />
    
    <div itemprop="articleBody" style="height:265px;">
		<hr class="orange_divider" />
<div class="row content_section">
<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12">
<h2 color="#026836">What is Zappy?</h2>
<p class="para_bold">Zappy is your kitchen convenience partner.</p>
<p>Zappy is an endeavor to bring you the convenience of preparing healthy food that tastes as good as home made. Its also the reason why you feel happy whenever you open a Zappy pack!</p>
</div>
<div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 text-right"><img class="img-responsive" src="images/ping.png" alt="" /></div>
</div>
<hr class="orange_divider" />	</div>

	
						</div>

        <!-- End Content --> 
  
 	 </div>

 <div class="banner_area home1_banner mt-30">
                    <div class="container-fluid">
                        <div class="row" style="margin-top:0px;">
                            <div class="col-lg-4 col-md-6">
                                <div class="single_banner">
                                    <a href="#">
                                        <img src="assets/img/banner/1.jpg" alt="">
                                    </a>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="single_banner">
                                    <a href="#">
                                        <img src="assets/img/banner/2.jpg" alt="">
                                    </a>
                                </div>
                            </div>
                            <div class="col-lg-4 col-md-6">
                                <div class="single_banner banner_three">
                                    <a href="#">
                                        <img src="assets/img/banner/3.jpg" alt="">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--Banner area end-->

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
    <div  class="col-lg-3 col-md-4 col-xs-6">
    
  
    
						 <table class="set" border="3" >
	
		<tr>
		
		<td >  <a href="ProductDescriptionServlet?productid=<%=ee.getPid()%>"><img  src="imgupload/<%=ee.getFilename()%>"  height="150" width="250"/></a></td>
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
		<tr><td><a href="ProductDescriptionServlet?productid=<%=ee.getPid()%>">
		<img src="imgupload/<%=ee.getFilename()%>"  height="150" width="180"/></a></td>
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
  
   <%@include file="Footer.jsp" %>
   
  </body>
  </html>
  