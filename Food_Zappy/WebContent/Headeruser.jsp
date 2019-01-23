<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.ArrayList,beans.ProductBean"%>

<%
response.addHeader("pragma","no-cache");
response.addHeader("cache-control","no-store");
response.addHeader("expire","0");
%>

<head>
  
         
  
  
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
 

<nav class="navbar navbar-light " style="background-color: #f9fd08;" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <div id="logo" class="fl_left">
      <a class="navbar-brand" href="index.jsp"><img src = "images/zappy-logo.png"></a>
      </div>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">Home</a></li>
      <li><a href="about.jsp">What's Zappy</a></li>
      
          <li><a href="spreading.jsp">Spreading zappiness</a></li>
          <li><a href="join us.jsp">Join us</a></li>
          <li><a href="contact us.jsp">Contact Us</a></li>
         <!--   <li><a href="Signup.jsp">Sign Up </a></li>-->
          <li><a href="Login.jsp">Login</a></li>
     <!-- <li><a href="AddProduct.jsp">Add product details here</a></li>
      <li><a href="ViewProduct">View All product details</a></li>-->
    </ul>
   <!--   <ul class="nav navbar-nav navbar-right">
    <li><a href="ViewCart"><span class="glyphicon glyphicon-shopping-cart"> <span class="cart_count">${count}</span></span><h5> Cart</h5></a></li>
    </ul>-->
  </div>
</nav>
</body>
</html>